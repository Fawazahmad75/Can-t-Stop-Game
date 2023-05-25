import java.awt.*;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;

import javax.imageio.ImageIO;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayOptions  extends JFrame{
    private JPanel DispSettPanel;
    
    private JPanel mainPanel, topPanel;
    private JLabel displayTitle, testLabel, settingsLabel, colourBlindnessLabel, colourBlindnessLabel2;
    
    private JComboBox colourFilterSettings;
    private JButton dcb, tcb, pcb, standard;
    
    
    private String[] filters = {"None", "Protanopia", "Tritanopia", "monochromacy"};
    
    public DisplayOptions(GUIBoard board) throws IOException {
    
    this.setTitle("Display Options");
        this.setVisible(true);
        this.setSize(1274,720);
        
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        
        
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
        
        settingsLabel = new JLabel("Colourblind Filters");
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
        
        
        initComponents(board);        
        
        
        
    }
    
    private void initComponents(GUIBoard board) throws IOException {
        DispSettPanel = new JPanel(new BorderLayout());
        
        
        JPanel buttonPnl = new JPanel(new FlowLayout());
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    backButtonActionPerformed(evt);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        buttonPnl.add(backButton);
        
        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    nextButtonActionPerformed(evt, board);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        buttonPnl.add(nextButton);
        
        getContentPane().add(buttonPnl, BorderLayout.SOUTH);
        //DispSettPanel.add("South",buttonPnl);
        
        
        //this.add(DispSettPanel);
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        this.setVisible(false);
        Window window = new Window(); 
    }
    
    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt, GUIBoard board) throws IOException {
        this.setVisible(false);
        PlayerSettings plrSettings = new PlayerSettings(board); 
    }
}