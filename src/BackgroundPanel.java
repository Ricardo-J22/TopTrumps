import javax.swing.*;
import java.awt.*;

/**
 * Add a background image to the panel
 */
public class BackgroundPanel extends JPanel {

    private static final long serialVersionUID = -6352788025440244338L;

    private Image image = null;

    public BackgroundPanel(Image image) {
        this.image = image;
    }

    // Fixed the background image, allowing the JPanel to add other components to the image
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
