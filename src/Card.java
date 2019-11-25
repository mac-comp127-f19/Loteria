import comp127graphics.Rectangle;

import java.awt.*;

public class Card extends Rectangle{

    private MainCard mainCard;

    public Card(double height, double width, double x, double y, MainCard mainCard) {
        super(x, y, width, height);

        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        Color randomColor = new Color(red, green, blue);

        this.setFillColor(randomColor);

        this.mainCard = mainCard;
    }
}
