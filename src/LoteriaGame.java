import comp127graphics.CanvasWindow;

public class LoteriaGame {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private CardManager cardManager;

    private CanvasWindow canvas;
    private Bean bean;

    public LoteriaGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);

        cardManager = new CardManager(canvas);

        canvas.onClick(event ->
                canvas.add(new Bean(event.getPosition().getX(),event.getPosition().getY())));
    }

    public static void main(String[] args){
        new LoteriaGame();
    }
}
