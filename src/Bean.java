import comp127graphics.Image;

/**
 * Creates a bean from an image
 */
public class Bean extends Image {
    private String beanImage = "bean.png";
    private double x;
    private double y;

    public Bean(double x, double y) {
        super(x, y);
        setImagePath(beanImage);
    }

}
