package Mithrandir.ui;

import java.util.ArrayList;

import Mithrandir.MithrandirExceptions.InvalidArgumentException;
import Mithrandir.MithrandirExceptions.MithrandirException;
import Mithrandir.task.Deadline;
import Mithrandir.TaskList;
import Mithrandir.task.Event;
import Mithrandir.task.Task;
import Mithrandir.task.Todo;

public class Ui {
    private final IOComponent IOComponent =  new IOComponent();
    private final ArrayList<Task> toDoList = new ArrayList<>();

    /**
     * Delegates to the IOComponent to print a greeting message from Gandalf.
     */
    public String greet() {
        return this.IOComponent.greet();
    }

    /**
     * Adds a Todo task to the list and prints a confirmation message.
     *
     * @param todo the Todo task to be added
     */
    public String addTodoToList(Todo todo) {
        return this.IOComponent.printAddToList(todo);
    }

    /**
     * Adds an Event task to the list and prints a confirmation message.
     * Throws an exception if the command format is incorrect.
     *
     * @param event the Event task to be added
     * @throws MithrandirException if the command format is invalid
     */
    public String addEventToList(Event event) throws MithrandirException {
        try {
            return this.IOComponent.printAddToList(event);
        } catch (IndexOutOfBoundsException e) {
            return "Event command need 4 parts: task description, " +
                    "'/from', Start time of" +
                    " task and end time of task. You are missing on something. Check your command!";
        }
    }

    /**
     * Adds a Deadline task to the list and prints a confirmation message.
     * Throws an exception if the command format is incorrect.
     *
     * @param deadline the Deadline task to be added
     * @throws MithrandirException if the command format is invalid
     */
    public String addDeadlineToList(Deadline deadline) throws MithrandirException {
        try {
            return this.IOComponent.printAddToList(deadline);
        } catch (IndexOutOfBoundsException e) {
            return "Deadline command need 3 parts: task description, '/by' and deadline, " +
                    "you are missing on something. Check your command!";
        }
    }

    /**
     * Delegates to the IOComponent to print a farewell message.
     */
    public String exit() {
        return this.IOComponent.exit();
    }

    /**
     * Marks a task as done and prints a confirmation message.
     *
     * @param task the task to be marked as done
     */
    public String mark(Task task) {
        return this.IOComponent.printMarkDoneSuccessful(task.toString());
    }

    /**
     * Marks a task as undone and prints a confirmation message.
     *
     * @param task the task to be marked as undone
     */
    public String unmark(Task task) {
        return this.IOComponent.printMarkUndoneSuccessful(task.toString());
    }

    /**
     * Deletes a task from the list and prints a confirmation message.
     *
     * @param task the task to be deleted
     * @throws IndexOutOfBoundsException if the task index is invalid
     */
    public String delete(Task task) throws IndexOutOfBoundsException {
        return this.IOComponent.printRemoved(task.toString());
    }

    /**
     * Prints a given input message using the IOComponent.
     *
     * @param input the message to be printed
     */
    public String print(String input) {
        Mithrandir.ui.IOComponent.print(input);
        return input;
    }

    /**
     * Prints the found tasks to the user interface.
     * This method delegates to the IOComponent to display the search results
     * in a formatted manner.
     *
     * @param foundTasks the TaskList containing the tasks that match the search criteria
     */
    public String printFoundTasks(TaskList foundTasks) {
        String str = foundTasks.toString();
        if (str.isEmpty()) {
            return this.IOComponent.printNotFoundTasks();
        } else {
            return this.IOComponent.printFoundTasks(str);
        }
    }
}
