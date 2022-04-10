package src.texture;

import java.awt.image.BufferedImage;

public class Texture {

    BufferedImage image;
    String filename;
    public int[] pixels;
    public int SIZE;

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
        SIZE = image.getWidth();
        pixels = new int[SIZE*SIZE];
        load();
    }

    private void load() {
        // This loads the RGB values in to the pixels array we can just use the size
        image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, SIZE);
    }

    public String getTextureName() {
        return this.filename;
    }

    public BufferedImage getBufferedImage() {
        return this.image;
    }
    
}
