import comp127graphics.Ellipse;

public class Bean extends Ellipse {
    private static final double BEAN_RADIUS = 6;

    public Bean(double x, double y) {
        super(x, y, 4 * BEAN_RADIUS, 2 * BEAN_RADIUS);
    }

    public void checkCard(LoteriaGame Loteria){

    }
}
