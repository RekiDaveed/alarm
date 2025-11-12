/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.event.ActionEvent;
import java.util.function.IntFunction;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;


/**
 *
 * @author davee
 * 
 * 
 */
public class backend { 


    Information info = new Information();
    Sound sound = new Sound();

    private JButton Startstop = info.returnstartstopbtn();

    private String FormatedAlarm;

    private int HourCycle = 3600000;
    private int MinuteCycle = 60000;
    private int SecondCycle = 1000;

    
    public backend() throws InterruptedException{

    Startstop.addActionListener((var e) ->{
        JFormattedTextField Hoursfield = info.returnHours();
        JFormattedTextField Minutesfield = info.returnMinutes();
        JFormattedTextField Secondsfield = info.returnSeconds();

        String hourstring = Hoursfield.getText().trim();
        String minuteString = Minutesfield.getText().trim();
        String secondstring = Secondsfield.getText().trim();

        try {
            int Hoursint = Integer.parseInt(hourstring);
            int Minutesint = Integer.parseInt(minuteString);
            int Secondsint = Integer.parseInt(secondstring);

            if(Hoursint < 0 || Hoursint > 23 ||
                Minutesint < 0 || Minutesint > 59 ||
                Secondsint < 0 || Secondsint > 59){
                System.out.println("Stay in range -> 23:59:59");
            } else {
                FormatedAlarm = String.format("%02d:%02d:%02d", Hoursint, Minutesint, Secondsint);
                System.out.println("Alarm Set for " + FormatedAlarm + " !!"); 

                while(Hoursint > 0 || Minutesint > 0 || Secondsint > 0){

                    Thread.sleep(SecondCycle);
                
                    if (Secondsint > 0) {
                        Secondsint--;
                    } else if (Minutesint > 0) {
                        Minutesint--;
                        Secondsint = 59; 
                    } else if (Hoursint > 0) {
                        Hoursint--;
                        Minutesint = 59; 
                        Secondsint = 59;
                    }

                    FormatedAlarm = String.format("%02d:%02d:%02d", Hoursint, Minutesint, Secondsint);
                    System.out.println("-> " + FormatedAlarm);

                }
                
                System.out.println("");
                System.out.println("DONE ");

                try {
                    sound.soundtoplay();
                } catch (LineUnavailableException e1) {

                }

            }
            
        } catch (NumberFormatException error) {
            System.err.println("Enter a Valid 24 Time format or 0 for each field");
        } catch (InterruptedException ex) {
        } 
      
    });
    
      


    }
  
}

