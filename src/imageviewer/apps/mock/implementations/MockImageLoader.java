package imageviewer.apps.mock.implementations;

import imageviewer.mode.Image;
import imageviewer.view.ImageLoader;
import java.util.ArrayList;
import java.util.List;

    public class MockImageLoader implements ImageLoader{

        @Override
        public List<Image> load() {
            List <Image> list = new ArrayList<>();
            list.add(new Image("image 1"));
            list.add(new Image("image 2"));
            list.add(new Image("image 3"));
            return list;
        }
        
    }