package imageviewer.apps.mock;

import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import imageviewer.view.ImageLoader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    
    public static void main(String[] args) {
        List <Image> images = new MockImageLoader ().load();
        ImageDisplay imageDisplay = new MockImageDisplay();
        for (Image image : images) {
            imageDisplay.display(image);
        }

    }
    
    public static class MockImageDisplay implements ImageDisplay{

        @Override
        public void display(Image image) {
            System.out.println(image.getName());
        }
        
    }    
    
    public static class MockImageLoader implements ImageLoader{

        @Override
        public List<Image> load() {
            List <Image> list = new ArrayList<>();
            list.add(new Image("image 1"));
            list.add(new Image("image 2"));
            list.add(new Image("image 3"));
            return list;
        }
        
    }
}
