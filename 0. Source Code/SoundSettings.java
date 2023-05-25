import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
import javax.sound.sampled.*;
/**
 * Write a description of class PlayerSettingsGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SoundSettings extends JFrame
{
    private JPanel mainPanel, topPanel;
    private JLabel displayTitle, testLabel, settingsLabel, colourBlindnessLabel;
    
    private JComboBox colourFilterSettings;
    private JButton dcb, tcb, pcb, standard;
    private AudioPlayer audioplayer;
    private String[] filters = {"None", "Deuteranopia", "Tritanopia", "monochromacy"};
    /**
     * Constructor for objects of class PlayerSettingsGUI
     */
    
    
    public SoundSettings(GUIBoard board)
    {
        
        
        this.setSize(600,400);
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        
        
        settingsLabel = new JLabel("Sound Settings");
        //colourBlindnessLabel = new JLabel("Choosing a filter will change the colours of the game to allow for better distinction.");
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(settingsLabel);
        //mainPanel.add(colourBlindnessLabel);
        
        
        
        displayTitle = new JLabel("Sound Settings");
        
        topPanel.add(displayTitle);
        
        JButton Sound1= new JButton("Turn on sound");
        JButton Sound2= new JButton("Turn off sound");
        JButton Sound3= new JButton("Play dreams");
        JButton Sound4= new JButton("Play Jazz");
        JButton Sound5= new JButton("Play Piano");
        JButton Sound6= new JButton("Reset to default");
        mainPanel.add(Sound1);
        mainPanel.add(Sound2);
        mainPanel.add(Sound3);
        mainPanel.add(Sound4);
        mainPanel.add(Sound5);
        mainPanel.add(Sound6);
        Sound1.addActionListener(e-> board.play());
        Sound2.addActionListener(e-> board.pause());
        Sound3.addActionListener(e-> board.track1());
        Sound4.addActionListener(e-> board.track2());
        Sound5.addActionListener(e->board.track3());
        Sound6.addActionListener(e-> board.track2());
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        setResizable(false);
        setVisible(true);
    }
    }