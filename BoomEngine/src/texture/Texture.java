package src.texture;

import java.awt.image.BufferedImage;

public class Texture {

    BufferedImage image;
    String filename;

    /**
     * An empty constructor for the Texture class
     */
    public Texture() {}

    /**
     * The basic constructor for the texture class
     * @param bi
     * @param fn
     */

    public Texture(BufferedImage bi, String fn) {
        image = bi;
        filename = fn;
    }

    public String getTextureName() {
        return this.filename;
    }

    public BufferedImage getBufferedImage() {
        return this.image;
    }
    
}
