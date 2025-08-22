import MithrandirExceptions.MithrandirException;

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
        String nextLine = bufferedReader.readLine();
        while (nextLine != null) {
            nextLine = nextLine.trim();
            String[] tokens = nextLine.split(" ");
            String commandWord = tokens[0].toUpperCase();
            try {
                Command.valueOf(commandWord).execute(this.chatBot,
                        Arrays.stream(tokens, 1, tokens.length).collect(Collectors.joining(" ")));
                if (commandWord.equals("BYE")) {
                    return;
                }
            } catch (Exception e) {
                if (e.getMessage().contains("No enum constant")) {
                    chatBot.print("No such command! Supported commands are: TODO, EVENT, DEADLINE, BYE, LIST, MARK, " +
                            "UNMARK");
                } else {
                    chatBot.print(e.getMessage());
                }

            }
            nextLine = bufferedReader.readLine();
        }
    }
}
