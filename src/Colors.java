import comp127graphics.Image;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Colors {
    private List<Image> colors;
    private CardManager cardManager;

    public Colors(){

        colors = Arrays.asList(
        new Image(0, 0,"arbol.png"),
        new Image(0,0, "bandera.png"),
        new Image(0,0, "bandolon.png"),
        new Image(0,0, "barril.png"),
        new Image(0,0, "botella.png"),
        new Image(0,0, "catrin.png"),
        new Image(0,0, "dama.png"),
        new Image(0,0, "diablo.png"),
        new Image(0,0, "escalera.png"),
        new Image(0,0, "gallo.png"),
        new Image(0,0, "gorrito.png"),
        new Image(0,0, "melon.png"),
        new Image(0,0, "muerte.png"),
        new Image(0,0, "paraguas.png"),
        new Image(0,0, "pera.png"),
        new Image(0,0, "sirena.png"),
        new Image(0,0, "valiente.png"),
        new Image(0,0, "violincello.png"));
    }

    public List<Image> getRandomColor() {
        List<Image> copyofColors = new ArrayList(colors);
        Collections.shuffle(copyofColors);
        return copyofColors;
    }

    public double getColorListSize(){
        return colors.size();
    }
}
