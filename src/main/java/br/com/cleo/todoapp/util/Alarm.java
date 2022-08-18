/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.cleo.todoapp.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Cleo
 */
public class Alarm {

    private Clip clip;

    public Alarm() {
        init();
    }

    private void init() {
        InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("Alarm.wav");
        try {
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(resourceAsStream);
            clip = AudioSystem.getClip();
            clip.open(audioStream);

        } catch (IOException | LineUnavailableException | UnsupportedAudioFileException ex) {
            Logger.getLogger(Alarm.class.getName()).log(Level.SEVERE, "Não Foi Possível ler o audio", ex);
        }
    }

    public void play() {
        clip.setMicrosecondPosition(0);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
        clip.setFramePosition(0);
    }
}
