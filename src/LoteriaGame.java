import comp127graphics.CanvasWindow;
import comp127graphics.GraphicsObject;
import comp127graphics.Point;
import comp127graphics.ui.Button;

import java.awt.*;

public class LoteriaGame {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private CardManager cardManager;
    private DeckOfCards deck;
    private Color backColor = Color.BLACK;
    private Colors colors;

    private CanvasWindow canvas;

    public LoteriaGame() {
        canvas = new CanvasWindow("Loteria!", CANVAS_WIDTH, CANVAS_HEIGHT);

        cardManager = new CardManager(canvas);

        colors = new Colors();

        deck = new DeckOfCards(480, 150);

        addLoteriaButton();

        canvas.onClick(event -> {
                addBean(event.getPosition());});

        setCards();

        canvas.animate(() -> {
            deck.drawCard();
            deck.updateCard();
        });
    }

    private void addLoteriaButton(){
        Button callLoteria = new Button ("Loteria");
        callLoteria.setPosition(520, 400);
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

    public void setCards() {
        for(int n = 0; n < colors.getColorListSize(); n++) {
            deck.add(new Card(100, 75, 480, 150, cardManager));
        }
        for(Card card: deck) {
            card.setFillColor(backColor);
            canvas.add(card);

        }
    }

    public static void main(String[] args){
        new LoteriaGame();
    }

}
