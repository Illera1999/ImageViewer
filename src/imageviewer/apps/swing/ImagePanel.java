package imageviewer.apps.swing;

import imageviewer.mode.Image;
import imageviewer.view.ImageDisplay;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel implements ImageDisplay{

    private BufferedImage bitmap;
    private Image image;

    
    @Override
    public void paint(Graphics g){
        Scale scale = new Scale(bitmap.getWidth(), bitmap.getHeight(), getWidth(), getHeight());
        g.drawImage(bitmap, scale.x(), scale.y(),scale.width(),scale.height(), null);
    }

    @Override
    public void display(Image image) {
        this.image = image;
        loadBitmap();
        repaint();
    }

    @Override
    public Image currentIndex() {
        return image;
    }

    private void loadBitmap() {
        try {
            bitmap = ImageIO.read(new File(image.getName()));
        } catch (IOException ex) {

        }
    }
    
    
    private static class Scale{

        private final int iw;
        private final int ih;
        private final int pw;
        private final int ph;

        
        private Scale(int iw, int ih, int pw, int ph){
            this.iw = iw;
            this.ih = ih;
            this.pw = pw;
            this.ph = ph;

        }
        
        private boolean adjustWidth(){
            return iw *  ph > pw * ih;
        }
        
        int x(){
            return (pw - width()) / 2;
        }
        
        int y(){
            return  (ph - height()) / 2;
        }
        
        int width(){
            return adjustWidth()? pw : (int)(iw * (double)ph / ih);
        }
        
        int height(){
            return adjustWidth() ? (int)(ih * (double)ph / iw) : ph;
        }
    }
}
