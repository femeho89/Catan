import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bouwen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StartButtonActionListener.timer.stop();

            JFrame BuildFrame = new JFrame(Main.file1);
            BuildFrame.setSize(1366, 720);
            BuildFrame.setLayout(null);
            StartButtonActionListener.getPlayingFrame().setVisible(false);
            BuildFrame.setVisible(true);
        }
    }

