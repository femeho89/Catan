import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InfoActionListener implements ActionListener {

    public InfoActionListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JDialog dialog = new JDialog(Main.frame, "Game explanation", true);
        dialog.setSize(360, 400);
        ;
    }
}
