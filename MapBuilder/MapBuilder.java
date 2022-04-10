import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.KeyEvent;

public class MapBuilder {

    public static PanelManager pm = new PanelManager(25);

    public static void main(String[] args) {
        
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
