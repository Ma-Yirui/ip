package Mithrandir.storage;

import Mithrandir.TaskList;
import Mithrandir.task.Task;
import Mithrandir.task.Tasks;
import Mithrandir.task.Event;
import Mithrandir.task.Tasks;
import Mithrandir.task.Todo;
import Mithrandir.util.FileParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;


public class FileStorage {
    private final Path filePath;

    public FileStorage(Path filePath) {
        this.filePath = filePath;
    }

    public FileStorage(String filePath) {
        this.filePath = Path.of(filePath);
    }

    public void Store(String tasks) throws IOException {
        try {
            Files.createDirectories(this.filePath.getParent());
            if (!Files.exists(this.filePath)) {
                Files.createFile(this.filePath);
            }
            FileWriter fw = new FileWriter(filePath.toString());
            fw.write(tasks);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public TaskList loadTaskList() throws Exception {
        File file = new File(this.filePath.toString());
        if (!file.exists()) {
            return new TaskList();
        }
        TaskList taskList = new TaskList();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                HashMap<String, String> content = FileParser.parseFileContent(line);
                String taskType = content.get("Type");
                Task task = Tasks.valueOf(taskType).createTask(content.get("CompletionStatus"), content.get(
                        "Description"));
                if (task != null) {
                    taskList.addTask(task);
                }
            }
            return taskList;
        }
    }
}
