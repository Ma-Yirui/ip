import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChatBot {
    private final IOComponent IOComponent =  new IOComponent();
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException{
        this.IOComponent.greet();
        String nextLine = bufferedReader.readLine();
        while (true){
            nextLine = nextLine.trim();
            if (nextLine.equals("bye")){
                this.IOComponent.exit();
                return;
            } else {
                this.IOComponent.echo(nextLine);
                nextLine = bufferedReader.readLine();
            }
        }
    }
}
