import comp127graphics.CanvasWindow;
import comp127graphics.Point;
import comp127graphics.ui.Button;

public class LoteriaGame {
    private static final int CANVAS_WIDTH = 800;
    private static final int CANVAS_HEIGHT = 600;
    private CardManager cardManager;

    private CanvasWindow canvas;

    public LoteriaGame() {
        canvas = new CanvasWindow("Breakout!", CANVAS_WIDTH, CANVAS_HEIGHT);

        cardManager = new CardManager(canvas);

        addLoteriaButton();

        canvas.onClick(event ->
                addBean(event.getPosition()));
    }

    private void addLoteriaButton(){
        Button callLoteria = new Button ("Loteria");
        callLoteria.setPosition(400, 400);
        canvas.add(callLoteria);
//        changeBrush.onClick(() ->
    }

    public void addBean(Point point) {
//        GraphicsObject obj1 = canvas.getElementAt(point.getX(), bean.getY() + bean.getBeanRadius() * 2);
//        GraphicsObject obj2 = canvas.getElementAt(bean.getX() + bean.getBeanRadius() * 2, bean.getY() + bean.getBeanRadius() * 2);
//        GraphicsObject obj3 = canvas.getElementAt(bean.getX(), bean.getY() + bean.getBeanRadius() * 2);
//        GraphicsObject obj4 = canvas.getElementAt(bean.getX() + bean.getBeanRadius() * 2, bean.getY() + bean.getBeanRadius() * 2);

        if (canvas.getElementAt(point) instanceof Card) {
            canvas.add();
        }
    }

    public static void main(String[] args){
        new LoteriaGame();
    }
}
