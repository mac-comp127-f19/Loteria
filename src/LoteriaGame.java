import comp127graphics.CanvasWindow;
import comp127graphics.ui.Button;

public class LoteriaGame {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private CardManager cardManager;

    private CanvasWindow canvas;
    private Bean bean;

    public LoteriaGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);

        cardManager = new CardManager(canvas);

        addLoteriaButton();

        canvas.onClick(event ->
                canvas.add(new Bean(event.getPosition().getX(),event.getPosition().getY())));
    }

    private void addLoteriaButton(){
        Button changeBrush = new Button ("Loteria");
        changeBrush.setPosition(400, 400);
        canvas.add(changeBrush);
//        changeBrush.onClick(() ->
    }

    public static void main(String[] args){
        new LoteriaGame();
    }
}
