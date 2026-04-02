import java.awt.*;

public class PlayerDistinction {
    private static final Color Player1 = Color.yellow;
    private static final Color Player2 = Color.BLUE;
    private static final Color Player3 = Color.PINK;
    private static final Color Player4 = Color.MAGENTA;
    private static int activeCurrentPlayerIndex;
    private static Color PlayerColour;


    public static Color getPlayerColour(int activeCurrentPlayerIndex){
//        activeCurrentPlayerIndex = game.getCurrentPlayerIndex();
        if(activeCurrentPlayerIndex == 0){
            PlayerColour = Player1;
            System.out.println("Yellow");
        } if (activeCurrentPlayerIndex == 1){
            PlayerColour = Player2;
            System.out.println("Blue");
        } if (activeCurrentPlayerIndex == 2){
            PlayerColour = Player3;
            System.out.println("Pink");
        } if (activeCurrentPlayerIndex == 3){
            PlayerColour = Player4;
            System.out.println("Magenta");
        }
        return PlayerColour;
    }
}
