import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Colors {
    private List<Color> colors= new ArrayList<>();

    public Colors(){
        colors = Arrays.asList(
        new Color(255, 0, 0),
        new Color(0, 255, 0),
        new Color(0, 0, 255),
        new Color(255, 249, 0),
        new Color(255, 111, 0),
        new Color(143, 0, 255),
        new Color(0, 254, 255),
        new Color(153, 255, 188),
        new Color(255, 182, 227),
        new Color(255, 210, 168),
        new Color(183, 177, 255),
        new Color(255, 88, 234),
        new Color(0,0,0),
        new Color(255, 255, 255),
        new Color(90, 90, 90),
        new Color(65, 47, 35),
        new Color(3, 55, 19),
        new Color(64,0, 5));
    }

    public Color getRandomColor() {
        Random random = new Random();
        int randomIndex = random.nextInt(18);
        return colors.get(randomIndex);
    }
}
