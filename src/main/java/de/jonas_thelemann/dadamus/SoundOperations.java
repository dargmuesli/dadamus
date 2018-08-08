package de.jonas_thelemann.dadamus;

import marytts.LocalMaryInterface;
import marytts.MaryInterface;
import marytts.util.data.audio.MaryAudioUtils;
import marytts.util.data.audio.SilenceAudioInputStream;

import javax.sound.sampled.AudioInputStream;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SoundOperations {
  static void maryIt(String input) throws Exception {
    String[] data = input.split("\\(pause\\[.+?\\]\\)");

    List<String> allMatches = new ArrayList<String>();
    Matcher m = Pattern.compile("\\(pause\\[.+?\\]\\)").matcher(input);

    while (m.find()) {
      allMatches.add(m.group());
    }

    MaryInterface marytts = new LocalMaryInterface();

    Set<String> voices = marytts.getAvailableVoices();
    marytts.setVoice(voices.iterator().next());

    AudioInputStream audio = marytts.generateAudio(data[0]);

    SilenceAudioInputStream silence = new SilenceAudioInputStream(1.0, audio.getFormat());

    AudioInputStream appendedFiles = new AudioInputStream(new SequenceInputStream(audio, silence), audio.getFormat(), audio.getFrameLength() + silence.getFrameLength());

    silence.close();

    MaryAudioUtils.writeWavFile(MaryAudioUtils.getSamplesAsDoubleArray(appendedFiles), "output.wav", audio.getFormat());
  }
}