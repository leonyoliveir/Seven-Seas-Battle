package music;

import javax.sound.sampled.*;
import java.io.*;

public class Music {

	private static Clip clip;  
    private static AudioInputStream audioIn;  
    
    public static void playWav(File wav) {  
        try {             
            audioIn = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream(wav)));              
            clip = AudioSystem.getClip();              
            clip.open(audioIn);  
            clip.start();   
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }  
    public static void stopWav() {  
        try {  
            clip.stop();  
            audioIn.close();  
        } catch (Exception ex) {  
            ex.printStackTrace();  
        }  
    }  
}
