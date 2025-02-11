/**
 * Authors: Ivy C., Haley V., Zully
 * This class allows a user to play a game called Loteria, similar to Bingo.
 * Acknowledgements: Thy and Logan! (:
 */

import comp127graphics.*;
import comp127graphics.Point;
import comp127graphics.Rectangle;
import comp127graphics.ui.Button;
import java.awt.*;

/**
 * The game of Loteria
 *
 * The class that creates and runs the main components of the game like the main window, the win/lose mechanics,
 *
 *
 * @author Ivy Contreras, Zully Maya, and Haley Vien
 */

public class LoteriaGame {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private CardManager cardManager;
    private DeckOfCards deck;
    private String backImage = "backColor.png";
    private ImageResource imageResource;

    private CanvasWindow canvas;

    public LoteriaGame() {
        canvas = new CanvasWindow("Loteria!", CANVAS_WIDTH, CANVAS_HEIGHT);

        cardManager = new CardManager(canvas);

        imageResource = new ImageResource();

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

    /**
     * Creates the button that the player presses to check if they have won the game or not
     */

    private void addLoteriaButton(){
        Button callLoteria = new Button ("Loteria");
        callLoteria.setPosition(520, 400);
        canvas.add(callLoteria);
        callLoteria.onClick(this::checkWinLose);
    }

    /**
     * This adds a bean to the canvas on top of a card a player has if the card already does not have a bean
     * @param point
     */

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
     * Sets the image for all the cards in a deck and adds them to the canvas
     */

    public void setCards() {
        for(int n = 0; n < imageResource.getImagePathListSize(); n++) {
            deck.add(new Card(480, 150, cardManager));
        }
        for(Card card: deck) {
            card.setImagePath(backImage);
            canvas.add(card);

        }
    }

    /**
     * Determines if the player has won or loss through checking if a player has set a bean on all of their cards
     * and if their cards have been pulled from the deck.
     */

    public void checkWinLose() {
        for (Card playCard: cardManager.getCardList()) {
            if(playCard.checkIfHasBean() && deck.getDiscardCardImages().containsAll(cardManager.getRandomImageList())){
                Rectangle winningRectangle = new Rectangle(CANVAS_WIDTH/2,
                        CANVAS_HEIGHT/2,
                        400,
                        200);

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
                Rectangle losingRectangle = new Rectangle(CANVAS_WIDTH/2,
                        CANVAS_HEIGHT/2,
                        400,
                        200);

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
            Button finish = new Button("Finish");
            finish.setPosition(CANVAS_WIDTH/2-50, CANVAS_HEIGHT/2+50);
            canvas.add(finish);
            finish.onClick(() -> canvas.closeWindow());
        }
    }

    public static void main(String[] args){
        new LoteriaGame();
    }

}
