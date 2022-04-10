import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import java.awt.event.KeyEvent;

public class MapBuilder {

    public static PanelManager pm;
    public static int mapSize;


    public static void main(String[] args) {
        
        Thread t = new Thread(new Runnable() {
            public void run() {
                mapSize = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the Map Size"));
            }
        });

        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            System.exit(1);
        }

        pm = new PanelManager(mapSize);
        JFrame frame = new JFrame("Map Builder for Boom");
        JMenuBar jmb = new JMenuBar();

        

        // Save mnu bar
        JMenuItem save = new JMenuItem("Save");
        save.addActionListener(new SaveListener(pm));
        save.setMnemonic(KeyEvent.VK_S);
        save.getAccessibleContext().setAccessibleDescription("Save the designed map");
        jmb.add(save);
        frame.add(jmb);

        // Actual frame being set up

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(jmb);
        frame.getContentPane().add(pm);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }




    
}
