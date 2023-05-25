// Java program to play an Audio
// file using Clip Object
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer
{

    // to store current position
    Long currentFrame;
    Clip clip;
    
    // current status of clip
    String status;
    
    AudioInputStream audioInputStream;
    private static String filePath;

    // constructor to initialize streams and clip
    public AudioPlayer()
        throws UnsupportedAudioFileException,
        IOException, LineUnavailableException
    {
        // create AudioInputStream object
        filePath = "music/jazzy.au";
        audioInputStream =
                AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        
        // create clip reference
        clip = AudioSystem.getClip();
        
        // open audioInputStream to the clip
        clip.open(audioInputStream);
        
        //clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public static void main(String[] args)
    {
        try
        {
            
            AudioPlayer audioPlayer =
                            new AudioPlayer();
            
            Scanner sc = new Scanner(System.in);
            
            while (true)
            {
                System.out.println("1. pause");
                System.out.println("2. resume");
                System.out.println("3. restart");
                System.out.println("4. stop");
                System.out.println("5. Jump to specific time");
                int c = sc.nextInt();
                audioPlayer.gotoChoice(c);
                if (c == 4)
                break;
            }
            sc.close();
        }
        
        catch (Exception ex)
        {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        
        }
    }
    
    // Work as the user enters his choice
    
    private void gotoChoice(int c)
            throws IOException, LineUnavailableException, UnsupportedAudioFileException
    {
        switch (c)
        {
            case 1:
                pause();
                break;
            case 2:
                resumeAudio();
                break;
            case 3:
                restart();
                break;
            case 4:
                stop();
                break;
            case 5:
                System.out.println("Enter time (" + 0 +
                ", " + clip.getMicrosecondLength() + ")");
                Scanner sc = new Scanner(System.in);
                long c1 = sc.nextLong();
                break;
    
        }
    
    }
    
    // Method to play the audio
    public void play()
    {
        clip.start();
}
    
    // Method to pause the audio
    public void pause()
    {
        clip.stop();
    }
    
    // Method to resume the audio
    public void resumeAudio() throws UnsupportedAudioFileException,
                                IOException, LineUnavailableException
    {
        if (status.equals("play"))
        {
            System.out.println("Audio is already "+
            "being played");
            return;
        }
        clip.close();
        resetAudio1();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
}
    
    // Method to restart the audio
    public void restart() throws IOException, LineUnavailableException,
                                            UnsupportedAudioFileException
    {
        clip.stop();
        clip.close();
        resetAudio1();
        currentFrame = 0L;
        clip.setMicrosecondPosition(0);
        this.play();
}
    
    // Method to stop the audio
    public void stop() throws UnsupportedAudioFileException,
    IOException, LineUnavailableException
    {
        currentFrame = 0L;
        clip.stop();
        clip.close();
}
    
    
    
    // Method to reset audio stream
    public void resetAudio1() throws UnsupportedAudioFileException, IOException,
                                            LineUnavailableException
    {
        clip.stop();
        clip.close();
        filePath = "music/dreams.au";
        audioInputStream = AudioSystem.getAudioInputStream(
        new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void resetAudio2() throws UnsupportedAudioFileException, IOException,
                                            LineUnavailableException
    {
        clip.stop();
        clip.close();
        filePath = "music/jazzy.au";
        audioInputStream = AudioSystem.getAudioInputStream(
        new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void resetAudio3() throws UnsupportedAudioFileException, IOException,
                                            LineUnavailableException
    {
        clip.stop();
        clip.close();
        filePath = "music/piano.au";
        audioInputStream = AudioSystem.getAudioInputStream(
        new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}
