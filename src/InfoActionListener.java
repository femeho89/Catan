import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InfoActionListener implements ActionListener {

    public InfoActionListener() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //intialises dialog & declares it a new JDialog with the attributes: frame from Main Class, String title, boolean modal
        JDialog dialog = new JDialog(Main.frame, "Game explanation", true);
        //sets size of GUI component dialog
        dialog.setSize(400, 400);
        //sets location of GUI component dialog
        dialog.setLocation(960, 0);
        //sets layout of GUI component dialog as new BorderLayout?
        dialog.setLayout(new BorderLayout());

        //intialises TextArea& declares it as a new JTextArea with a lot of text
        JTextArea textArea = new JTextArea("""
                Welkom bij Catan! De speluitleg staat hieronder.
                
                Het spel bevat zogeheten bouwkaarten en grondstoffen \s
                kaarten. Er zijn vijf bouwkaarten, een dorp, stad, \s
                straat, ridder en stadsuitbreiding. De ridder kaart \s
                en een straat kaart hebben twee zijden, een A-zijde \s
                en een B-zijde. De grondstoffen kaarten zijn hout, \s
                graan, steen en erts. Een speler moet zo veel mogelijk \s
                overwinningspunten behalen door bouwkaarten te ‘bouwen’ \s
                of verkrijgen. In het midden ligt een markt bestaande \s
                uit vijf grondstoffenkaarten. Elke speler krijgt twee \s
                kaarten, een straat en een dorp. De rest van de \s
                grondstoffenkaarten vormt de trekstapel. Hij ontvangt \s
                ook een bouwkosten kaart waarop de speler kan zien \s
                welke grondstoffen nodig zijn om een kaart van de markt \s
                te verkrijgen. Er is ook een bank van bouwkaarten \s
                waarmee spelers bouwkaarten kunnen kopen.
                
                Als de speler een beurt heeft mag deze drie dingen doen. \s
                Een speler mag grondstoffenkaarten ruilen met de markt \s
                of drie grondstoffenkaarten ruilen met een dichte kaart \s
                op de trekstapel. De speler kan ook nog een grondstoffenkaart \s
                ruilen met een andere speler. Bij elke beurt mag een speler \s
                zo veel grondstoffenkaarten met de markt ruilen als dat hij \s
                bouwkaarten met de A-zijde naar boven heeft liggen. Ook mag \s
                een speler bouwkaarten kopen bij de bank. De speler kan \s
                alleen een stad-kaart kopen als deze een dorp-kaart heeft. \s
                De dorp-kaart wordt dan omgedraaid waarbij een stad-kaart \s
                wordt verkregen. Als de speler een stadsuitbreiding wil \s
                bouwen kan deze een stadsuitbreiding-kaart uit de stapel \s
                zoeken en neerleggen op de stad-kaart. Aan het einde van \s
                een beurt kan een speler twee grondstoffenkaarten trekken \s
                van de trekstapel. Voor elke ridder-kaart met een A-zijde \s
                naar boven mag nog een grondstoffenkaart worden getrokken.
                
                Met het verkrijgen van bouwkaarten kunnen overwinningspunten \s
                worden verkregen. De speler die als eerste tien \s
                overwinningspunten heeft behaald wint het spel.
                
                """);
        //sets textArea uneditable
        textArea.setEditable(false);
        //sets textArea to be wrapped??
        textArea.setWrapStyleWord(true);
        //sets textArea background colour
        textArea.setBackground(new Color(255, 255, 255));

        //adds scrolling to dialog
        dialog.add(new JScrollPane(textArea), BorderLayout.CENTER);
        //sets dialog visible
        dialog.setVisible(true);
    }
}
