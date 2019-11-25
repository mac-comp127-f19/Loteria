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

        canvas.onClick(event -> bean.setPosition(event.getPosition()));
    }

    public static void main(String[] args){
        new LoteriaGame();
    }
}
