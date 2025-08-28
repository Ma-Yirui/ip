package Mithrandir;

import Mithrandir.task.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks =  new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getTask(int index) {
        return tasks.get(index);
    }

    public void Mark(int index) {
        tasks.get(index).markDone();
    }

    public void Unmark(int index) {
        tasks.get(index).markUndone();
    }

    public Task DeleteTask(int index) {
        return tasks.remove(index);
    }

    public String generateFileStrings() {
        StringBuilder str = new StringBuilder();
        for (Task task : tasks) {
            str.append(task.toFileString()).append(System.lineSeparator());
        }
        return str.toString();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        int i = 1;
        for (Task task : tasks) {
            str.append(String.format("%d. ", i)).append(task.toString()).append("\n");
            i += 1;
        }
        return str.toString().strip();
    }

}
