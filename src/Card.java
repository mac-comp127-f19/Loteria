import comp127graphics.Image;
/**
This class creates a card that is used in the main playing card and the deck of cards.
 */
public class Card extends Image {

    private CardManager cardManager;
    private Bean bean;
    public boolean hasBean = true;

    public Card(double x, double y, CardManager cardManager) {
        super(x, y);

        this.cardManager = cardManager;
    }

    /**
    Checks to see if there is a bean on the card, and if there isn't one it sets
    a bean. It also sets hasBean depending on if there is a bean there or not.
     */
    public boolean setBean(Bean bean){
        if(this.bean == null){
            this.bean = bean;
            return hasBean;
        }else{
            hasBean = false;
            return false;
        }
    }

    /**
    Returns hasBean
     */
    public boolean checkIfHasBean(){
        return hasBean;
    }

}
