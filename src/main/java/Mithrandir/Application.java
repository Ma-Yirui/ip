package Mithrandir;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import Mithrandir.storage.FileStorage;
import Mithrandir.ui.Ui;
import Mithrandir.util.CommandParser;

public class Application {
    private final Ui ui = new Ui();
    private final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private TaskList taskList = new TaskList();
    private final FileStorage fileStorage = new FileStorage("./Save/Save.txt");

    public void run() throws Exception {
        ui.greet();
        this.taskList = fileStorage.loadTaskList();
        String nextLine = bufferedReader.readLine();
        while (nextLine != null) {
            nextLine = nextLine.trim();
            HashMap<String, String> command = CommandParser.parse(nextLine);
            try {
                Command.valueOf(command.get("command word")).execute(this.ui, this.taskList,
                        command.get("description"), this.fileStorage);
                if (command.get("command word").equals("BYE")) {
                    return;
                }
            } catch (Exception e) {
                if (e.getMessage().contains("No enum constant")) {
                    ui.print("No such command! Supported commands are: TODO, EVENT, DEADLINE, BYE, LIST, MARK, " +
                            "UNMARK");
                } else {
                    ui.print(e.getMessage());
                }

            }
            nextLine = bufferedReader.readLine();
        }
    }
}
