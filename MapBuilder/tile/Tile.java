package tile;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;

import texture.Texture;

/**
 * <p>A class to handle different tiles<p>
 * @Author Morgan Harrison
 */

public class Tile extends JPanel {

    // <p>The texture for the Tile to use</p>
    Texture texture;

    // <p>The label to display the texture</p>
    JLabel label = new JLabel();

    /**
     * An empty constructor for the Tile class
     */
    public Tile() {}

    /**
     * Basic constructor for a Tile
     * @param texture       The texture contained in the tile
     */
    public Tile(Texture texture) {
        // Set the texture
        this.texture = texture;

        // Make the label show the texture
        label = new JLabel(new ImageIcon(texture.getBufferedImage()));

        // add the label to the panel
        add(label);
    }

    /**
     * This sets the texture for the tile
     * @param texture
     */

    public void setTexture(Texture texture) {
        this.texture = texture;
        label.setIcon(new ImageIcon(texture.getBufferedImage()));
        label.revalidate();
    }


    /**
     * Get's the texture from the tile
     * @return      The texture the tile contains
     */
    public Texture getTexture() {
        return texture;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    public void repaint(Graphics g) {
        add(label);
    }    
}
