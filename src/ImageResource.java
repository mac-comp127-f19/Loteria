
import java.io.File;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class ImageResource {
    private List<String> images;

    public ImageResource() {


        File res = new File("/Users/zullymaya/Desktop/Macalester/comp127-f19/Loteria/res");
        System.out.println(res.getAbsolutePath());
        List<File> imagePathList = new ArrayList<>(Arrays.asList(res.listFiles()));
        images = imagePathList.stream().map(File::getName).
                filter(name -> !name.equals("bean.png") && !name.equals("backColor.png")).collect(Collectors.toList());
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
