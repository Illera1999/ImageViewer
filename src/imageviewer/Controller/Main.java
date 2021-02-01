package imageviewer.Controller;

import java.io.File;
import imageviewer.Model.Image;
import imageviewer.Persistencia.FileImageLoader;

public class Main {

    public static void main(String[] args) {
        File file = new File("RUTA A CARPETA CON FICHEROS JPG");
        FileImageLoader imageLoader = new FileImageLoader(file);
        Image image = imageLoader.load();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }

}