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
        dialog.setLocation(990, 0);
        dialog.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea("""
                Welkom bij Catan! De speluitleg staat hieronder.
                """);

        textArea.setEditable(false);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(255, 255, 255));

        dialog.add(new JScrollPane(textArea), BorderLayout.CENTER);
        dialog.setVisible(true);
    }
}
