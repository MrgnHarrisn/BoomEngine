import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import texture.Texture;
import texture.TextureManager;
import tile.Tile;

/**
 * <p>A class the manage the UI for the Map Builder</p>
 * @author Morgan Harrison
 */

public class PanelManager extends JPanel {

    /** 
     * We will have two arrays of panels to add to the Manager
     * One will be to display the textures
     * One will be to act as tiles to place the textures onto
    */

    // The size of the map (an X by Y array of JPanels)
    private int mapSize;

    private TextureManager tm = new TextureManager();

    // These two panels will contain the smaller panels inside

    // This panel will contain the textures
    private JPanel texturePanel = new JPanel();
    // This panel will contain the tiles to place textures on
    private JPanel tilingPanel;

    // Texture will be the current selected texture
    private Texture current = tm.getTexture(0);

    private PanelListener pl = new PanelListener();

    private Tile[] textures;
    private Tile[] tiles;


    /**
     * The main space for the design of the UI
     * @param mapSize       How many tiles we want for each side to be
     */
    public PanelManager(int mapSize) {

        this.mapSize = mapSize;

        // Create the grid Layout
        tilingPanel = new JPanel(new GridLayout(this.mapSize, this.mapSize, 1, 1));
        tilingPanel.setPreferredSize(new Dimension(480, 600));

        // Set the size of the textures array
        textures = new Tile[tm.size()];

        // create the tiles for the map
        tiles = new Tile[mapSize*mapSize];

        // add the textures to the texture tiles
        for (int i = 0; i < textures.length; i++) {

            // Set the tile to the texture at the index in the TextureManager
            textures[i] = new Tile(tm.getTexture(i));
            textures[i].addMouseListener(pl);
            texturePanel.add(textures[i]);

        }

        // Add tiles to the tilingPanel
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = new Tile();
            tiles[i].setBackground(Color.GRAY);
            tiles[i].setPreferredSize(new Dimension(64, 64));
            tiles[i].addMouseListener(pl);
            tilingPanel.add(tiles[i]);
        }

        // add the two subPanels to the main panel
        add(texturePanel);
        add(tilingPanel);

    }

    private class PanelListener implements MouseListener {

        public boolean contains(Tile[] check, Object o) {
            for (int i = 0; i < check.length; i++) {
                if (check[i] == o) {
                    return true;
                }
            }
            return false;
        }

        public Tile getTile(Tile[] check, Object o) {
            for (int i = 0; i < check.length; i++) {
                if (check[i] == o) {
                    return check[i];
                }
            }
            return null;
        }

        public Texture getTextureFromPanel(Tile[] check, Object o) {
            for (int i = 0; i < check.length; i++) {
                if (check[i] == o) {
                    return check[i].getTexture();
                }
            }
            return current;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            
            if (contains(textures, e.getSource())) {
                current = getTextureFromPanel(textures, e.getSource());
                System.out.println(current.getTextureName());
            } else {
                Tile temp = getTile(tiles, e.getSource());
                temp.setTexture(current);
                System.out.println(temp.getTexture().getTextureName());
            }
            
        }

        @Override
        public void mousePressed(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // TODO Auto-generated method stub
            
        }

        

    }
    
}
