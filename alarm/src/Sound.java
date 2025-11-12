/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author davee
 */
public class Sound {


    

    public void soundtoplay () throws LineUnavailableException, InterruptedException{

    URL soundUrl = getClass().getClassLoader().getResource("Sound1.wav");
        try (AudioInputStream AIS = AudioSystem.getAudioInputStream(soundUrl)) {
            DataLine.Info info = new DataLine.Info(Clip.class, AIS.getFormat());
            var clip = (Clip) AudioSystem.getLine(info);
            clip.open(AIS);
            clip.start();
            Thread.sleep(5000);
            clip.close();

        } catch (UnsupportedAudioFileException | IOException e) {
            System.out.println(e);
        }
    }

}
