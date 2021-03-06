package imageviewer.apps.swing;

import imageviewer.mode.Image;
import imageviewer.view.ImageLoader;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class FileImageLoader implements ImageLoader{

    private final File folder;

    public FileImageLoader(File folder) {
        this.folder = folder;
    }
    
    
    
    @Override
    public List<Image> load() {
        ArrayList<Image> list = new ArrayList<Image>();
        File [] files = folder.listFiles(withExtension(".jpg",".png", ".jpeg"));
        for (File file : files) {
            list.add(new Image(file.getAbsolutePath()));
        }
        return list;
    }

    private FilenameFilter withExtension(String... extensions) {
        return new FilenameFilter(){
            @Override
            public boolean accept(File file, String name){
                for (String extension : extensions) 
                    if(name.endsWith(extension)) return true;
                return false;
            }
        };
    }

}
