package Mithrandir.storage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import Mithrandir.TaskList;
import Mithrandir.task.Task;
import Mithrandir.task.Tasks;
import Mithrandir.util.FileParser;


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
            throw new IOException("Failed to store tasks to file: " + e.getMessage());
        }
    }

    public TaskList loadTaskList() throws Exception {
        File file = new File(this.filePath.toString());
        if (!file.exists()) {
            return new TaskList();
        }
        TaskList taskList = new TaskList();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
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
