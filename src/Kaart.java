import javax.swing.*;

public class Kaart extends JLabel {

    public enum Type{
        KNIGHT,
        TOWN,
        CITY,
        STREET,
        CITY_EXTENSION
    }

    private int x;
    private int y;
    private final int height;
    private final int width;
    private final Type type;
    public ImageIcon image;

    private final int startX;
    private final int startY;

    public Kaart(int x, int y, int height, int width, Type type, ImageIcon image, int startX, int startY) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.type = type;
        this.image = image;
        this.setIcon(image);
        this.startX = startX;
        this.startY = startY;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    public void moveX(int pixels) {
        x += pixels;
        setLocation(x, y);
    }

    public void restartPosition() {
        x = startX;
        y = startY;
        setLocation(x, y);
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public int getWidth() {
        return width;
    }

    public Type getType() {
        return type;
    }
}
