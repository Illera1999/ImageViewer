package imageviewer.contro;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import java.util.List;

public class PrevImageCommand implements Command{

    private final List <Image> images;
    private final ImageDisplay imageDisplay;

    public PrevImageCommand(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
    }


    
    
    @Override
    public void execute() {
        imageDisplay.display(prev());
    }
    
    public Image prev(){
        return images.get(prevIndex());
    }
    
    public int prevIndex(){
        return (currentIndex() + images.size() - 1)%images.size();
    }

    private int currentIndex() {
        return images.indexOf(imageDisplay.currentIndex());
    }
}
