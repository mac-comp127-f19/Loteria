import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DeckOfCards extends ArrayList<Card> {
    private double x;
    private double y;
    private Card drawnCard;
    private long timeDrawn;
    private long lastRemoved;
    Colors colors = new Colors();
    private List<Color> drawnCardColor = colors.getRandomColor();
    private int currentColorIndex = 0;

    public DeckOfCards(double x, double y) {
        drawnCard = null;

        this.x = x;
        this.y = y;
    }

    /**
     * Animates the actual card flipping
     */
    public void drawCard() {
        long currentTime = System.currentTimeMillis();
        if(currentTime - lastRemoved > 1500 && !this.isEmpty()) {
            drawnCard = this.remove(0);
            lastRemoved = System.currentTimeMillis();
            timeDrawn = System.currentTimeMillis();
        }
    }

    public void updateCard() {
        if (drawnCard == null) return;

        long gap = System.currentTimeMillis() - timeDrawn;
        double proportionOfTheWayThere = Math.min(1.0, gap / 1000.0);
        double changeInX = 100 * proportionOfTheWayThere;
        drawnCard.setPosition(x + changeInX, y);

        if (proportionOfTheWayThere >= 1.0) {
            // we're done
            drawnCard.setFillColor(drawnCardColor.get(currentColorIndex));
            drawnCard = null;
            timeDrawn = 0;
            currentColorIndex++;
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
