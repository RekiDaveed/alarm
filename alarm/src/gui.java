/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Time;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 *
 * @author davee
 */
public class gui extends JFrame {

    // Frame
    private int WIDTH = 800;
    private int HEIGHT = 600;
    private String TITLE = "24 hours Alarm";

    // Buttons + container
    private JPanel Btncontainer = new JPanel();
    protected JButton Startstop = new JButton();
    
    //IMAGES
    ImageIcon icon = new ImageIcon(getClass().getResource("/Clock2.png"));
    
    //Labels
    private JLabel TIME = new JLabel();

    private JLabel HOURSLABEL = new JLabel();
    private JLabel MINUTESLABEL = new JLabel();
    private JLabel SECONDSLABEL = new JLabel();

    public JFormattedTextField HOURSFIELD = new JFormattedTextField();
    public JFormattedTextField MINUTESFIELD = new JFormattedTextField();
    public JFormattedTextField SECONDSFIELD = new JFormattedTextField();

    public JPanel Containerwrapper = new JPanel(new FlowLayout(FlowLayout.CENTER));
    public JPanel Container = new JPanel(); // for the display and input

    public JPanel ParentFrame = new JPanel(); // for vertical stacking 

    public Dimension textfielddimesion = new Dimension(20, 45);
    


    public gui() {
        setTitle(TITLE);
        setSize(WIDTH, HEIGHT); 
        setIconImage(icon.getImage());
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        Startstop.setText("START");
        Startstop.setAlignmentX(CENTER_ALIGNMENT);

        // TIME ZONE - TIME DISPALY
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm:ss a");
        LocalTime datetime = LocalTime.now();
        String formamted = datetime.format(formatter);

        TIME.setText("Current Zone & Time: " + ZonedDateTime.now().getZone().toString() + " " + formamted);
        Font currentfont = TIME.getFont();
        Font newfont = currentfont.deriveFont(20f);
        TIME.setFont(newfont);
        TIME.setHorizontalAlignment(JLabel.CENTER);
        TIME.setAlignmentX(CENTER_ALIGNMENT);


        // VERTICAL STACK ALIGNING parentframe 
        ParentFrame.setLayout(new BoxLayout(ParentFrame, BoxLayout.Y_AXIS));   
        

        // Container and wrapper use the container to hold labels and input then wrapper to hold the container 
        Container.setLayout(new GridLayout(1, 6));
        Container.setBorder(BorderFactory.createLineBorder(Color.black, 0));
        Container.add(HOURSLABEL);
        Container.add(HOURSFIELD);
        Container.add(MINUTESLABEL);
        Container.add(MINUTESFIELD);
        Container.add(SECONDSLABEL);
        Container.add(SECONDSFIELD);
        Container.setPreferredSize(new Dimension(400, 18));
        Container.setMaximumSize(Container.getPreferredSize());
        

        Containerwrapper.setMaximumSize(Containerwrapper.getMaximumSize());
        Containerwrapper.add(Container);

        // BUTTON DESIGN
        

        //

        HOURSLABEL.setText("HOURS:");
        MINUTESLABEL.setText("  MINUTES:");
        SECONDSLABEL.setText("  SECONDS:");

        // initalize last  Parent frame and window
        ParentFrame.add(TIME);
        ParentFrame.add(Box.createVerticalStrut(20));
        ParentFrame.add(Containerwrapper);
        ParentFrame.add(Startstop);

        add(ParentFrame, BorderLayout.CENTER);
        setVisible(true);
        
        
    }
}

class Information extends gui{

    public JFormattedTextField returnHours(){
        return HOURSFIELD;
    }
    public JFormattedTextField returnMinutes(){
        return MINUTESFIELD;
    }
    public JFormattedTextField returnSeconds(){
        return SECONDSFIELD;
    }
    public JButton returnstartstopbtn(){
        return Startstop;
    }
}