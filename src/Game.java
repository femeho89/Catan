import java.util.*;

public class Game {
    private final Player[] players;
    private int currentPlayerIndex;

    public Game(Player[] players) {
        this.players = players;
    }

    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }
    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }
}
