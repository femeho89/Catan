import javax.swing.*;
import java.awt.event.*;

public class StartButtonActionListener implements ActionListener {
    private Kaart card;

    public StartButtonActionListener(Kaart card) {
        this.card = card;
    }
    public void actionPerformed(ActionEvent e) {
        JFrame playingFrame = new JFrame(Main.file1);    // The playing screen
        playingFrame.setSize(1366, 720);
        playingFrame.setLayout(null);
        card.setBounds(card.getX(), card.getY(), card.image.getIconWidth(), card.image.getIconHeight());
        playingFrame.add(card);

        Timer timerKnight = new Timer(9, event -> {
            card.setX(card.getX() + 3);
            card.setLocation(card.getX(), card.getY());
        });

        timerKnight.start();

        card.setVisible(true);
        Main.frame.setVisible(false);
        playingFrame.setVisible(true);

        playingFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if(SwingUtilities.isRightMouseButton(e)) {
                    int mouseX = e.getX();
                    int mouseY = e.getY();

                    if (mouseX <= card.getX() + card.image.getIconWidth() && mouseX >= card.getX() && mouseY <= card.getY() + card.image.getIconHeight() && mouseY >= card.getY()) {    // Makes the card disappear when the right mouse button is pressed
                        card.setVisible(false);
                    }
                }
            }
        });

        playingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
