import comp127graphics.GraphicsObject;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DeckOfCards extends ArrayList<Card> {
    private double x;
    private double y;
    private Card drawnCard;
    private long timeDrawn;
    Colors colors = new Colors();

    public DeckOfCards() {
        drawnCard = null;
    }

    /**
     * Animates the actual card flipping
     */
    public void drawCard() {
        drawnCard = this.remove(0);
        timeDrawn = System.currentTimeMillis();
    }

    public void updateCard() {
        if (drawnCard == null) return;

        long gap = System.currentTimeMillis() - timeDrawn;
        double proportionOfTheWayThere = Math.min(1.0, gap / 1000.0);
        double changeInX = 100 * proportionOfTheWayThere;
        drawnCard.setPosition(x + changeInX, y);
        // flip the card?
        if (proportionOfTheWayThere >= 1.0) {
            // we're done
            drawnCard = null;
            timeDrawn = 0;
        }
    }

    @Override
    public boolean add(Card card) {
        if(super.add(card)) {
            card.setPosition(x, y);
            return true;
        }
        return false;
    }
}
