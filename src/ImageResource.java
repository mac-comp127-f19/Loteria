import java.io.File;
import java.net.URLDecoder;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A list of file paths that relate to images
 *
 * Includes methods that allow you to randomize the list and that allow you to get the size of the list
 */

public class ImageResource {
    private List<String> images;

    public ImageResource() {
        File imageDir = new File(URLDecoder.decode(getClass().getResource("/bean.png").getFile())).getParentFile();
        File cardsDir = new File(imageDir, "cards");
        images = Arrays.stream(Objects.requireNonNull(cardsDir.listFiles(), "cannot find image files"))
                .map(file -> "cards/" + file.getName())
                .filter(name -> name.endsWith(".png"))
                .collect(Collectors.toList());
    }

    /**
     * Returns a shuffled copy of a list of Image paths which are strings
     *
     */

    public List<String> getRandomImages() {
        List<String> copyofColors = new ArrayList(images);
        Collections.shuffle(copyofColors);
        return copyofColors;
    }

    /**
     * Returns the number of image paths inside of a list
     *
     */
    public double getImagePathListSize() {
        return images.size();
    }
}
