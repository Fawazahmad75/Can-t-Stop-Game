import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

/**
 * Write a description of class PlayerSettingsGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DisplaySettingsInGame extends JFrame
{
    private JPanel mainPanel, topPanel;
    private JLabel displayTitle, testLabel, settingsLabel, colourBlindnessLabel, colourBlindnessLabel2;
    
    private JComboBox colourFilterSettings;
    private JButton dcb, tcb, pcb, standard;
    
    
    private String[] filters = {"None", "Deuteranopia", "Tritanopia", "monochromacy"};
    /**
     * Constructor for objects of class PlayerSettingsGUI
     */
    public DisplaySettingsInGame(GUIBoard board)
    {
        
        
        
        this.setSize(600,400);
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        //JComboBox colourFilterSettings = new JComboBox(filters);
        JButton dcb = new JButton("Colour Setting One");
        JButton tcb = new JButton("Colour Setting Two");
        JButton pcb = new JButton("Colour Setting Three");
        JButton standard = new JButton("Default (No Filter)");
        JButton fullScreen = new JButton("Full Screen Mode");
        
        dcb.addActionListener(e-> board.applyDeutFilter());
        tcb.addActionListener(e-> board.applyTritFilter());
        pcb.addActionListener(e-> board.applyProtoFilter());
        standard.addActionListener(e-> board.applyStandardFilter());
        fullScreen.addActionListener(e-> board.fullScreen());
        
        settingsLabel = new JLabel("Colour Filters");
        colourBlindnessLabel = new JLabel("Choosing a filter will change the colours of the game to allow for better distinction.");
        colourBlindnessLabel2 = new JLabel("Each filter will change specific colours to make things easier to tell apart.");
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
        mainPanel.add(settingsLabel);
        mainPanel.add(colourBlindnessLabel);
        mainPanel.add(colourBlindnessLabel2);
        mainPanel.add(standard);
        mainPanel.add(dcb);
        mainPanel.add(tcb);
        mainPanel.add(pcb);
        mainPanel.add(fullScreen);
        
        
        
        
        displayTitle = new JLabel("Display Settings");
        
        topPanel.add(displayTitle);
        
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(mainPanel, BorderLayout.CENTER);
        
        
        setResizable(false);
        setVisible(true);
    }
    
    
    
    
}