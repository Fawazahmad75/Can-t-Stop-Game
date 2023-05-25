import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.IOException;

public class GUIBoard extends JFrame implements ActionListener, MouseListener

{
    private int column1;
    private int column2;
    private JButton SaveButton;
    
    private ArrayList<Integer> columnList;
    
    private JButton reChooseButton, closeButton;
    
    private ArrayList<BoardSpace> activeSpaces;
    private ArrayList<Integer> resultList;
    private ArrayList<Integer> scoreList;
    private ArrayList<Color> colourList;
    private ArrayList<BoardSpace> currentColumn;
    private ArrayList<BoardSpace> tempColumn;
    BoardSpace bottomSpace1;
    BoardSpace bottomSpace2;
    BoardSpace bottomSpace3;
    BoardSpace bottomSpace4;
    BoardSpace bottomSpaceA;
    BoardSpace bottomSpaceB;
    BoardSpace bottomSpaceC;
    BoardSpace bottomSpaceD;
    private int playerCount;
    
    Color currColour = Color.red;
    private ArrayList<Player> playerList;
    
    private JPanel topPanel, centrePanel, bottomPanel, rightPanel, playerPanel, subPanel;    
    private JLabel titleLabel, die1, die2, die3, die4, playerLabel;
    private int rows = 13;
    private int columns = 13;
    private JLabel diceLabel, combinationsTitle, score1, score2, invalidLabel;
    private int result;
    private BoardSpace[][] boardSpaces;
    private int upperBound = 5;
    private int lowerBound = 5;
    private JButton settingsButton, soundbutton, rollButton, resultButton1, resultButton2, resultButton3, resultButton4, advanceButton, rollReset;
    private int result1, result2, result3, result4;
    private int counter = 0;
    
    private ArrayList<Integer> keepList;
    private JLabel rerollTitle;
    private JButton confirmDice;
    private boolean rolled = false, clicked1 = false, clicked2= false, clicked3=false, clicked4=false;
    private ArrayList<Integer> finalList;
    
    private JButton comb1, comb2, comb3, comb4, comb5, comb6;
    private ArrayList<Integer> combinationsList;
    private int comb1val, comb2val, comb3val, comb4val, comb5val, comb6val;
    private AudioPlayer audioplayer;
    private int currFilter = 0;
    
    private JButton cube1, cube2, cube3;
    
    private int whiteCubes = 3;
    private int remainingClicks = 2;
    
    private boolean rollInProgress = false;
    
    private int completedColumns = 0;
    
    private Player currPlayer;
    
    private JButton restartButton;
    
    private boolean gameFinished = false;
    
    private ArrayList<String> invalidList;
    private ArrayList<BoardSpace> whiteSpaceList;
    
    private boolean col1IsClicked = false, col2IsClicked = false;
    private int col1Clicked, col2Clicked;
    
