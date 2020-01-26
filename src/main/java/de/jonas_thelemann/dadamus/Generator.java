package de.jonas_thelemann.dadamus;

import marytts.util.data.audio.MaryAudioUtils;
import org.apache.commons.math3.random.JDKRandomGenerator;
import org.apache.commons.math3.random.RandomGenerator;
import org.audiveris.proxymusic.util.Marshalling;

import javax.sound.sampled.AudioInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

/**
 * The main class, which takes the program's parameters and saves generated audio to file(s).
 */
public class Generator {

    /**
     * Enables setting a seed for the randomness generation.
     */
    public static RandomGenerator randomGenerator;

    /**
     * The main function.
     *
     * @param args An array of arguments. Argument 1: the source file's path. Argument 2: the seed for randomness.
     * @throws IOException If the input file is not found or the output file cannot be created.
     * @throws Marshalling.UnmarshallingException If the input file's unmarshalling fails.
     */
    public static void main(String[] args) throws IOException, Marshalling.UnmarshallingException {
        String sourcePath;

        if (args.length >= 1) {
            sourcePath = args[0];
        } else {
            sourcePath = "src/main/resources/nachtmusik_short_easy.xml";
        }

        if (args.length >= 2) {
            randomGenerator = new JDKRandomGenerator(Integer.parseInt(args[1]));
        } else {
            randomGenerator = new JDKRandomGenerator();
        }

        ArrayList<ArrayList<AudioInputStream>> toneLists = MusicXmlParser.mxmlFileToToneLists(new File(sourcePath));

        for (int i = 0; i < toneLists.size(); i++) {
            AudioInputStream ais = MaryAudioUtils.createSingleAudioInputStream(new Vector<>(toneLists.get(i)));
            MaryAudioUtils.writeWavFile(MaryAudioUtils.getSamplesAsDoubleArray(ais), "target/part_" + i + ".wav", ais.getFormat());
        }
    }
}