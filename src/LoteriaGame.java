import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.Rectangle;
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
        callLoteria.onClick(this::checkWinLose);
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

    public void checkWinLose() {
        for (Card playCard: cardManager.getCardList()) {
            if(playCard.checkIfHasBean() && deck.getDiscardCardColors().containsAll(cardManager.getRandomColorList())){
                Rectangle winningRectangle = new Rectangle(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, 400, 200);
                winningRectangle.setCenter(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
                winningRectangle.setFillColor(Color.YELLOW);
                winningRectangle.setFilled(true);
                GraphicsText youWin = new GraphicsText("You've won! Yay! (:",
                        winningRectangle.getX()/2,
                        winningRectangle.getY()/2);
                youWin.setCenter(CANVAS_WIDTH/2-50, CANVAS_HEIGHT/2);
                youWin.setFont(FontStyle.BOLD, 25);
                canvas.add(winningRectangle);
                canvas.add(youWin);
            }else{
                Rectangle losingRectangle = new Rectangle(CANVAS_WIDTH/2, CANVAS_HEIGHT/2, 400, 200);
                losingRectangle.setCenter(CANVAS_WIDTH/2, CANVAS_HEIGHT/2);
                losingRectangle.setFillColor(Color.BLACK);
                losingRectangle.setFilled(true);
                GraphicsText youLose = new GraphicsText("You lose! Aw! ):",
                        losingRectangle.getX()/2,
                        losingRectangle.getY()/2);
                youLose.setCenter(CANVAS_WIDTH/2-50, CANVAS_HEIGHT/2);
                youLose.setFont(FontStyle.BOLD, 25);
                youLose.setFillColor(Color.WHITE);
                youLose.setFilled(true);
                canvas.add(losingRectangle);
                canvas.add(youLose);
            }
        }
    }

    public static void main(String[] args){
        new LoteriaGame();
    }

}
