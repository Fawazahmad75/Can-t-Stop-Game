import java.awt.Color;
import java.util.ArrayList;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.BorderFactory;

public class BoardSpace extends JPanel
{
    
    private int xcoord;
    private int ycoord;
    public boolean clicked = false;
    private ArrayList<Player> playersOnSpace;
    private ArrayList<Color> ColorTrack;
    private Color colour;
    private Color prevColor;
    private boolean isTopSpace = false;
    private boolean claimed = false;
    private ArrayList<Color> colourList;
    private JLabel columnLabel;
    
    public BoardSpace(int xcoord, int ycoord)
    {
        super();
        this.setSize(25,25);
        this.xcoord = xcoord;
        this.ycoord = ycoord;
        this.playersOnSpace = new ArrayList<>();
        this.colourList = new ArrayList<>();
        this.ColorTrack= new ArrayList<>();
        
        columnLabel = new JLabel(Integer.toString(ycoord+2));
        columnLabel.setVisible(false);
        this.add(columnLabel);
    }
    
    
    public void setColor( boolean decider)
    {
        if (decider){
            ColorTrack.add(Color.black);
            //this.setBackground(Color.black);// function
            ChangeColour();
            colour=Color.black;
            this.setBorder(BorderFactory.createLineBorder(Color.orange));
        }
        else{
            this.setBackground(Color.white);
        }
    }
    
    
    public void switchBlue()
    {
        
        colour = Color.blue;
        ColorTrack.add(Color.black);
        //this.setBackground(colour);// function to change colour.
        ChangeColour();
    }
    public void switchRed(){
        
        colour = Color.red;
        ColorTrack.add(Color.red);
        //this.setBackground(colour);//function to change colour.
        ChangeColour();
    }
    public void switchWhite(){
        prevColor=this.getBackground();
        colour = Color.white;
        ColorTrack.add(colour);
        //this.setBackground(colour);// function
        ChangeColour();
    }
    public void SwitchBack(GUIBoard board, Color colour1){
        colour=prevColor;
        //int c=ColorTrack.size()-1;
        //ColorTrack.remove(c);
        for(int i=0;i<ColorTrack.size();i++){
            if(ColorTrack.get(i).equals(colour1)){
                ColorTrack.remove(i);
            }
        }
        //this.setBackground(prevColor);// function
        ChangeColour();
        
    }
    public void switchToPlayerColour(GUIBoard board){
        colour = board.getCurrColour();
        
        for(int i=0;i<ColorTrack.size();i++){
            if(ColorTrack.get(i).equals(Color.white)){
                ColorTrack.remove(i);
            }
        }
        //this.setBackground(colour);//function
        ColorTrack.add(colour);
        ChangeColour();
        colourList.add(colour);
    }
    public void switchToPlayerColour(GUIBoard baord, Color colour){
        
        for(int i=0;i<ColorTrack.size();i++){
            if(ColorTrack.get(i).equals(Color.white)){
                ColorTrack.remove(ColorTrack.get(i));
            }
        }
        ColorTrack.add(colour);
        //this.setBackground(colour);//function
        ChangeColour();
        //colourList.add(colour);
    }
    
    public Color getPlayerColour(GUIBoard board){
        colour = board.getCurrColour();
        return colour;
    }
    private void ChangeColour(){
        int c = ColorTrack.size();
        
        Color color1 = ColorTrack.get(c-1);
        this.setBackground(color1);
        

    }
    
    
    
    
    
    
    //////////////
    //////////////
    //////////////testing methods
    private void ChangeColour(boolean a){
        int c = ColorTrack.size();
        System.out.println("it called changeColour()");
        Color color1 = ColorTrack.get(c-1);
        
        System.out.println(color1.toString());
        
        this.setBackground(color1);
        

    }
    public void SwitchBack(GUIBoard board, Color colour1, boolean x){
        colour=prevColor;
        //int c=ColorTrack.size()-1;
        //ColorTrack.remove(c);
        for(int i=0;i<ColorTrack.size();i++){
            if(ColorTrack.get(i).equals(colour1)){
                System.out.println("list before removal: ");
                for (Color c:ColorTrack){
                    System.out.println(c.toString());
                }
                System.out.println("removing: " + ColorTrack.get(i).toString());
                ColorTrack.remove(ColorTrack.get(i));
                System.out.println("list after removal: ");
                for (Color c:ColorTrack){
                    System.out.println(c.toString());
                }
            }
        }
        //this.setBackground(prevColor);// function
        ChangeColour(true);
        
    }
    
    
    /////////////////////////////
    
    
    //getters and setters
    public boolean isClaimed()          { return claimed; }
    public void setClaimed()            { claimed = true; }
    public void setTopSpace(){
        isTopSpace = true;
        columnLabel.setVisible(true);
        columnLabel.setForeground(Color.white);
    }
    public boolean getTopSpace()        { return isTopSpace; } 
    public void setXcoord(int value)    { xcoord = value; }
    public void setYcoord(int value)    { ycoord = value; }
    public int getXcoord()              { return xcoord; }
    public int getYcoord()              { return ycoord; }
    public boolean getBoolean()         { return clicked; }
    public void setBoolean(boolean a)   { clicked = a; }
    public Color getColour(Color colourParameter){ 
        int c = ColorTrack.size();
        
        if (ColorTrack.contains(colourParameter)){
            return colourParameter;
        }
        
        Color color1 = ColorTrack.get(c-1);
        
        //return color1;
        return color1;
        // return this.getBackground();
    }
    public ArrayList<Color> getList()   { return colourList; }
    
    
    public Color getDisplayColour(){
        return this.getBackground();
    }

}