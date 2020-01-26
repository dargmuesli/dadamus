package de.jonas_thelemann.dadamus;

import de.jonas_thelemann.dadamus.linguistic.LetterLinguistic;
import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.util.data.audio.SilenceAudioInputStream;
import org.apache.commons.lang.NullArgumentException;
import org.apache.logging.log4j.LogManager;
import org.audiveris.proxymusic.*;
import org.audiveris.proxymusic.util.Marshalling;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.LineUnavailableException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * This class primarily provides a function to create TTS audio from a MusicXML file.
 */
public class MusicXmlParser {

    /**
     * A map of all tones (C1 to B7) to their representing dada word.
     */
    static HashMap<String, String> toneMap = new HashMap<>();

    /**
     * The TTS engine's interface.
     */
    static MaryInterface maryTts;

    /**
     * An iterator for all available TTS voices.
     */
    static Iterator<String> maryVoices;

    /**
     * An unused audio stream from which the format will be taken.
     */
    static AudioInputStream emptyAis;

    static {
        try {
            maryTts = new LocalMaryInterface();
        } catch (MaryConfigurationException e) {
            LogManager.getLogger().error(e);
        }

        maryVoices = maryTts.getAvailableVoices().iterator();
        maryTts.setVoice(maryVoices.next());

        try {
            emptyAis = maryTts.generateAudio("empty");
        } catch (SynthesisException e) {
            LogManager.getLogger().error(e);
        }

        initToneMap();
    }

    /**
     * Initializes the map of all tones.
     */
    private static void initToneMap() {
        final String[] BASIC_TONES = {"C", "D", "E", "F", "G", "A", "B"};

        for (int i = 1; i < 8; i++) {
            for (String basicTone : BASIC_TONES) {
                toneMap.put(basicTone + i, LetterLinguistic.getDistributedWord(32));
            }
        }
    }

    /**
     * Parses a MusicXML file and creates a TTS audio stream from special words for every tone.
     *
     * @param inputFile The MusicXML file to parse.
     * @return A list that contains a list of just described audio streams for every part of the sheet music.
     * @throws Marshalling.UnmarshallingException If the input file's unmarshalling fails.
     * @throws FileNotFoundException If the input file is not found.
     */
    public static ArrayList<ArrayList<AudioInputStream>> mxmlFileToToneLists(File inputFile) throws Marshalling.UnmarshallingException, FileNotFoundException {
        ArrayList<ArrayList<AudioInputStream>> toneLists = new ArrayList<>();

        ScorePartwise scorePartwise = (ScorePartwise) Marshalling.unmarshal(new FileInputStream(inputFile));
        scorePartwise.getPart().forEach(part -> {
            ArrayList<AudioInputStream> tones = new ArrayList<>();

            part.getMeasure().forEach(measure -> measure.getNoteOrBackupOrForward().forEach(o -> {
                if (o instanceof Note) {
                    Note note = (Note) o;
                    String toneKey = "";
                    boolean isRest = false;

                    if (note.getRest() != null) {
                        isRest = true;
                    }

                    if (note.getPitch() != null) {
                        toneKey += note.getPitch().getStep();
                        toneKey += note.getPitch().getOctave();
                    }

                    if (isRest) {
                        LogManager.getLogger().debug("<rest" + note.getDuration().intValue() + ">");
                    } else {
                        LogManager.getLogger().debug(shortenString(toneMap.get(toneKey), note.getDuration().intValue()));
                    }

                    AudioInputStream audioInputStream = null;

                    try {
                        if (isRest) {
                            audioInputStream = new SilenceAudioInputStream(note.getDuration().doubleValue() / 1000, emptyAis.getFormat());
                        } else {
                            audioInputStream = SoundOperations.speed(maryTts.generateAudio(shortenString(toneMap.get(toneKey), note.getDuration().intValue())), note.getDuration().floatValue());
                        }
                    } catch (SynthesisException | LineUnavailableException | IOException e) {
                        LogManager.getLogger().error(e);
                    }

                    if (audioInputStream != null) {
                        tones.add(audioInputStream);
                    } else {
                        throw new NullArgumentException("Could not add tone!");
                    }
                } else if (o instanceof Attributes || o instanceof Barline || o instanceof Print) {
                    LogManager.getLogger().debug("Ignoring object as instance of Attributes, Barline and Print.");
                } else {
                    throw new UnsupportedOperationException("The measure's child element is an unexpected instance.");
                }
            }));

            toneLists.add(tones);

            if (maryVoices.hasNext()) {
                maryTts.setVoice(maryVoices.next());
            }
        });

        return toneLists;
    }

    /**
     * Shortens strings depending on a value.
     *
     * @param input The string to shorten.
     * @param value The value, which defines the substring operation's expanse. In this case a common tone duration.
     * @return The shortened input string.
     */
    public static String shortenString(String input, int value) {
        String result;

        switch (value) {
            case 360:
                result = input.substring(0, 1);
                break;
            case 480:
                result = input.substring(0, 2);
                break;
            case 720:
                result = input.substring(0, 4);
                break;
            case 960:
                result = input.substring(0, 8);
                break;
            case 1440:
                result = input.substring(0, 16);
                break;
            case 1920:
                result = input.substring(0, 32);
                break;
            default:
                throw new UnsupportedOperationException("The value " + value + " is unsupported!");
        }

        return result;
    }
}
