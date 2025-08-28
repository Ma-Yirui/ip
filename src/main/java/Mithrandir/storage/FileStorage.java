package Mithrandir.storage;

import Mithrandir.task.Task;
import Mithrandir.task.Event;
import Mithrandir.task.Todo;

public class FileStorage {
    private String filePath;

    public FileStorage(String filePath) {
        this.filePath = filePath;
    }

    public void Store(Task task) {
        return;
    }
}
