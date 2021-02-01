package imageviewer.apps.mock.implementations;

import imageviewer.mode.Image;
import imageviewer.view.ImageDisplay;

    public class MockImageDisplay implements ImageDisplay{

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