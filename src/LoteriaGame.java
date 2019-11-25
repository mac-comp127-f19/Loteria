import comp127graphics.CanvasWindow;

public class LoteriaGame {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private MainCard mainCard;

    private CanvasWindow canvas;

    public LoteriaGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);

//        mainCard = new MainCard(canvas);
    }

    public static void main(String[] args){
        new LoteriaGame();
    }
}
