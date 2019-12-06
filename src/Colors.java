import java.awt.*;
import java.util.*;
import java.util.List;

public class Colors {
    private List<Color> colors;
    private CardManager cardManager;

    public Colors(){

        colors = Arrays.asList(
        new Color(255, 0, 0),
        new Color (255, 102, 102),
        new Color(64,0, 5),
        new Color(0, 255, 0),
        new Color(153, 255, 188),
        new Color(3, 55, 19),
        new Color(0, 0, 255),
        new Color(0, 254, 255),
        new Color(0,0,153),
        new Color(255, 255, 0),
        new Color(255, 255, 153),
        new Color(255, 204,0),
        new Color(255, 111, 0),
        new Color(255, 153, 51),
        new Color (179, 89, 0),
        new Color(255, 210, 168),
        new Color(65, 47, 35),
        new Color(143, 0, 255),
        new Color(183, 177, 255),
        new Color(255, 182, 227),
        new Color(255, 88, 234),
        new Color(255, 255, 255),
        new Color(90, 90, 90));
    }

    public List<Color> getRandomColor() {
        List<Color> copyofColors = new ArrayList(colors);
        Collections.shuffle(copyofColors);
        return copyofColors;
    }

    public double getColorListSize(){
        return colors.size();
    }
}
