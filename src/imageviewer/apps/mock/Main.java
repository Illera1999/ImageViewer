package imageviewer.apps.mock;

import imageviewer.apps.mock.implementations.MockImageDisplay;
import imageviewer.apps.mock.implementations.MockImageLoader;
import imageviewer.contro.Command;
import imageviewer.contro.InitCommand;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private final static Command NullCommand = new Command.Null();
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String,Command> commands = new HashMap<>();
    
    public static void main(String[] args) {
        new Main().execute();

    }

    public Main() {
        InitCommand init = new InitCommand(new MockImageLoader().load(),new MockImageDisplay());
        init.execute();
        commands.putAll(init.getCommand());
    }
    
    private void execute() {
        while(true)commands.getOrDefault(key(),NullCommand).execute();
    }
    
    private String key() {
        return scanner.next().toUpperCase();
    }
}
