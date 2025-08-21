import java.io.IOException;

public class Application {
    ChatBot  chatBot = new ChatBot();

    public void run(){
        try {
            chatBot.run();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
