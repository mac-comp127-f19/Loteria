import comp127graphics.Rectangle;

import java.awt.*;

public class Card extends Rectangle{

    private CardManager cardManager;
    private Bean bean;

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
            return true;
        }else{
            return false;
        }
    }

    /**
     * Changes the position of the card so that it moves over once drawn
     */
//    public void moveCard(){
//        this.setCenter(this.getX() + 100, this.getY());
//    }
}
