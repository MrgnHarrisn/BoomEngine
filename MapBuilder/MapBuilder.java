import javax.swing.JFrame;

public class MapBuilder {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Map Builder for Boom");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new PanelManager(5));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
    
}
