import comp127graphics.CanvasWindow;
import java.util.ArrayList;
import java.util.List;

public class CardManager{

    private CanvasWindow canvas;
    public static double NUM_BRICKS_PER_ROW = 4;
    public static double NUM_ROW = 4;
    private List<Card> cardList = new ArrayList<>();
    private Colors color = new Colors();
    private List<String> randomColor = color.getRandomColor();

    public CardManager(CanvasWindow canvas) {
        this.canvas = canvas;
        cardRows();
    }

    public void cardRows(){
        double spacing = canvas.getWidth() * 0.14;

        double cardWidth = ((canvas.getWidth() - (spacing * (NUM_BRICKS_PER_ROW + 1)))/NUM_BRICKS_PER_ROW) * 1.5;
        double cardHeight = cardWidth * 1.6;

        double y = spacing;

        for(int r = 0; r < NUM_ROW; r++) {
            double x = spacing;
            for (int i = 0; i < NUM_BRICKS_PER_ROW; i++) {
                Card card = new Card( x-100, y-100, this );
                cardList.add(card);
                canvas.add(card);
                x += cardWidth;
            }
            y += cardHeight;
        }

        for (int n = 0; n < cardList.size(); n++) {
            cardList.get(n).setImagePath(randomColor.get(n));
        }
    }
    public List<Card> getCardList() {
        return cardList;
    }

    public List<String> getRandomColorList () {
        return randomColor;
    }
}
