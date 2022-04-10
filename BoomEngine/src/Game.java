package src;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import src.camera.Camera;
import src.mapmanager.MapManager;
import src.screen.Screen;
import src.texture.TextureManager;

public class Game extends JFrame implements Runnable {
    
    public int WIDTH = 720, HEIGHT = 450;
	private Thread thread;
	private boolean running;
	private BufferedImage image;
	public int[] pixels;

    public Camera camera;
    public Screen screen;

    public TextureManager tm = new TextureManager();
    public MapManager mm = new MapManager(tm);
    public int[][] map;

    public Game() {
        thread = new Thread(this);
        camera = new Camera(2, 2, 1, 0, 0, -.66);
        // System.out.println(mm);
        addKeyListener(camera);
        image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Boom: The Engine");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        map = mm.getMap();
        screen = new Screen(map, map.length, map.length, tm, WIDTH, HEIGHT);
        start();
    }

    private synchronized void start() {
        running = true;
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch(InterruptedException e) {
            e.printStackTrace();
            System.out.println("Interrupted");
        }
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();

        g.drawImage(image, 0, 0, image.getWidth(), image.getHeight(), null);
        bs.show();

    }
    

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0;//60 times per second
        double delta = 0;
        requestFocus();
        while(running) {
            long now = System.nanoTime();
            delta = delta + ((now-lastTime) / ns);
            lastTime = now;
            while (delta >= 1)//Make sure update is only happening 60 times a second
            {
                //handles all of the logic restricted time
                screen.update(camera, pixels);
                camera.update(map, tm);
                delta--;
            }
            render();//displays to the screen unrestricted time
        }
    }


    public static void main(String[] args) {
        new Game();
    }
    
    
}
