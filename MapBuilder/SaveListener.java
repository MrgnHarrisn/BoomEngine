import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveListener implements ActionListener {

    private PanelManager pm;

    SaveListener(PanelManager pm) {
        this.pm = pm;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        pm.save();
        
    }


    
}
