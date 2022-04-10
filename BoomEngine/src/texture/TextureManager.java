package src.texture;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * <p>This class will act as a manager for the tiles we wish to use</p>
 * @author Morgan Harrison
 */

public class TextureManager {

    // The files we get 
    File[] files = new File("./Art").listFiles();

    // The textures
    Texture[] textures;

    /**
     * Default constructor for the TileManager
     */
    public TextureManager() {
        // Set the array to the size of the amount of textures
        textures = new Texture[files.length];

        // Itterate through the files and create a texture
        for (int i = 0; i < textures.length; i++) {
            try {
                // Create a texture
                textures[i] = new Texture(ImageIO.read(files[i]), files[i].getName());
            } catch (IOException e) {
                System.out.println("Could not read the file");
            }
        }
    }

    /**
     * Get's a texture based on a name of the texture
     * @param name          The name of the texture
     * @return              The texture with the name or null
     */

    public Texture getTexture(String name) {
        Texture output = null;  // I need to make this cleaner
        for (Texture t : textures) {
            if (t.getTextureName().equals(name)) {
                output = t;
                break;
            }
        }
        return output;
    }

    /**
     * Get's a texture at a specific index
     * @param index         The index o the texture we want
     * @return              Returns the texture at the index
     */
    public Texture getTexture(int index) {
        return textures[index];
    }

    public int getTextureIndex(String name) {
        for (int i = 0; i < textures.length; i++) {
            if (textures[i].getTextureName().equals(name)) {
                return i;
            }
        }
        return -1;          // If there is no found texture which would mean we didn't import it
    }

    /**
     * Returns all textures in an array
     * @return      All the textures in an array Texture[]
     */
    public Texture[] getAllTextures() {
        return textures;
    }

    /**
     * Returns the amount of textures being managed
     * @return          an integer for the amount of textures
     */

    public int size() {
        return textures.length;
    }
    
}
