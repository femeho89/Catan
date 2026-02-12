import java.util.*;

public class Game {
    //Initialises Player[] Array 'player'
    private final Player[] players;
    //Initialises integer 'currentPlayerIndex'
    private int currentPlayerIndex;

    //?
    public Game(Player[] players) {
        this.players = players;
    }

    /**
     * A getter for the attribute players
     * @return the players of a game
     */
    public Player[] getPlayers() {
        return players;
    }

    /**
     * A getter for the attribute currentPlayer
     * @return the Array of a player
     */
    public Player getCurrentPlayer() {
        return players[currentPlayerIndex];
    }

    /**
     * A method switchplayer, it switches the game from currentPlayer
     */
    public void switchPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }
}
