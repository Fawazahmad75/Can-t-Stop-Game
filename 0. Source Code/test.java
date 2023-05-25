import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class test implements Serializable{
    private transient GUIBoard game;
    public FileOutputStream fileOut;
    public ObjectOutputStream out;
    public FileInputStream fileIn;
    public ObjectInputStream in;
    public void save(){
        try {
            fileOut = new FileOutputStream("filename.ser");
            out = new ObjectOutputStream(fileOut);
            out.writeObject(game);

            out.close();
            fileOut.close();
            System.out.println("Object has been saved");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public GUIBoard loadGame(String filename) {
        try {
            fileIn = new FileInputStream(filename);
            in = new ObjectInputStream(fileIn);
            game = (GUIBoard) in.readObject(); // read the game object from the file
            in.close();
            fileIn.close();
            // copy game data from the loaded game object to this object
            // example: this.score = game.score;
            System.out.println("Game loaded from " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return game;
    }
    public GUIBoard getGame(){
        return game;
    }
    }