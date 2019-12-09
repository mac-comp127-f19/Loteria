import comp127graphics.Rectangle;

import java.awt.*;

public class Card extends Rectangle{

    private CardManager cardManager;
    private Bean bean;
    public boolean hasBean = true;

    public Card(double height, double width, double x, double y, CardManager cardManager) {
        super(x, y, width, height);

        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);
        Color randomColor = new Color(red, green, blue);

        this.setFillColor(randomColor);

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
