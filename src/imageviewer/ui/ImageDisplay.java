package imageviewer.ui;
import imageviewer.Model.Image;

public interface ImageDisplay {
    public Image current();
    public void show(Image image);
}
