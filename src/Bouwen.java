import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bouwen implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StartButtonActionListener.timer.stop();

            JFrame buildFrame = new JFrame(Main.file1);
            buildFrame.setSize(1366, 720);
            buildFrame.setLayout(null);
            buildFrame.getContentPane().setBackground(new Color(237, 140, 98));
            StartButtonActionListener.getPlayingFrame().setVisible(false);
            buildFrame.setVisible(true);

            //initialises question Label & declares it a new JLabel with the text "wat wil je bouwen?"
            JLabel questionLabel = new JLabel("wat wil je bouwen?");
            //sets the position & size of GUI component questionLabel
            questionLabel.setBounds(633, 100, 200, 50);
            //sets font for questionLabel
            questionLabel.setFont(new Font("Arial", Font.BOLD, 16));
            //adds questionLabel to frame
            buildFrame.add(questionLabel);

            ImageIcon BouwStraatKaart = BouwKaart.BouwType.STREET.getImage();
//            grondstofKaart1.setLocation(60, 600);
//            StartButtonActionListener.getPlayingFrame().add(grondstofKaart1); //?
//            marketFrame.add(grondstofKaart1);
        }
    }

