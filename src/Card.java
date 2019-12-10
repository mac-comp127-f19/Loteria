import comp127graphics.Image;

public class Card extends Image {

    private CardManager cardManager;
    private Bean bean;
    public boolean hasBean = true;

    public Card(double x, double y, CardManager cardManager) {
        super(x, y);

        this.cardManager = cardManager;
    }

    public boolean setBean(Bean bean){
        if(this.bean == null){
            this.bean = bean;
            return hasBean;
        }else{
            hasBean = false;
            return false;
        }
    }

    public boolean checkIfHasBean(){
        return hasBean;
    }

}
