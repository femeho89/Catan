import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EndListener implements ActionListener {
    private static JFrame endFrame;
    private static ActionListener backListener = h -> {
        Main.frame.setVisible(true);
        endFrame.setVisible(false);
    };
    private static ActionListener endListener = g -> {
        endFrame = new JFrame(Main.file1);
        endFrame.setSize(1366, 720);
        endFrame.setVisible(true);
        StartButtonActionListener.getPlayingFrame().setVisible(false);
        StartButtonActionListener.getPlayingFrame().dispose();
        endFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endFrame.setLayout(null);

        JButton backButton = new JButton("Terug naar start");
        backButton.setBounds(600, 200, 200, 50);
        backButton.setBackground(new Color(200, 0, 0));
        endFrame.add(backButton);
        backButton.addActionListener(backListener);
    };

    public static JFrame getEndFrame() {
      return endFrame;
    }
    public static ActionListener getEndListener() {
        return endListener;
    }
    public static ActionListener getBackListener() {
        return backListener;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
