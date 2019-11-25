import comp127graphics.CanvasWindow;
import comp127graphics.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainCard extends Rectangle {

    private CanvasWindow canvas;
    public static double NUM_BRICKS_PER_ROW = 4;
    public static double NUM_ROW = 4;
    private List<Rectangle> cardList = new ArrayList<>();
    private Colors color = new Colors();

    public MainCard(double x, double y, double width, double height) {
        super(x, y, width, height);


    }

    public void cardRows(){
        double spacing = canvas.getWidth() * 0.05;

        double cardWidth = (canvas.getWidth() - (spacing * (NUM_BRICKS_PER_ROW + 1)))/NUM_BRICKS_PER_ROW;
        double cardHeight = cardWidth * 2;

        double y = spacing;

        for(int r = 0; r < NUM_ROW; r++) {
            double x = spacing;
            for (int i = 0; i < NUM_BRICKS_PER_ROW; i++) {
                Rectangle card = new Rectangle(cardHeight, cardWidth, x, y);
                cardList.add(card);
                canvas.add(card);
                card.setFillColor(color.getRandomColor());
                x += cardWidth;
            }
            y += cardHeight;
        }
    }
}
