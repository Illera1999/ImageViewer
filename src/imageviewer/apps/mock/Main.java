package imageviewer.apps.mock;

import imageviewer.contro.Command;
import imageviewer.contro.ExitImageCommand;
import imageviewer.contro.NextImageCommand;
import imageviewer.contro.PrevImageCommand;
import imageviewer.model.Image;
import imageviewer.view.ImageDisplay;
import imageviewer.view.ImageLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Scanner;

public class Main {

    private final Scanner scanner = new Scanner(System.in);
    private final Map<String,Command> commands = new HashMap<>();
    
    public static void main(String[] args) {
        new Main().execute();

    }

    public Main() {
        List <Image> images = new MockImageLoader ().load();
        ImageDisplay imageDisplay = new MockImageDisplay();
        imageDisplay.display(images.get(0));
        
        commands.put("N",new NextImageCommand(images,imageDisplay));
        commands.put("P",new PrevImageCommand(images,imageDisplay));
        commands.put("O",new ExitImageCommand());
    }
    
    private void execute() {
        while(true)commands.get(key()).execute();
    }
    
    private String key() {
        return scanner.next().toUpperCase();
    }

    
    public static class MockImageDisplay implements ImageDisplay{

        private Image image;
        
        @Override
        public void display(Image image) {
            this.image = image;
            System.out.println(image.getName());
        }

        @Override
        public Image currentIndex() {
            return image;
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
