import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * A class that have the function of play the music
 */
public class Music {
    void playMusic(String musicLocation) {
        try {
            File musicPath = new File("res/music/World cup theme song.wav");
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
