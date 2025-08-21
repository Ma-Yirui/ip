import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Application {
    private final ChatBot chatBot = new ChatBot();
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public void run() throws IOException {
        chatBot.greet();
        try {
            String nextLine = bufferedReader.readLine();
            while (nextLine != null){
                nextLine = nextLine.trim();
                String[] tokens = nextLine.split(" ");
                String commandWord = tokens[0].toUpperCase();
                Command.valueOf(commandWord).execute(this.chatBot,
                        Arrays.stream(tokens, 1, tokens.length).collect(Collectors.joining(" ")));
                nextLine = bufferedReader.readLine();
                }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
