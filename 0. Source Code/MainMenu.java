import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;


public class MainMenu extends JPanel {
    private JFrame mainFrame;
    private JLabel GameNameLbl;
    private JButton SettingsBtn;
    private JButton QuitBtn;
    private JButton LoadBtn;
    private JPanel MainMenuPnl;
    private JButton StartBtn;


    public MainMenu(JFrame mainFrame) throws IOException {
        this.mainFrame = mainFrame;
        initComponents();
    }

    private void initComponents() throws IOException {
        
        MainMenuPnl = new JPanel();
        GameNameLbl = new JLabel();
        SettingsBtn = new JButton();
        StartBtn = new JButton();
        LoadBtn = new JButton();
        QuitBtn = new JButton();
        
        try {
            Image img = ImageIO.read(getClass().getResource("images/start_button.png"));
            StartBtn.setIcon(new ImageIcon(img));
            StartBtn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
        StartBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    NewGameBtnActionPerformed(evt);
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                
            }
        });
        
        try {
            Image img = ImageIO.read(getClass().getResource("images/load_button.png"));
            LoadBtn.setIcon(new ImageIcon(img));
            LoadBtn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
        
        LoadBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try
                {
                    LoadSvdGameBtnActionPerformed(evt);
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }
        });
        
        try {
            Image img = ImageIO.read(getClass().getResource("images/quit_button.png"));
            QuitBtn.setIcon(new ImageIcon(img));
            QuitBtn.setBorder(null);
          } catch (Exception ex) {
            System.out.println(ex);
          }
        QuitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MainMenuPnlLayout = new GroupLayout(MainMenuPnl);
        MainMenuPnl.setLayout(MainMenuPnlLayout);
        MainMenuPnlLayout.setHorizontalGroup(
                MainMenuPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainMenuPnlLayout.createSequentialGroup()
                                .addGap(150, 150, 150)
                                .addComponent(StartBtn, 300, 300, 300)
                                .addGap(50, 50, 50)
                                .addComponent(LoadBtn, 300, 300, 300)
                                .addGap(50, 50, 50)
                                .addComponent(QuitBtn, 300, 300, 300)
                                .addGap(400, 400, 400))
        );
        MainMenuPnlLayout.setVerticalGroup(
                MainMenuPnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(MainMenuPnlLayout.createSequentialGroup()
                                .addGap(500, 500, 500)
                                .addGroup(MainMenuPnlLayout.createParallelGroup()
                                        .addComponent(StartBtn,100,100,100)
                                        .addComponent(LoadBtn, 100,100,100)
                                        .addComponent(QuitBtn, 100,100,100)))
                               
        );
        JLabel bgImage = new JLabel();
        
        Image img1 = ImageIO.read(getClass().getResource("images/background.png"));
        bgImage.setIcon(new ImageIcon(img1));
        MainMenuPnl.add(bgImage);
        bgImage.setBounds(0, 0, 1274, 720);

        mainFrame.add(MainMenuPnl);
    }
    
    private void NewGameBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        mainFrame.setVisible(false);
        GUIBoard board = new GUIBoard();
        DisplayOptions dispOpt = new DisplayOptions(board);
        
    }
    private void LoadSvdGameBtnActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
        test mytest = new test();
        
        mainFrame.setVisible(false);
        GUIBoard board;
        //board.start();
        //DisplayOptions dispOpt = new DisplayOptions(board);
        board = mytest.loadGame("filename.ser");
        board.setVisible(true);
    }
    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

}