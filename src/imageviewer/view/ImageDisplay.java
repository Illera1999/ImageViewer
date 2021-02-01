package imageviewer.view;

import imageviewer.mode.Image;

public interface ImageDisplay {
    void display(Image image);
    public Image currentIndex();
}
