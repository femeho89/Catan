import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static String file1 = "Catan";
    public static int xKnight = 100;
    public static int yKnight = 100;
    public static int direccion = 1;

    public static void main(String[] args) {

        JFrame frame = new JFrame(file1);    // makes the frame for the game
        frame.setSize(1366, 720);     // sets the frame size

        ImageIcon cardKnight = new ImageIcon("Kaart Ridder.png");
        JLabel knight = new JLabel(cardKnight);
        frame.setLayout(null);

        JButton startButton = new JButton("Start Catan");
        startButton.setBounds(100, 100, 200, 50);
        frame.add(startButton);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent f) {
                JFrame playingFrame = new JFrame(file1);    //The playing screen
                playingFrame.setSize(1366, 720);
                playingFrame.setLayout(null);
                knight.setBounds(xKnight, yKnight, cardKnight.getIconWidth(), cardKnight.getIconHeight());
                playingFrame.add(knight);

                Timer timerKnight = new Timer(9, e -> {
                    xKnight += (3 * direccion);
                    if(xKnight + cardKnight.getIconWidth() >= frame.getContentPane().getWidth() || xKnight <= 0) {
                        direccion *= -1;
                    }
                    knight.setLocation(xKnight, yKnight);
                });

                timerKnight.start();

                frame.setVisible(false);
                playingFrame.setVisible(true);
            }
        };

        startButton.addActionListener(listener);

        Color colorBackground = new Color(255, 255, 255);    // makes a white color
        frame.getContentPane().setBackground(colorBackground);

        frame.setVisible(true);     // makes the frame visible
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // makes the game close when the cross is pressed
    }
}