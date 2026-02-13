import javax.swing.*;

public class MarketTimer {

    static Timer timer = new Timer(2000, event -> {
        if(MarketActionListener.confirmLabel.isVisible()) {
            MarketActionListener.confirmLabel.setVisible(false);
        }
    });
}
