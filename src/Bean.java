import comp127graphics.CanvasWindow;
import comp127graphics.Image;

public class Bean extends Image {
    private static final double BEAN_RADIUS = 6;
    private CanvasWindow canvas;
    private String beanImage = "bean.png";
    private double x;
    private double y;

    public Bean(double x, double y) {
        super(x, y);
        setImagePath(beanImage);
    }

}
