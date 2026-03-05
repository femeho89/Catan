import javax.swing.*;

public class Kaart extends JLabel {
    private int turns = 0;
    public ImageIcon frontCard;
    public ImageIcon backCard;


    public Kaart(int x, int y, int height, int width, ImageIcon frontCard, ImageIcon backCard) {
        this.frontCard = frontCard;
        this.backCard = backCard;
        this.setIcon(frontCard);
        this.setIcon(backCard);
        setBounds(x, y, width, height);
    }

    /**
     * A method to move the x-coordinate of a card
     * @param pixels that the card has to move
     */
    public void moveX(int pixels) {
        setLocation(getX() + pixels, getY());
    }

    /**
     * A getter for the attribute turns
     * @return the turns of a card
     */
    public int getTurns() {
        return turns;
    }

    /**
     * A setter for the attribute turns
     * @param turns of a card
     */
    public void setTurns(int turns) {
        this.turns = turns;
    }
}
