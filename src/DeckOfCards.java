import java.util.ArrayList;
import java.util.List;
/* This class creates a list of Cards that act as a deck of cards
 */
public class DeckOfCards extends ArrayList<Card> {
    private double x;
    private double y;
    private Card drawnCard;
    private long timeDrawn;
    private long lastRemoved;
    ImageResource imageResource = new ImageResource();
    private List<String> drawnCardImages = imageResource.getRandomImages();
    private List<String> discardCardImages = new ArrayList<>();
    private int currentImageIndex = 0;

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

    /*
    Changes the position of the card being drawn and changed it's image.
    It also adds that image to a list that contains the images being shown.
     */
    public void updateCard() {
        if (drawnCard == null) return;

        long gap = System.currentTimeMillis() - timeDrawn;
        double proportionOfTheWayThere = Math.min(1.0, gap / 1000.0);
        double changeInX = 100 * proportionOfTheWayThere;
        drawnCard.setPosition(x + changeInX, y);

        if (proportionOfTheWayThere >= 1.0) {
            // we're done
            drawnCard.setImagePath(drawnCardImages.get(currentImageIndex));
            discardCardImages.add(drawnCardImages.get(currentImageIndex));
            drawnCard = null;
            timeDrawn = 0;
            currentImageIndex++;
        }
    }

    /*
    Returns the list of images that were being shown by the discarding cards
     */
    public List<String> getDiscardCardImages() {
        return discardCardImages;
    }

    /*
    overrides the canvas.add function to set the card position.
     */
    @Override
    public boolean add(Card card) {
        if(super.add(card)) {
            card.setPosition(x, y);
            return true;
        }
        return false;
    }
}
