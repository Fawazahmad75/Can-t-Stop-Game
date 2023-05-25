import java.awt.*;

public class Player {
    int num;
    String name;
    int age;
    Color color;
    int claimedColumns=0;
    Boolean bot;
    public Player(int num,String name, Boolean bot,int age,Color plrColor) {
        this.bot=bot;
        this.num = num;
        this.name = name;
        this.age = age;
        this.color = plrColor;
    }
    
    public String getPlrName() {
        return this.name;
    }
    public int getPlrAge() {
        return this.age;
    }
    public Color getPlrColor() {
        return this.color;
    }
    public void setPlrColor(Color newColor) {
        this.color = newColor;
    }
    public void incrementColumns(){
        claimedColumns +=1;
    }
    public int getColumns(){
        return claimedColumns;
    }
    public Boolean getBot (){
        return this.bot;
    }
     public void setBot (Boolean nbot){
        this.bot=nbot;
    }
}