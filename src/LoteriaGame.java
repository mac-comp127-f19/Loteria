import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;
import comp127graphics.Point;
import comp127graphics.Rectangle;
import comp127graphics.ui.Button;

public class LoteriaGame {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private CardManager cardManager;
    private DeckOfCards deck;
    private Colors colors;

    private CanvasWindow canvas;

    public LoteriaGame() {
        canvas = new CanvasWindow("Loteria!", CANVAS_WIDTH, CANVAS_HEIGHT);

        cardManager = new CardManager(canvas);

        addLoteriaButton();

        canvas.onClick(event ->
                addBean(event.getPosition()));

//        for(Rectangle card: deck) {
//            canvas.add(card);
//        }
//        drawCard();
    }

    private void addLoteriaButton(){
        Button callLoteria = new Button ("Loteria");
        callLoteria.setPosition(400, 400);
        canvas.add(callLoteria);
    }

    public void addBean(Point point) {
        GraphicsObject object = canvas.getElementAt(point);
        if (object instanceof Card) {
            Bean bean = new Bean(0, 0);
            bean.setCenter(point);
            if (((Card) object).setBean(bean)) {
                canvas.add(bean);
            }
        }
    }

    /**
     * Animates the actual card flipping
     *
     */
    public void drawCard(){
        Card topCard = deck.get(0);
        canvas.animate(topCard::moveCard);
    }

    public static void main(String[] args){
        new LoteriaGame();
    }
}
