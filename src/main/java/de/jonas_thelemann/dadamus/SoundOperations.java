package de.jonas_thelemann.dadamus;

import com.github.waywardgeek.sonic.Sonic;

import javax.sound.sampled.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Provides a method to change an {@link AudioInputStream}s speed.
 */
class SoundOperations {

    /**
     * Utilizing the <a href="https://github.com/waywardgeek/sonic">Sonic algorithm</a>, this method changes (only) the speed and thus the duration of an {@link AudioInputStream}.
     *
     * @param stream The stream of which the duration is to be changed.
     * @param targetMs The target duration.
     * @return An {@link AudioInputStream}, which is equal to the given {@link AudioInputStream}, but has a given (fixed) duration.
     * @throws IOException If the given stream cannot be read.
     * @throws LineUnavailableException If the {@link AudioSystem} cannot get the required line.
     */
    public static AudioInputStream speed(AudioInputStream stream, float targetMs) throws IOException, LineUnavailableException {
        float durationInMillis = 1000 * stream.getFrameLength() / stream.getFormat().getFrameRate();
        float speed = durationInMillis / targetMs;
        float pitch = 1.0f;
        float rate = 1.0f;
        float volume = 1.0f;
        boolean emulateChordPitch = false;
        int quality = 0;

        AudioFormat format = stream.getFormat();
        int sampleRate = (int) format.getSampleRate();
        int numChannels = format.getChannels();
        SourceDataLine.Info info = new DataLine.Info(SourceDataLine.class, format,
                ((int) stream.getFrameLength() * format.getFrameSize()));
        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        Sonic sonic = new Sonic(sampleRate, numChannels);
        int bufferSize = line.getBufferSize();
        byte[] inBuffer = new byte[bufferSize];
        byte[] outBuffer = new byte[bufferSize];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int numRead, numWritten;

        sonic.setSpeed(speed);
        sonic.setPitch(pitch);
        sonic.setRate(rate);
        sonic.setVolume(volume);
        //noinspection ConstantConditions
        sonic.setChordPitch(emulateChordPitch);
        sonic.setQuality(quality);

        do {
            numRead = stream.read(inBuffer, 0, bufferSize);

            if (numRead <= 0) {
                sonic.flushStream();
            } else {
                sonic.writeBytesToStream(inBuffer, numRead);
            }

            do {
                numWritten = sonic.readBytesFromStream(outBuffer, bufferSize);
                if (numWritten > 0) {
                    baos.write(outBuffer, 0, numWritten);
                }
            } while (numWritten > 0);
        } while (numRead > 0);

        byte[] audioBytes = baos.toByteArray();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(audioBytes);

        return new AudioInputStream(byteArrayInputStream, format, audioBytes.length / format.getFrameSize());
    }
}