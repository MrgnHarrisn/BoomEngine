package src;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import src.texture.Texture;
import src.texture.TextureManager;

public class Game extends JFrame implements Runnable {
    
    public int WIDTH = 1080, HEIGHT = 720;
	private Thread thread;
	private boolean running;
	private BufferedImage image;
	public int[] pixels;

    public Game() {
        thread = new Thread(this);
        image = new BufferedImage(1080, 720, BufferedImage.TYPE_INT_RGB);
        pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setTitle("Boom: The Engine");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
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

                delta--;
            }
            render();//displays to the screen unrestricted time
        }
    }


    public static void main(String[] args) {
        new Game();
        TextureManager tm = new TextureManager();
        
    }
    
    
}
