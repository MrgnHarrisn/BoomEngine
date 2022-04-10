
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenListener implements ActionListener {

    private PanelManager pm;

    OpenListener(PanelManager pm) {
        this.pm = pm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        pm.open();
        
    }


    
}