    private JLabel whiteCubeLabel;
    public GUIBoard()
    {
        this.setSize(750,600);
        GUIBoard board = this;
        colourList = new ArrayList<>();
        colourList.add(Color.red);colourList.add(Color.blue);colourList.add(Color.green);colourList.add(Color.yellow);
        
        restartButton = new JButton("Restart");
        closeButton = new JButton("ExitGame");
        restartButton.setVisible(false);
        JMenuBar menubar = new JMenuBar();
        this.setJMenuBar(menubar);
        
        columnList = new ArrayList<>();
        invalidList = new ArrayList<>();
        
        JMenu settingsMenu = new JMenu("Menu");
        menubar.add(settingsMenu);
        try{
            audioplayer = new AudioPlayer();
            audioplayer.clip.start();
        }
        catch(Exception ex){}
        settingsButton = new JButton("Display settings");
        soundbutton = new JButton("Sound Settings");
        SaveButton = new JButton("Save");
        rollReset = new JButton("Next Roll");
        
        
        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        centrePanel = new JPanel();
        centrePanel.setLayout(new GridLayout(rows, columns));
        centrePanel.setSize(325,325);
        
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        
        rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        
        playerPanel = new JPanel();
        
        playerPanel.setBackground(colourList.get(0));
        playerPanel.setLayout(new FlowLayout());
        
        subPanel = new JPanel();
        subPanel.setLayout(new FlowLayout());
        
        titleLabel = new JLabel("Can't Stop!");
        
        playerLabel = new JLabel("Player");
        
        
        advanceButton = new JButton("Next Turn");
        
        settingsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new DisplaySettingsInGame(board);
            };
        });
        
        rollReset.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                resetRoll();
            };
        });
        
        advanceButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (!rollInProgress){
                    playerAdvance();
                }
            };
        });
        
        diceLabel = new JLabel("Roll the Dice!                                               ");
        rollButton = new JButton("Roll");
        soundbutton = new JButton("Sound Settings");
        die1 = new JLabel("Die 1 Result:");
        die2 = new JLabel("Die 2 Result:");
        die3 = new JLabel("Die 3 Result:");
        die4 = new JLabel("Die 4 Result:");
        score1 = new JLabel("");
        score2 = new JLabel("");
        
        
        resultButton1 = new JButton("");
        resultButton2 = new JButton("");
        resultButton3 = new JButton("");
        resultButton4 = new JButton("");
        confirmDice= new JButton("Choose Combinations");
        
        comb1 = new JButton("");comb2 = new JButton("");
        comb3 = new JButton("");comb4 = new JButton("");
        comb5 = new JButton("");comb6= new JButton("");
        
        reChooseButton = new JButton("Reselect Combinations");
        
        
        
        ArrayList<Integer> addingList = new ArrayList<Integer>();
        ArrayList<Integer> keepList = new ArrayList<Integer>();
        ArrayList<Integer> finalList = new ArrayList<Integer>();
        
        closeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try
                {
                    restartGame();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            };
        });
        
        reChooseButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                reChoose();
            }
        });
        
        resultButton1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (!clicked1){
                    keepList.add(result1);
                    clicked1 = true;
                }
            }
        });
        
        resultButton2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (!clicked2){
                    keepList.add(result2);
                    clicked2 = true;
                }
            }
        });
        
        resultButton3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (!clicked3){
                    keepList.add(result3);
                    clicked3 = true;
                }
            }
        });
        
        soundbutton.addActionListener(new ActionListener(){
            
        public void actionPerformed(ActionEvent e){
                new SoundSettings(board);
            };});
            
        resultButton4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (!clicked4){
                    keepList.add(result4);
                    clicked4 = true;
                }
            }
        });
        
        confirmDice.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                for (Integer a:keepList){
                    
                    finalList.add(a);
                }
                keepList.clear();
                
                /*
                if (!clicked1){
                    result1 = rollDie();
                    die1.setText("Die 1 Result: " + result1);
                    finalList.add(result1);
                }
                
                if (!clicked2){
                    result2 = rollDie();
                    die2.setText("Die 2 Result: " + result2);
                    finalList.add(result2);
                }
                
                if (!clicked3){
                    result3 = rollDie();
                    die3.setText("Die 3 Result: " + result3);
                    finalList.add(result3);
                }
                
                if (!clicked4){
                    result4 = rollDie();
                    die4.setText("Die 4 Result: " + result4);
                    finalList.add(result4);
                }
                */
                clicked1 = false;
                clicked2 = false;
                clicked3 = false;
                clicked4 = false;
                
                confirmDice.setVisible(false);
                resultButton1.setVisible(false);
                resultButton2.setVisible(false);
                resultButton3.setVisible(false);
                resultButton4.setVisible(false);
                
                rerollTitle.setVisible(false);
                combinationsTitle.setVisible(true);
                comb1.setVisible(true);comb2.setVisible(true);
                comb3.setVisible(true);comb4.setVisible(true);
                comb5.setVisible(true);comb6.setVisible(true);
                
                //////
                
                combinationsList = new ArrayList<Integer>();
                comb1val = result1+result2;
                comb2val = result1+result3;
                comb3val = result1+result4;
                comb4val = result2+result3;
                comb5val = result2+result4;
                comb6val = result3+result4;
                
                String str1 = result1 + " + " + result2 + " = " + comb1val;
                String str2 = result1 + " + " + result3 + " = " + comb2val;
                String str3 = result1 + " + " + result4 + " = " + comb3val;
                String str4 = result2 + " + " + result3 + " = " + comb4val;
                String str5 = result2 + " + " + result4 + " = " + comb5val;
                String str6 = result3 + " + " + result4 + " = " + comb6val;
                
                comb1.setText(str1);
                comb2.setText(str2);
                comb3.setText(str3);
                comb4.setText(str4);
                comb5.setText(str5);
                comb6.setText(str6);
                
                comb1.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        combinationsList.add(comb1val);
                        comb1.setVisible(false);comb2.setVisible(false);
                        comb3.setVisible(false);comb4.setVisible(false);
                        comb5.setVisible(false);
                        showResults(combinationsList, comb1val, comb6val);
                        column1 = comb1val;
                        column2 = comb6val;
                    };
                });
                
                comb2.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        combinationsList.add(comb2val);
                        comb1.setVisible(false);comb2.setVisible(false);
                        comb3.setVisible(false);comb4.setVisible(false);
                        comb6.setVisible(false);
                        showResults(combinationsList, comb2val, comb5val);
                        column1 = comb2val;
                        column2 = comb5val;
                    };
                });
                
                comb3.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        combinationsList.add(comb3val);
                        comb1.setVisible(false);comb2.setVisible(false);
                        comb3.setVisible(false);comb5.setVisible(false);
                        comb6.setVisible(false);
                        showResults(combinationsList, comb3val, comb4val);
                        column1 = comb3val;
                        column2 = comb4val;
                    };
                });
                
                comb4.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        combinationsList.add(comb4val);
                        comb5.setVisible(false);comb2.setVisible(false);
                        comb1.setVisible(false);comb4.setVisible(false);
                        comb6.setVisible(false);
                        showResults(combinationsList, comb4val, comb3val);
                        column1 = comb4val;
                        column2 = comb3val;
                    };
                });
                
                comb5.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        combinationsList.add(comb5val);
                        comb1.setVisible(false);comb5.setVisible(false);
                        comb3.setVisible(false);comb4.setVisible(false);
                        comb6.setVisible(false);
                        showResults(combinationsList, comb5val, comb2val);
                        column1 = comb5val;
                        column2 = comb2val;
                    };
                });
                
                comb6.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        combinationsList.add(comb6val);
                        comb5.setVisible(false);comb2.setVisible(false);
                        comb3.setVisible(false);comb4.setVisible(false);
                        comb6.setVisible(false);
                        showResults(combinationsList, comb6val, comb1val);
                        column1 = comb6val;
                        column2 = comb1val;
                    };
                });
                
                
                
            }
        });
        restartButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try
                {
                    restartGame();
                }
                catch (IOException ioe)
                {
                    ioe.printStackTrace();
                }
            }});
        rollButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                col2IsClicked = false;
                col1IsClicked = false;
                
                if (!rolled && !rollInProgress){
                remainingClicks = 2;
                rollInProgress=true;    
                
                ArrayList resultList = new ArrayList<Integer>();
                
                result = rollDie();
                result1=result;
                resultList.add(result);
                
                die1.setText("Die 1 Result: " + result);
                result = rollDie();
                result2=result;
                resultList.add(result);
                
                die2.setText("Die 2 Result: " + result);
                result = rollDie();
                result3=result;
                resultList.add(result);
                
                die3.setText("Die 3 Result: " + result);
                result = rollDie();
                result4=result;
                resultList.add(result);
                die4.setText("Die 4 Result: " + result);
                
                resultButton1.setText(Integer.toString(result1));
                resultButton2.setText(Integer.toString(result2));
                resultButton3.setText(Integer.toString(result3));
                resultButton4.setText(Integer.toString(result4));
                
                rolled = true;
                confirmDice.setVisible(true);
                
                
                comb1val = result1+result2;
                comb2val = result1+result3;
                comb3val = result1+result4;
                comb4val = result2+result3;
                comb5val = result2+result4;
                comb6val = result3+result4;
                
                if (checkBust()){
                    applyBust();
                }
                }
                
            }
        });
        
        rerollTitle = new JLabel("Choose dice to keep and reroll rest.");
        combinationsTitle = new JLabel("Choose Numbers to Add                  ");
        invalidLabel = new JLabel("Invalid Combinations:");
        topPanel.add(titleLabel);
        topPanel.add(settingsButton);
        topPanel.add(soundbutton);
        bottomPanel.add(advanceButton);
        bottomPanel.add(rollReset);
        bottomPanel.add(restartButton);
        playerPanel.add(playerLabel);
        
        settingsMenu.add(settingsButton);
        settingsMenu.add(soundbutton);
        settingsMenu.add(closeButton);
        settingsMenu.add(SaveButton);
        SaveButton.addActionListener(myListener);
        rightPanel.add(diceLabel);
        
        rightPanel.add(rollButton);
        rightPanel.add(die1);
        rightPanel.add(die2);
        rightPanel.add(die3);
        rightPanel.add(die4);
        rightPanel.add(rerollTitle);
        
        rightPanel.add(score1);
        rightPanel.add(score2);
        
        score1.setVisible(false);
        score2.setVisible(false);
        
       
        rightPanel.add(resultButton1);
        resultButton1.setVisible(false);
        rightPanel.add(resultButton2);
        resultButton2.setVisible(false);
        rightPanel.add(resultButton3);
        resultButton3.setVisible(false);
        rightPanel.add(resultButton4);
        resultButton4.setVisible(false);
        rightPanel.add(confirmDice);
        confirmDice.setVisible(false);
        
        rerollTitle.setVisible(false);
        combinationsTitle.setVisible(false);
        
        rightPanel.add(combinationsTitle);
        rightPanel.add(comb1);
        rightPanel.add(comb2);
        rightPanel.add(comb3);
        rightPanel.add(comb4);
        rightPanel.add(comb5);
        rightPanel.add(comb6);
        
        whiteCubeLabel = new JLabel("Runner Cubes");
        cube1 = new JButton(" ");
        cube2 = new JButton(" ");
        cube3 = new JButton(" ");
        
        Dimension dimension = new Dimension(20,20);
        cube1.setPreferredSize(dimension);
        cube2.setPreferredSize(dimension);
        cube3.setPreferredSize(dimension);
        cube1.setBackground(Color.white);
        cube1.setForeground(Color.white);
        cube2.setBackground(Color.white);
        cube2.setForeground(Color.white);
        cube3.setBackground(Color.white);
        cube3.setForeground(Color.white);
        
        rightPanel.add(subPanel);
        subPanel.add(whiteCubeLabel);
        subPanel.add(cube1);
        subPanel.add(cube2);
        subPanel.add(cube3);
        
        rightPanel.add(reChooseButton);
        reChooseButton.setVisible(false);
        rightPanel.add(invalidLabel);
        invalidLabel.setVisible(false);
        
        
        boardSpaces = new BoardSpace[rows][columns];
        activeSpaces = new ArrayList<>();
        for (   int x = 0; x < rows; x ++)
        {
            for (int y = 0; y < columns -2; y ++)
            {
                boardSpaces[x][y] = new BoardSpace(x, y);
                
                boardSpaces[x][y].setSize(25, 25);
                ///////
                if(y<=upperBound && y >= lowerBound){
                    boardSpaces[x][y].setColor(true);
                    boardSpaces[x][y].addMouseListener(this);
                    activeSpaces.add(boardSpaces[x][y]);
                }
                else{
                    boardSpaces[x][y].setColor(false);
                }
                        // AGAIN, don't forget this line!
                
                centrePanel.add(boardSpaces[x][y]);
                
            }
            if (x <= 5)
            {
                upperBound +=1;
                lowerBound -=1;
            }
            
            else
            {
                upperBound -=1;
                lowerBound +=1;
            }
        }
        setTopSpaces();
        
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(playerPanel, BorderLayout.NORTH);
        getContentPane().add(centrePanel, BorderLayout.CENTER);        // needs to be center or will draw too small
        getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        getContentPane().add(rightPanel, BorderLayout.EAST);
        
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(false);
        
        comb1.setVisible(false);comb2.setVisible(false);
        comb3.setVisible(false);comb4.setVisible(false);
        comb5.setVisible(false);comb6.setVisible(false);
        
    }
    
    public void applyDeutFilter()
    {
        
        for (Color i:colourList){
            if (i.equals(Color.red)){
                colourList.set(colourList.indexOf(i), Color.pink);
                
            }
        }
        
        if (counter == -1){
            counter+=1;
        }
        Color colour = colourList.get(counter);
        playerPanel.setBackground(colour);
        currFilter = 1;
    }
    public void applyTritFilter()
    {
        
        
        for (Color i:colourList){
            if (i.equals(Color.blue)){
                colourList.set(colourList.indexOf(i), Color.pink);
            }
            if (i.equals(Color.yellow)){
                colourList.set(colourList.indexOf(i), Color.gray);
            }
        }
        
        if (counter == -1){
            counter+=1;
        }
        Color colour = colourList.get(counter);
        playerPanel.setBackground(colour);
        currFilter=2;
    }
    
    public void applyProtoFilter()
    {
        
        for (Color i:colourList){
            if (i.equals(Color.red)){
                colourList.set(colourList.indexOf(i), Color.pink);
            }
            if (i.equals(Color.green)){
                colourList.set(colourList.indexOf(i), Color.gray);
            }
        }
        
        if (counter == -1){
            counter+=1;
        }
        Color colour = colourList.get(counter);
        playerPanel.setBackground(colour);
        currFilter=3;
    }
    public void applyStandardFilter()
    {
        for (BoardSpace b : activeSpaces)
        {
            b.switchRed();
        }
        colourList.clear();
        for (Player p : playerList){
            colourList.add(p.getPlrColor());
        }
        
        if (counter == -1){
            counter+=1;
        }
        Color colour = colourList.get(counter);
        playerPanel.setBackground(colour);
        currFilter=0;
    }
    
    public int rollDie(){
        Random rand = new Random();
        int result = rand.nextInt(6);
        return result += 1;
    }
    
    public void showResults(ArrayList a, int x, int y){
        if (a.size() == 2){
            score1.setText("First Total: " + y);
            score2.setText("Second Total: " + x);
            score1.setVisible(true);
            score2.setVisible(true);
            a.clear();
            combinationsTitle.setVisible(false);
            rollInProgress=false;
            
            reChooseButton.setVisible(true);
            
        }
    }
    
    public int showResult1(){
        return column1;
    }
    public int showResult2(){
        return column2;
    }
    
        
    public void resetRoll(){
        score1.setVisible(false);
        score2.setVisible(false);
        rolled = false;
        score1.setText("First Total: ");
        score2.setText("Second Total: ");
        
        die1.setText("Die 1 Result:");
        die2.setText("Die 2 Result:");
        die3.setText("Die 3 Result:");
        die4.setText("Die 4 Result:");
        
        invalidLabel.setVisible(false);
    }
    public void playerAdvance(){
        
        
        for (BoardSpace a:activeSpaces){
            if (a.getColour(Color.white).equals(Color.white)){
                
                int currentColumnNum = a.getYcoord();
                for (BoardSpace b:activeSpaces){
                    if (b.getColour(currPlayer.getPlrColor()).equals(currPlayer.getPlrColor()) && b.getYcoord()==currentColumnNum){
                        
                        b.SwitchBack(this, currPlayer.getPlrColor());
                    }
                }
                
                /**
                if (counter == -1){
                    a.switchToPlayerColour(this, getCurrColour());
                }
                */
                a.switchToPlayerColour(this, getCurrColour());
            }
        }
        
        
        
        resetRoll();
        whiteCubes = 3;
        replaceCubes();
        counter +=1;
        Color colour = colourList.get(counter);
        currColour = colour;
        currPlayer = playerList.get(counter);
        playerPanel.setBackground(colour);
        playerLabel.setText(playerList.get(counter).getPlrName());
        if (counter > playerCount - 2){
            counter = -1;
        }
    }
    
    public void fullScreen(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setUndecorated(true);
            
    }
        
    public void start(){
        this.setVisible(true);
    }
    
    public void generatePlayers(ArrayList<Player> list){
        playerList = list;
        colourList.clear();
        for (Player p : playerList){
            colourList.add(p.getPlrColor());
        }
        Color colour = colourList.get(counter);
        playerPanel.setBackground(colour);
        playerLabel.setText(playerList.get(0).getPlrName());
        currPlayer = playerList.get(0);
        
        if(currFilter==1){
            applyDeutFilter();
        }
        if(currFilter==2){
            applyTritFilter();
        }
        if(currFilter==3){
            applyProtoFilter();
        }
        
        playerCount = playerList.size();
        currColour = colour;
    }
    
    
    


    public void mouseClicked(MouseEvent e) {
        boolean valid = false;
        
        Object selected = e.getSource();
        if (selected instanceof BoardSpace && !gameFinished){
            BoardSpace space = (BoardSpace) selected;
            if ((space.getYcoord()+2==showResult1() && !col1IsClicked)||(space.getYcoord()+2==showResult2()&&!col2IsClicked)){
                valid = true;
            }
            if (rolled && !space.isClaimed() && remainingClicks>0 && valid){
                updateBoard(space);
                
            }
            if (space.getYcoord()+2 == showResult1()){
                col1IsClicked = true;
            }
            else if (space.getYcoord()+2 == showResult2()){
                col2IsClicked = true;
            }
        }
        
        
    }
    
    public void updateBoard(BoardSpace space){
        int position = space.getYcoord();
        //boolean valid = true;
        boolean x= false; //player coloured cube allready present in the collumn.
        boolean y= false;// player allready playing in the collumn. white cube present.
        //boolean z= false;// player starts from bottom.
        int testVarWhiteCubes = 3;
        
        for (BoardSpace a:activeSpaces){
            if (a.getDisplayColour().equals(Color.white)){
                testVarWhiteCubes -=1;
                
            }
        }
        
        currentColumn = new ArrayList<>();
        for (BoardSpace a:activeSpaces){
            if (a.getYcoord() == position){
                currentColumn.add(a);
                
            }
        }
        for (BoardSpace a:currentColumn){
            if (a.getColour(getCurrColour()).equals(getCurrColour())){
                x= true;
            }
            if(a.getColour(Color.white).equals(Color.white)){
                y=true;
            }
            
        }
        if (!(x||y) && whiteCubes>0){
            int level = -1000;
            
            for (BoardSpace a:currentColumn){
                if (a.getXcoord()>level){
                    level = a.getXcoord();
                    bottomSpace1 = a;
                }
                
            }
            
            bottomSpace1.switchWhite();
            if (bottomSpace1.getTopSpace()){
                claimColumn(bottomSpace1.getYcoord());
            }
            
            removeCube();
            if (whiteCubes >0){
                whiteCubes-=1;
            }
            
            remainingClicks -= 1;
        }
        
        else if(x&&!y&&whiteCubes>0){
            int level=-1000;
            
            for (BoardSpace a:currentColumn){
                if (a.getColour(getCurrColour()).equals(getCurrColour())){
                    level= a.getXcoord();
                    
                }
            }
            for (BoardSpace a:currentColumn){
                if(a.getXcoord()==level-1){
                     bottomSpace2= a;
                }
            }
            removeCube();
            if (whiteCubes>0){
                whiteCubes-=1;
            }
            
            bottomSpace2.switchWhite();
            remainingClicks -= 1;
            
            
            if (bottomSpace2.getTopSpace()){
                claimColumn(bottomSpace2.getYcoord());
            }
            
        }
        else if(y){
            int level = -1000;
            for (BoardSpace a:currentColumn){
                if (a.getColour(Color.white).equals(Color.white)){
                    level= a.getXcoord();
                    bottomSpace4=a;
                }
                
            }
            for (BoardSpace a:currentColumn){
                if(a.getXcoord()==level-1){
                     bottomSpace3= a;
                }
            }
            
            bottomSpace3.switchWhite();
            bottomSpace4.SwitchBack(this, Color.white);
            remainingClicks -= 1;
            
            
            if (bottomSpace3.getTopSpace()){
                claimColumn(bottomSpace3.getYcoord());
            }
            //boardSpaces[level +1][position].setColor(false);
            //boardSpaces[level][position].setColor(true);
            
            
        }
        for (BoardSpace a:activeSpaces){
            if (a.getDisplayColour().equals(Color.white)){
                testVarWhiteCubes -=1;
            }
        }
        
    }
    
    
    
    public void play(){
        audioplayer.clip.start();
    }
    public void pause(){
        audioplayer.clip.stop();
    }
    public void track1(){
        try
        {
            audioplayer.resetAudio1();
        }
        catch (Exception uafe)
        {
            uafe.printStackTrace();
        }
    }
    public void track2(){
        try
        {
            audioplayer.resetAudio2();
        }
        catch (Exception uafe)
        {
            uafe.printStackTrace();
        }
    }
    public void track3(){
        try
        {
            audioplayer.resetAudio3();
        }
        catch (Exception uafe)
        {
            uafe.printStackTrace();
        }
    }



    
    
    
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }




    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }




    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }




    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }




    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        
    }
    

    public Color getCurrColour(){
        return currColour;
    }
    
    public void setTopSpaces(){
        
        int c = 0;
        while (c<13){
        int l = 1000;
        BoardSpace tempSpace = new BoardSpace(1000,1000);
        tempColumn = new ArrayList<>();
        for (BoardSpace a:activeSpaces){
            
            if (a.getYcoord() == c){
                tempColumn.add(a);
            }
        }
        
        for (BoardSpace a:tempColumn){
            if (a.getXcoord()<l){
                l = a.getXcoord();
                tempSpace = a;
            }
                
        }
        tempSpace.setTopSpace();
        c+=1;
        }
    }
    
    public void claimColumn(int x){
        tempColumn = new ArrayList<>();
        for (BoardSpace a:activeSpaces){
            if (a.getYcoord() == x){
                tempColumn.add(a);
            }
        }
        for (BoardSpace i:tempColumn){
            i.switchToPlayerColour(this);
            i.setClaimed();
        }
        
        currPlayer.incrementColumns();
        for (Player p:playerList){
            if (p.getColumns()==3){
                finishGame();
                
            }
        }
        
        columnList.add(x + 2);
    }
    
    public void removeCube(){
        if (whiteCubes == 3){
            cube1.setVisible(false);
        }
        if (whiteCubes == 2){
            cube2.setVisible(false);
        }
        if (whiteCubes == 1){
            cube3.setVisible(false);
        }
    }
    public void replaceCubes(){
        cube1.setVisible(true);
        cube2.setVisible(true);
        cube3.setVisible(true);
        
    }
    
    public void finishGame(){
        titleLabel.setText("You win!");
        for (BoardSpace a:activeSpaces){
            a.switchToPlayerColour(this);
        }
        restartButton.setVisible(true);
        gameFinished = true;
    }
    
    public void restartGame()throws IOException
    {
        Window window = new Window();
        this.dispose();
    }
    
    public void reChoose(){
        comb1.setVisible(true);
        comb2.setVisible(true);
        comb3.setVisible(true);
        comb4.setVisible(true);
        comb5.setVisible(true);
        comb6.setVisible(true);
        reChooseButton.setVisible(false);
    }
    
    public boolean checkBust(){
        boolean d = false;//all columns are invalid when d is true
        if(checkComboVal(comb1val) && checkComboVal(comb2val) && checkComboVal(comb3val) && checkComboVal(comb4val) && checkComboVal(comb5val) && checkComboVal(comb6val)){
            d = true;
        }
        
        if ((checkComboVal(comb1val)) && whiteCubes <1){
            invalidList.add(Integer.toString(comb1val));
        }
        if ((checkComboVal(comb2val)) && whiteCubes <1){
            invalidList.add(Integer.toString(comb2val));
        }
        if ((checkComboVal(comb3val)) && whiteCubes <1){
            invalidList.add(Integer.toString(comb3val));
        }
        if ((checkComboVal(comb4val)) && whiteCubes <1){
            invalidList.add(Integer.toString(comb4val));
        }
        if ((checkComboVal(comb5val)) && whiteCubes <1){
            invalidList.add(Integer.toString(comb5val));
        }
        if ((checkComboVal(comb6val)) && whiteCubes <1){
            invalidList.add(Integer.toString(comb6val));
        }
        
        String str = String.join(", ", invalidList);
        str = "Invalid Combinations: " + str;
        invalidLabel.setText(str);
        invalidLabel.setVisible(true);
        invalidList.clear();
        
        if (whiteCubes <1 && d){
            return true;
        }
        return false;
    }
    
    public boolean checkComboVal(int c){
        boolean x = false;//valid when cube exists in the column
        boolean y = true;//valid when column is not claimed
        
        currentColumn = new ArrayList<>();
        for (BoardSpace a:activeSpaces){
            if (a.getYcoord() == c - 2){
                currentColumn.add(a);
            }
        }
        for (BoardSpace a:currentColumn){
            if (a.getColour(Color.white).equals(Color.white)){
                x= true; //white space exists
            }
        }
        
        if (columnList.contains(c)){
            y = false; //column is claimed
        }
        
        
        
        return (!x || !y);
    }
    
    public void applyBust(){
        for (BoardSpace a:activeSpaces){
            if (a.getColour(Color.white).equals(Color.white)){
                 a.SwitchBack(this, Color.white);
            }
        }
        rollInProgress = false;
        playerLabel.setText("Busted! Please click next turn.");
        
    }
    
    public void closeGame(){
        this.setVisible(false);
        System.out.close();
    }
    
    ActionListener myListener = new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        test mytest = new test();
        mytest.save();
    }
    };
}

//fawaz ahmad 