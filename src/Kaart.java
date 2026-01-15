import javax.swing.*;

public class Kaart extends JLabel {
    private int x;
    private int y;
    private int height;
    private int width;
    private String type;
    ImageIcon image;

    public Kaart(int x, int y, int height, int width, String type, ImageIcon image) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.type = type;
        this.image = image;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
