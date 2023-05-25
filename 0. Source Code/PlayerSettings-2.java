import java.awt.*;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PlayerSettings extends JFrame {
    private JPanel PlrSettPnl;
    private JComboBox<Integer> num_of_players;
    private JComboBox<Integer> num_of_bots;   
    private JComboBox<String> difficulty;
    private ArrayList<Player> PlayerList = new ArrayList<Player>();
    public String difficultylevel;
    JPanel plrPanel1;
    JPanel plrPanel2;
    JPanel plrPanel3;
    JPanel plrPanel4;
    
    JTextField plrName1;
    JTextField plrAge1;
    JComboBox<String> colors1;
    JTextField plrName2;
    JTextField plrAge2;
    JComboBox<String> colors2;
    JTextField plrName3;
    JTextField plrAge3;
    JComboBox<String> colors3;
    JTextField plrName4;
    JTextField plrAge4;
    JComboBox<String> colors4;
    
    JLabel numBotlabel;
    JLabel difflabel;
    Integer[] numbot;
    
    JLabel errorLbl = new JLabel();
    
    public PlayerSettings(GUIBoard board) throws IOException {
        this.setTitle("Player Settings");
        this.setVisible(true);
        this.setSize(1274,720);
        initComponents(board);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
    
    private void initComponents(GUIBoard board) throws IOException {
        PlrSettPnl = new JPanel(new BorderLayout());
        
        
        JPanel buttonPnl = new JPanel(new FlowLayout());
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    backButtonActionPerformed(evt, board);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        buttonPnl.add(backButton);
        
        JButton startButton = new JButton("Start Game");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    startButtonActionPerformed(evt, board);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        buttonPnl.add(startButton);
        PlrSettPnl.add("South",buttonPnl);
        
        JPanel centerPanel = new JPanel(new BorderLayout());
        
        JPanel centerTopPanel = new JPanel(new GridLayout());
          
        JPanel numPlrPanel = new JPanel(new FlowLayout());
        JLabel numPlrlabel = new JLabel();
        num_of_players = new JComboBox<Integer>();
        numPlrlabel.setText("Number of Players:");
        numPlrlabel.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        num_of_players.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { null,2,3,4 }));
        num_of_players.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num_of_playersCmbActionPerformed(evt);
            }
        });
        numPlrPanel.add(numPlrlabel);
        numPlrPanel.add(num_of_players);
        
        JPanel numBotPanel = new JPanel(new FlowLayout());
        numBotlabel = new JLabel();
        num_of_bots = new JComboBox<Integer>();
        numBotlabel.setText("Number of Bots:");
        numBotlabel.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        num_of_bots.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] {0}));
        num_of_bots.setEnabled(false);
        numBotlabel.setEnabled(false);
        num_of_bots.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                num_of_BotsCmbActionPerformed(evt);
            }
        });
        numBotPanel.add(numBotlabel);
        numBotPanel.add(num_of_bots);
        
        JPanel diffPanel = new JPanel(new FlowLayout());
        difflabel = new JLabel();
        difficulty = new JComboBox<String>();
        difflabel.setText("Difficulty level:");
        difflabel.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        difficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "easy","medium", "hard" }));
        difficulty.setEnabled(false);
        difflabel.setEnabled(false);
        diffPanel.add(difflabel);
        diffPanel.add(difficulty);
        
        
        centerTopPanel.add(numPlrPanel);
        centerTopPanel.add(numBotPanel);
        centerTopPanel.add(diffPanel);
        
        centerPanel.add("North",centerTopPanel);
        
        
        JPanel centerPlrPanel = new JPanel(new GridLayout(2,2));
        
        // Player 1
        plrPanel1 = new JPanel(new GridLayout(4,1));
        JPanel plrLabelPanel1 = new JPanel(new FlowLayout());
        JLabel Plr1 = new JLabel("Player 1");
        Plr1.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        plrLabelPanel1.add(Plr1);
        JPanel infoPnl1 = new JPanel(new GridLayout(2,2));
        JPanel nameLabelPanel1 = new JPanel(new BorderLayout());
        JLabel nameLbl1 = new JLabel("Name: ");
        nameLbl1.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        nameLabelPanel1.add("East",nameLbl1);
        plrName1 = new JTextField();
        plrName1.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        plrAge1 = new JTextField();
        plrAge1.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        JPanel ageLabelPanel1 = new JPanel(new BorderLayout());
        JLabel ageLbl1 = new JLabel("Age: ");
        ageLbl1.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        ageLabelPanel1.add("East",ageLbl1);
        infoPnl1.add(nameLabelPanel1);
        infoPnl1.add(plrName1);
        infoPnl1.add(ageLabelPanel1);
        infoPnl1.add(plrAge1);
        JPanel colorLabelPanel1 = new JPanel(new BorderLayout());
        JPanel colorPnl1 = new JPanel(new GridLayout(1,2));
        JLabel colorLbl1 = new JLabel("Color: ");
        colorLbl1.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        colorLabelPanel1.add("East",colorLbl1);
        colors1 = new JComboBox<String>();
        colors1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-select-", "blue","red", "green", "yellow" }));
        colorPnl1.add(colorLabelPanel1);
        colorPnl1.add(colors1);
        plrPanel1.add(plrLabelPanel1);
        plrPanel1.add(infoPnl1);
        plrPanel1.add(colorPnl1);
        plrName1.setText("player1");
        plrAge1.setText("0");
        centerPlrPanel.add(plrPanel1);

        
        // Player 2
        plrPanel2 = new JPanel(new GridLayout(4,1));
        JPanel plrLabelPanel2 = new JPanel(new FlowLayout());
        JLabel Plr2 = new JLabel("Player 2");
        Plr2.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        plrLabelPanel2.add(Plr2);
        JPanel infoPnl2 = new JPanel(new GridLayout(2,2));
        JPanel nameLabelPanel2 = new JPanel(new BorderLayout());
        JLabel nameLbl2 = new JLabel("Name: ");
        nameLbl2.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        nameLabelPanel2.add("East",nameLbl2);
        plrName2 = new JTextField();
        plrName2.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        plrAge2 = new JTextField();
        plrAge2.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        JPanel ageLabelPanel2 = new JPanel(new BorderLayout());
        JLabel ageLbl2 = new JLabel("Age: ");
        ageLbl2.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        ageLabelPanel2.add("East",ageLbl2);
        infoPnl2.add(nameLabelPanel2);
        infoPnl2.add(plrName2);
        infoPnl2.add(ageLabelPanel2);
        infoPnl2.add(plrAge2);
        JPanel colorLabelPanel2 = new JPanel(new BorderLayout());
        JPanel colorPnl2 = new JPanel(new GridLayout(1,2));
        JLabel colorLbl2 = new JLabel("Color: ");
        colorLbl2.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        colorLabelPanel2.add("East",colorLbl2);
        colors2 = new JComboBox<String>();
        colors2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-select-", "blue","red", "green", "yellow" }));
        colorPnl2.add(colorLabelPanel2);
        colorPnl2.add(colors2);
        plrPanel2.add(plrLabelPanel2);
        plrPanel2.add(infoPnl2);
        plrPanel2.add(colorPnl2);
        plrName2.setText("player2");
        plrAge2.setText("0");
        centerPlrPanel.add(plrPanel2);
        
        
        // Player 3
        plrPanel3 = new JPanel(new GridLayout(4,1));
        JPanel plrLabelPanel3 = new JPanel(new FlowLayout());
        JLabel Plr3 = new JLabel("Player 3");
        Plr3.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        plrLabelPanel3.add(Plr3);
        JPanel infoPnl3 = new JPanel(new GridLayout(2,2));
        JPanel nameLabelPanel3 = new JPanel(new BorderLayout());
        JLabel nameLbl3 = new JLabel("Name: ");
        nameLbl3.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        nameLabelPanel3.add("East",nameLbl3);
        plrName3 = new JTextField();
        plrName3.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        plrAge3 = new JTextField();
        plrAge3.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        JPanel ageLabelPanel3 = new JPanel(new BorderLayout());
        JLabel ageLbl3 = new JLabel("Age: ");
        ageLbl3.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        ageLabelPanel3.add("East",ageLbl3);
        infoPnl3.add(nameLabelPanel3);
        infoPnl3.add(plrName3);
        infoPnl3.add(ageLabelPanel3);
        infoPnl3.add(plrAge3);
        JPanel colorLabelPanel3 = new JPanel(new BorderLayout());
        JPanel colorPnl3 = new JPanel(new GridLayout(1,2));
        JLabel colorLbl3 = new JLabel("Color: ");
        colorLbl3.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        colorLabelPanel3.add("East",colorLbl3);
        colors3 = new JComboBox<String>();
        colors3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-select-", "blue","red", "green", "yellow" }));
        colorPnl3.add(colorLabelPanel3);
        colorPnl3.add(colors3);
        plrPanel3.add(plrLabelPanel3);
        plrPanel3.add(infoPnl3);
        plrPanel3.add(colorPnl3);
        plrName3.setText("player3");
        plrAge3.setText("0");
        centerPlrPanel.add(plrPanel3);
        
        
        // Player 4
        plrPanel4 = new JPanel(new GridLayout(4,1));
        JPanel plrLabelPanel4 = new JPanel(new FlowLayout());
        JLabel Plr4 = new JLabel("Player 4");
        Plr4.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        plrLabelPanel4.add(Plr4);
        JPanel infoPnl4 = new JPanel(new GridLayout(2,2));
        JPanel nameLabelPanel4 = new JPanel(new BorderLayout());
        JLabel nameLbl4 = new JLabel("Name: ");
        nameLbl4.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        nameLabelPanel4.add("East",nameLbl4);
        plrName4 = new JTextField();
        plrName4.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        plrAge4 = new JTextField();
        plrAge4.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        JPanel ageLabelPanel4 = new JPanel(new BorderLayout());
        JLabel ageLbl4 = new JLabel("Age: ");
        ageLbl4.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        ageLabelPanel4.add("East",ageLbl4);
        infoPnl4.add(nameLabelPanel4);
        infoPnl4.add(plrName4);
        infoPnl4.add(ageLabelPanel4);
        infoPnl4.add(plrAge4);
        JPanel colorLabelPanel4 = new JPanel(new BorderLayout());
        JPanel colorPnl4 = new JPanel(new GridLayout(1,2));
        JLabel colorLbl4 = new JLabel("Color: ");
        colorLbl4.setFont(new Font("Chalkboard", Font.PLAIN, 30));
        colorLabelPanel4.add("East",colorLbl4);
        colors4 = new JComboBox<String>();
        colors4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-select-","blue","red", "green", "yellow" }));
        colorPnl4.add(colorLabelPanel4);
        colorPnl4.add(colors4);
        plrPanel4.add(plrLabelPanel4);
        plrPanel4.add(infoPnl4);
        plrPanel4.add(colorPnl4);
        plrName4.setText("player4");
        plrAge4 .setText("0");
        centerPlrPanel.add(plrPanel4);
        
        
        JPanel errPanel = new JPanel(new FlowLayout());
        errorLbl.setForeground(Color.RED);
        errorLbl.setVisible(false);
        errPanel.add(errorLbl);
        centerPanel.add("South",errPanel);
        centerPanel.add("Center",centerPlrPanel);
        PlrSettPnl.add(centerPanel);
        
        
        plrPanel1.setVisible(false);
        plrPanel2.setVisible(false);
        plrPanel3.setVisible(false);
        plrPanel4.setVisible(false);
        
        
        this.add(PlrSettPnl);
        
    }
    
    
    public String getDifficulty() {
        String[] diffs = new String[] { "easy","medium", "hard" };
        return diffs[difficulty.getSelectedIndex()];
    }
    public Integer getNumBots() {
        return numbot[num_of_bots.getSelectedIndex()];
    }
    public Integer getNumPlayers() {
        Integer[] plrs = new Integer[] { null,2,3,4 };
        return plrs[num_of_players.getSelectedIndex()];
    }
    
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt, GUIBoard board) throws IOException {
        this.setVisible(false);
        DisplayOptions dispOpt = new DisplayOptions(board);
    }
    
    private void makePlayers(GUIBoard board){
        Color[] colors = new Color[] {Color.WHITE,Color.BLUE,Color.RED, Color.GREEN, Color.YELLOW};
        
        if(!plrName1.getText().equals("null")) {
            Player plr1;
            if(plrAge1.getText().equals("null")) {
                plr1 = new Player(1,plrName1.getText(),false,Integer.valueOf(plrAge1.getText()),colors[colors1.getSelectedIndex()]);
            }
            else {
                plr1 = new Player(1,plrName1.getText(),false,0,colors[colors1.getSelectedIndex()]);
            }
            this.PlayerList.add(plr1);
        }
        if(!plrName2.getText().equals("null")) {
            Player plr2;
            if(!plrAge2.getText().equals("null")) {
                plr2 = new Player(2,plrName2.getText(),false,Integer.valueOf(plrAge2.getText()),colors[colors2.getSelectedIndex()]);
            }
            else {
                plr2 = new Player(2,plrName2.getText(),false,0,colors[colors2.getSelectedIndex()]);
            }
            this.PlayerList.add(plr2);
        }
        if(!plrName3.getText().equals("null")) {
            Player plr3;
            if(!plrAge3.getText().equals("null")) {
                plr3 = new Player(3,plrName3.getText(),false,Integer.valueOf(plrAge3.getText()),colors[colors3.getSelectedIndex()]);
            }
            else {
                plr3 = new Player(3,plrName3.getText(),false,0,colors[colors3.getSelectedIndex()]);
            }
            this.PlayerList.add(plr3);
        }
        if(!plrName4.getText().equals("null")) {
            Player plr4;
            if(!plrAge4.getText().equals("null")) {
                plr4 = new Player(4,plrName4.getText(),false,Integer.valueOf(plrAge4.getText()),colors[colors4.getSelectedIndex()]);
            }
            else {
                plr4 = new Player(4,plrName4.getText(),false,0,colors[colors4.getSelectedIndex()]);
            }
            this.PlayerList.add(plr4);
            
        }
        checkBots();
    }
    
    private void checkBots(){
        int numBots = num_of_bots.getSelectedIndex();
        
        int count = 0;
        for(int i=PlayerList.size()-1;i>=0;i--) {
            if(count>=numBots) {
                break;
            }
            else {
                PlayerList.get(i).setBot(true);
            }
            count++;
        }
    }
     
    private void startgame(GUIBoard board) {
        this.setVisible(false);
        this.makePlayers(board);
        for(int i=0;i<PlayerList.size();i++) {
            System.out.println(PlayerList.get(i).name+" "+PlayerList.get(i).bot.toString());
        }
        board.generatePlayers(PlayerList);
        board.start();
        
    }
    
    
    private void startButtonActionPerformed(java.awt.event.ActionEvent evt, GUIBoard board) throws IOException {
        // TODO        
        int numPlr = num_of_players.getSelectedIndex() +1;
        if(numPlr == 2) {
            if(colors1.getSelectedIndex() != 0 && colors2.getSelectedIndex() != 0) {    
                if(colors1.getSelectedIndex() != colors2.getSelectedIndex()) {
                    startgame(board);
                }
                else {
                    errorLbl.setText("Please select different colors.");
                    errorLbl.setVisible(true);
                }
            }
            else {
                errorLbl.setText("Please specify colors");
                errorLbl.setVisible(true);
            }
        }
        else if(numPlr == 3) {
            if(colors1.getSelectedIndex() != 0 && colors2.getSelectedIndex() != 0 && colors3.getSelectedIndex() != 0) {    
                if(colors1.getSelectedIndex() != colors2.getSelectedIndex() 
                        && colors1.getSelectedIndex() != colors3.getSelectedIndex()
                        && colors2.getSelectedIndex() != colors3.getSelectedIndex()) {
                    startgame(board);
                }
                else {
                    errorLbl.setText("Please select different colors.");
                    errorLbl.setVisible(true);
                }
            }
            else {
                errorLbl.setText("Please specify colors");
                errorLbl.setVisible(true);
            }
        }
        else if(numPlr == 4) {
            if(colors1.getSelectedIndex() != 0 && colors2.getSelectedIndex() != 0 && colors3.getSelectedIndex() != 0 && colors4.getSelectedIndex() != 0) {    
                if(colors1.getSelectedIndex() != colors2.getSelectedIndex() 
                        && colors1.getSelectedIndex() != colors3.getSelectedIndex() 
                        && colors1.getSelectedIndex() != colors4.getSelectedIndex() 
                        && colors2.getSelectedIndex() != colors3.getSelectedIndex()
                        && colors2.getSelectedIndex() != colors4.getSelectedIndex() 
                        && colors3.getSelectedIndex() != colors4.getSelectedIndex()) {
                    startgame(board);
                }
                else {
                    errorLbl.setText("Please select different colors.");
                    errorLbl.setVisible(true);
                }
            }
            else {
                errorLbl.setText("Please specify colors");
                errorLbl.setVisible(true);
            }
        }
            
    }
    
    private void num_of_playersCmbActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int numPlr = num_of_players.getSelectedIndex() +1;
        int numBots = num_of_bots.getSelectedIndex();
        numbot = new Integer[numPlr+1];
        numbot[0] = 0;
        for(int i=1;i<=numPlr;i++) {
            numbot[i] = i;
        }
        if (numPlr<2){
            num_of_bots.setEnabled(false);
            numBotlabel.setEnabled(false);
            difficulty.setEnabled(false);
            difflabel.setEnabled(false);
            
            
            plrName1.setText("null");
            plrAge1.setText("null");
            plrName2.setText("null");
            plrAge2.setText("null");
            plrName3.setText("null");
            plrAge3.setText("null");
            plrName4.setText("null");
            plrAge4.setText("null");
            plrPanel1.setVisible(false);
            plrPanel2.setVisible(false);
            plrPanel3.setVisible(false);
            plrPanel4.setVisible(false);
        }else{
            num_of_bots.setEnabled(true);
            numBotlabel.setEnabled(true);
            num_of_bots.setModel(new javax.swing.DefaultComboBoxModel<>(numbot));
            num_of_bots.setSelectedItem(numBots);

        }
        
        if(numPlr==2) {
            
            plrName1.setText("player1");
            plrAge1.setText("0");
            plrPanel1.setVisible(true);
            plrName1.setEnabled(true);
            plrAge1.setEnabled(true);
            plrName2.setText("player2");
            plrAge2.setText("0");
            plrPanel2.setVisible(true);
            plrName2.setEnabled(true);
            plrAge2.setEnabled(true);
            plrName3.setText("null");
            plrAge3.setText("null");
            plrPanel3.setVisible(false);
            plrName4.setText("null");
            plrAge4.setText("null");
            plrPanel4.setVisible(false);
            
            if(numBots == 1) {
                plrName2.setText("Bot");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
            }
            else if(numBots == 2) {
                plrName1.setText("Bot1");
                plrAge1.setText("0");
                plrName1.setEnabled(false);
                plrAge1.setEnabled(false);
                plrName2.setText("Bot2");
                plrAge2.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            num_of_bots.setSelectedItem(numBots);
        }
        else if(numPlr==3) {
            plrName1.setText("player1");
            plrAge1.setText("0");
            plrPanel1.setVisible(true);
            plrName1.setEnabled(true);
            plrAge1.setEnabled(true);
            plrName2.setText("player2");
            plrAge2.setText("0");
            plrPanel2.setVisible(true);
            plrName2.setEnabled(true);
            plrAge2.setEnabled(true);
            plrName3.setText("player3");
            plrAge3.setText("0");
            plrPanel3.setVisible(true);
            plrName3.setEnabled(true);
            plrAge3.setEnabled(true);
            plrName4.setText("null");
            plrAge4.setText("null");
            plrPanel4.setVisible(false);
            
            if(numBots == 1) {
                plrName3.setText("Bot");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
            }
            else if(numBots == 2) {
                plrName2.setText("Bot1");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
                plrName3.setText("Bot2");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
            }
            else if(numBots == 3) {
                plrName1.setText("Bot1");
                plrAge1.setText("0");
                plrName1.setEnabled(false);
                plrAge1.setEnabled(false);
                plrName2.setText("Bot2");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
                plrName3.setText("Bot3");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
            }
            num_of_bots.setSelectedItem(numBots);
        }
        else if(numPlr==4) {
            plrName1.setText("player1");
            plrAge1.setText("0");
            plrName1.setEnabled(true);
            plrAge1.setEnabled(true);
            plrPanel1.setVisible(true);
            plrName2.setText("player2");
            plrAge2.setText("0");
            plrPanel2.setVisible(true);
            plrName2.setEnabled(true);
            plrAge2.setEnabled(true);
            plrName3.setText("player3");
            plrAge3.setText("0");
            plrPanel3.setVisible(true);
            plrName3.setEnabled(true);
            plrAge3.setEnabled(true);
            plrName4.setText("player4");
            plrAge4.setText("0");
            plrPanel4.setVisible(true);
            plrName4.setEnabled(true);
            plrAge4.setEnabled(true);
            
            if(numBots == 1) {
                plrName4.setText("Bot");
                plrAge4.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            else if(numBots == 2) {
                plrName3.setText("Bot1");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
                plrName4.setText("Bot2");
                plrAge4.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            else if(numBots == 3) {
                plrName2.setText("Bot1");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
                plrName3.setText("Bot2");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
                plrName4.setText("Bot3");
                plrAge4.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            else if(numBots == 4) {
                plrName1.setText("Bot1");
                plrAge1.setText("0");
                plrName1.setEnabled(false);
                plrAge1.setEnabled(false);
                plrName2.setText("Bot2");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
                plrName3.setText("Bot3");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
                plrName4.setText("Bot4");
                plrAge4.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            num_of_bots.setSelectedItem(numBots);
        }
        
        
    }
    
    private void num_of_BotsCmbActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        int numPlr = num_of_players.getSelectedIndex() +1;
        int numBots = num_of_bots.getSelectedIndex();
        //MainMenu.setCompPlayerNumber(numPlr);;
        if (numBots==0){
            difficulty.setEnabled(false);
            difflabel.setEnabled(false);
        }else{
            difficulty.setEnabled(true);
            difflabel.setEnabled(true);
        }
        
        if (numPlr<2){
            num_of_bots.setEnabled(false);
            numBotlabel.setEnabled(false);
            difficulty.setEnabled(false);
            difflabel.setEnabled(false);
            
            
            plrName1.setText("null");
            plrAge1.setText("null");
            plrName2.setText("null");
            plrAge2.setText("null");
            plrName3.setText("null");
            plrAge3.setText("null");
            plrName4.setText("null");
            plrAge4.setText("null");
            plrPanel1.setVisible(false);
            plrPanel2.setVisible(false);
            plrPanel3.setVisible(false);
            plrPanel4.setVisible(false);
        }else{
            num_of_bots.setEnabled(true);
            numBotlabel.setEnabled(true);
            num_of_bots.setModel(new javax.swing.DefaultComboBoxModel<>(numbot));
            num_of_bots.setSelectedItem(numBots);

        }
        
        if(numPlr==2) {
            
            plrName1.setText("player1");
            plrAge1.setText("0");
            plrPanel1.setVisible(true);
            plrName1.setEnabled(true);
            plrAge1.setEnabled(true);
            plrName2.setText("player2");
            plrAge2.setText("0");
            plrPanel2.setVisible(true);
            plrName2.setEnabled(true);
            plrAge2.setEnabled(true);
            plrName3.setText("null");
            plrAge3.setText("null");
            plrPanel3.setVisible(false);
            plrName4.setText("null");
            plrAge4.setText("null");
            plrPanel4.setVisible(false);
            
            if(numBots == 1) {
                plrName2.setText("Bot");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
            }
            else if(numBots == 2) {
                plrName1.setText("Bot1");
                plrAge1.setText("0");
                plrName1.setEnabled(false);
                plrAge1.setEnabled(false);
                plrName2.setText("Bot2");
                plrAge2.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            num_of_bots.setSelectedItem(numBots);
        }
        else if(numPlr==3) {
            plrName1.setText("player1");
            plrAge1.setText("0");
            plrPanel1.setVisible(true);
            plrName1.setEnabled(true);
            plrAge1.setEnabled(true);
            plrName2.setText("player2");
            plrAge2.setText("0");
            plrPanel2.setVisible(true);
            plrName2.setEnabled(true);
            plrAge2.setEnabled(true);
            plrName3.setText("player3");
            plrAge3.setText("0");
            plrPanel3.setVisible(true);
            plrName3.setEnabled(true);
            plrAge3.setEnabled(true);
            plrName4.setText("null");
            plrAge4.setText("null");
            plrPanel4.setVisible(false);
            
            if(numBots == 1) {
                plrName3.setText("Bot");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
            }
            else if(numBots == 2) {
                plrName2.setText("Bot1");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
                plrName3.setText("Bot2");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
            }
            else if(numBots == 3) {
                plrName1.setText("Bot1");
                plrAge1.setText("0");
                plrName1.setEnabled(false);
                plrAge1.setEnabled(false);
                plrName2.setText("Bot2");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
                plrName3.setText("Bot3");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
            }
            num_of_bots.setSelectedItem(numBots);
        }
        else if(numPlr==4) {
            plrName1.setText("player1");
            plrAge1.setText("0");
            plrName1.setEnabled(true);
            plrAge1.setEnabled(true);
            plrPanel1.setVisible(true);
            plrName2.setText("player2");
            plrAge2.setText("0");
            plrPanel2.setVisible(true);
            plrName2.setEnabled(true);
            plrAge2.setEnabled(true);
            plrName3.setText("player3");
            plrAge3.setText("0");
            plrPanel3.setVisible(true);
            plrName3.setEnabled(true);
            plrAge3.setEnabled(true);
            plrName4.setText("player4");
            plrAge4.setText("0");
            plrPanel4.setVisible(true);
            plrName4.setEnabled(true);
            plrAge4.setEnabled(true);
            
            if(numBots == 1) {
                plrName4.setText("Bot");
                plrAge4.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            else if(numBots == 2) {
                plrName3.setText("Bot1");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
                plrName4.setText("Bot2");
                plrAge4.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            else if(numBots == 3) {
                plrName2.setText("Bot1");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
                plrName3.setText("Bot2");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
                plrName4.setText("Bot3");
                plrAge4.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            else if(numBots == 4) {
                plrName1.setText("Bot1");
                plrAge1.setText("0");
                plrName1.setEnabled(false);
                plrAge1.setEnabled(false);
                plrName2.setText("Bot2");
                plrAge2.setText("0");
                plrName2.setEnabled(false);
                plrAge2.setEnabled(false);
                plrName3.setText("Bot3");
                plrAge3.setText("0");
                plrName3.setEnabled(false);
                plrAge3.setEnabled(false);
                plrName4.setText("Bot4");
                plrAge4.setText("0");
                plrName4.setEnabled(false);
                plrAge4.setEnabled(false);
            }
            num_of_bots.setSelectedItem(numBots);
            
        }
    }
}
