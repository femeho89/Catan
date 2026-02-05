import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class marketActionListener implements ActionListener{
    static ActionListener marketListener = ma -> {
        JFrame marketFrame = new JFrame(Main.file1);
        marketFrame.setSize(1366,720);
        marketFrame.setLayout(null);
        StartButtonActionListener.getPlayingFrame().setVisible(false);
        marketFrame.setVisible(true);
        ActionListener marketBackListener = back -> {
            StartButtonActionListener.getPlayingFrame().setVisible(true);
            marketFrame.setVisible(false);
        };
        JButton marketExitButton = new JButton("terug naar het spel!");
        marketExitButton.setBounds(50, 550, 200, 50);
        marketExitButton.setBackground(new Color(200, 0, 0));
        marketFrame.add(marketExitButton);
        marketExitButton.addActionListener(marketBackListener);
        marketFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    };

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
