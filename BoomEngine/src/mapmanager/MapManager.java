package src.mapmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import src.texture.TextureManager;

public class MapManager {

    public int[][] map;
    private int size;
    private TextureManager tm;

    public MapManager(TextureManager tm) {
        File file = new File("./mapdata0.mdf");
        size = countLines(file);
        map = new int[size][size];
        this.tm = tm;
        loadMap(file);
    }

    /**
     * Get's the values in the map
     * @return          The values of the map
     */
    public int[][] getMap() {
        return this.map;
    }

    /**
     * Loads the map from the .mdf 
     * @param f         The file we want to read
     */

    public void loadMap(File f) {
        try {
            Scanner sc = new Scanner(f);
            int row = 0;
            while (sc.hasNextLine()) {
                String[] line = sc.nextLine().split(",");
                for (int col = 0; col < line.length; col++) {
                    map[row][col] = tm.getTextureIndex(line[col]);
                }
                row++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the map");
        }
    }

    /**
     * Counts the lines ni th mapdata file
     * @param f         this is the file to read the mpa data from
     * @return          This is the amount of lines in the file or the 'map size' which should be the same vertically and horizontally
     */

    public int countLines(File f) {
        int output = 0;
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                sc.nextLine();
                output++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find the map");
        }
        return output;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                output += " " + map[i][j];
            }
            output += "\n";
        }
        return output;
    }
    
}
