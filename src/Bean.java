import comp127graphics.CanvasWindow;
import comp127graphics.Ellipse;
import comp127graphics.GraphicsObject;

import java.awt.*;

public class Bean extends Ellipse {
    private static final double BEAN_RADIUS = 6;
    private CanvasWindow canvas;
    private double x;
    private double y;

    public Bean(double x, double y, Bean canvas) {
        super(x, y, 2 * BEAN_RADIUS, 2 * BEAN_RADIUS);
        setFillColor(Color.black);
        setFilled(true);

    }

    public void beanInCard() {
        GraphicsObject obj1 = canvas.getElementAt(getX(), getY() + BEAN_RADIUS * 2);
        GraphicsObject obj2 = canvas.getElementAt(getX() + BEAN_RADIUS * 2, getY() + BEAN_RADIUS * 2);
        GraphicsObject obj3 = canvas.getElementAt(getX(), getY() + BEAN_RADIUS * 2);
        GraphicsObject obj4 = canvas.getElementAt(getX() + BEAN_RADIUS * 2, getY() + BEAN_RADIUS * 2);


        if (obj1 instanceof Card || obj2 instanceof Card || obj3 instanceof Card || obj4 instanceof Card) {
            canvas.add(new Bean(x, y, this));
            canvas.draw();
        }
    }

    public double getBeanRadius(){
        return BEAN_RADIUS;
    }

}
