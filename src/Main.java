
/**
 * The entry of the game
 */
public class Main {
    public static void main(String[] args) {
        // Create an object of GameCover class
        GameCover g = new GameCover();
        // Play the music
        String filepath = "res/music/World cup theme song.wav";
        Music musicObject = new Music();
        musicObject.playMusic(filepath);

    }
}