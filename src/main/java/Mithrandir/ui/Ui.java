package Mithrandir.ui;

import Mithrandir.MithrandirExceptions.InvalidArgumentException;
import Mithrandir.MithrandirExceptions.MithrandirException;
import Mithrandir.TaskList;
import Mithrandir.task.Event;
import Mithrandir.task.Task;
import Mithrandir.task.Todo;
import Mithrandir.task.Deadline;

import java.util.ArrayList;

public class Ui {
    private final IOComponent IOComponent =  new IOComponent();
    private final ArrayList<Task> toDoList = new ArrayList<>();

    public void greet(){
        this.IOComponent.greet();
    }

    public void addTodoToList(Todo todo){
        this.IOComponent.printAddToList(todo);
    }

    public void addEventToList(Event event) throws MithrandirException {
        try {
            this.IOComponent.printAddToList(event);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("Event command need 4 parts: task description, " +
                    "'/from', Start time of" +
                    " task and end time of task. You are missing on something. Check your command!");
        }
    }

    public void addDeadlineToList(Deadline deadline) throws MithrandirException {
        try {
            this.IOComponent.printAddToList(deadline);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("Deadline command need 3 parts: task description, '/by' and deadline, " +
                    "you are missing on something. Check your command!");
        }

    }

    public void exit(){
        this.IOComponent.exit();
    }

    public void mark(Task task) {
        this.IOComponent.printMarkDoneSuccessful(task.toString());
    }

    public void unmark(Task task) {
        this.IOComponent.printMarkUndoneSuccessful(task.toString());
    }

    public void delete(Task task) throws IndexOutOfBoundsException {
        this.IOComponent.printRemoved(task.toString());
    }

    public void print(String input){
        IOComponent.print(input);
    }

    /**
     * Prints the found tasks to the user interface.
     * This method delegates to the IOComponent to display the search results
     * in a formatted manner.
     *
     * @param foundTasks the TaskList containing the tasks that match the search criteria
     */
    public void printFoundTasks(TaskList foundTasks) {
        String str = foundTasks.toString();
        if (str.isEmpty()) {
            this.IOComponent.printNotFoundTasks();
        } else {
            this.IOComponent.printFoundTasks(str);
        }
    }
}
