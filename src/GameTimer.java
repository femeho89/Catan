import java.util.Timer;

public class GameTimer {
    private final Game game;

    public GameTimer(Game game) {
        this.game = game;
    }

    Timer gameTimer = new Timer(9, event -> {
        game.getCurrentPlayer().getCard().moveX(1);
        game.getCurrentPlayer().getCard2().moveX(1);
        StartButtonActionListener.getPlayingFrame().repaint();
    });



    public Timer getTimer(){
        return gameTimer;
    }
}
