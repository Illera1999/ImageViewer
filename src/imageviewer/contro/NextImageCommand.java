package imageviewer.contro;

import imageviewer.mode.Image;
import imageviewer.view.ImageDisplay;
import java.util.List;

public class NextImageCommand implements Command{
    private final List <Image> images;
    private final ImageDisplay imageDisplay;

    public NextImageCommand(List<Image> images, ImageDisplay imageDisplay) {
        this.images = images;
        this.imageDisplay = imageDisplay;
    }


    
    
    @Override
    public void execute() {
        imageDisplay.display(next());
    }
    
    public Image next(){
        return images.get(nextIndex());
    }
    
    public int nextIndex(){
        return (currentIndex() + 1)%images.size();
    }

    private int currentIndex() {
        return images.indexOf(imageDisplay.currentIndex());
    }

}
