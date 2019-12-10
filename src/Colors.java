import comp127graphics.Image;

import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class Colors {
    private List<String> colors;
    private CardManager cardManager;

    public Colors(){

        List <Image> images = Arrays.asList(
        new Image(0,0, "arana.png"),
        new Image(0, 0,"arbol.png"),
        new Image(0,0, "bandera.png"),
        new Image(0,0, "bandolon.png"),
        new Image(0,0, "barril.png"),
        new Image(0,0, "borracho.png"),
        new Image(0,0, "bota.png"),
        new Image(0,0, "botella.png"),
        new Image(0,0, "camaron.png"),
        new Image(0,0, "catrin.png"),
        new Image(0,0, "cazo.png"),
        new Image(0,0, "corazon.png"),
        new Image(0,0, "cotorro.png"),
        new Image(0,0, "dama.png"),
        new Image(0,0, "diablo.png"),
        new Image(0,0, "escalera.png"),
        new Image(0,0, "estrella.png"),
        new Image(0,0, "gallo.png"),
        new Image(0,0, "garza.png"),
        new Image(0,0, "gorrito.png"),
        new Image(0,0, "jaras.png"),
        new Image(0,0, "luna.png"),
        new Image(0,0, "mano.png"),
        new Image(0,0, "melon.png"),
        new Image(0,0, "muerte.png"),
        new Image(0,0, "musico.png"),
        new Image(0,0, "negrito.png"),
        new Image(0,0, "pajaro.png"),
        new Image(0,0, "paraguas.png"),
        new Image(0,0, "pera.png"),
        new Image(0,0, "sandia.png"),
        new Image(0,0, "sirena.png"),
        new Image(0,0, "soldado.png"),
        new Image(0,0, "tambor.png"),
        new Image(0,0, "valiente.png"),
        new Image(0,0, "violincello.png"));

        colors = images.stream().map(Image::getPath).collect(Collectors.toList());
    }

    public List<String> getRandomColor() {
        List<String> copyofColors = new ArrayList(colors);
        Collections.shuffle(copyofColors);
        return copyofColors;
    }

    public double getColorListSize(){
        return colors.size();
    }
}
