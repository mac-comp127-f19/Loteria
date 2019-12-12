
import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ImageResource {
    private List<String> images;

    public ImageResource() {
        File imageDir = new File(getClass().getResource("/bean.png").getFile()).getParentFile();
        File cardsDir = new File(imageDir, "cards");
        images = Arrays.stream(Objects.requireNonNull(cardsDir.listFiles(), "cannot find images files"))
                .map(file -> "cards/" + file.getName())
                .filter(name -> name.endsWith(".png"))
                .collect(Collectors.toList());
    }

    public List<String> getRandomImages() {
        List<String> copyofColors = new ArrayList(images);
        Collections.shuffle(copyofColors);
        return copyofColors;
    }

    public double getImagePathListSize(){
        return images.size();
    }
}
