import comp127graphics.GraphicsObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DeckOfCards extends ArrayList<Card> {
    private double x;
    private double y;
    Colors colors = new Colors();

    public DeckOfCards(double x, double y){
        this.x = x;
        this.y = y;

    }

}
