package Mithrandir.ui;

import Mithrandir.MithrandirExceptions.InvalidArgumentException;
import Mithrandir.MithrandirExceptions.MithrandirException;
import Mithrandir.task.Event;
import Mithrandir.task.Task;
import Mithrandir.task.Todo;
import Mithrandir.task.Deadline;


public class Ui {
    private final IOComponent IOComponent =  new IOComponent();

    /**
     * Delegates to the IOComponent to print a greeting message from Gandalf.
     */
    public void greet() {
        this.IOComponent.greet();
    }

    /**
     * Adds a Todo task to the list and prints a confirmation message.
     *
     * @param todo the Todo task to be added
     */
    public void addTodoToList(Todo todo) {
        this.IOComponent.printAddToList(todo);
    }

    /**
     * Adds an Event task to the list and prints a confirmation message.
     * Throws an exception if the command format is incorrect.
     *
     * @param event the Event task to be added
     * @throws MithrandirException if the command format is invalid
     */
    public void addEventToList(Event event) throws MithrandirException {
        try {
            this.IOComponent.printAddToList(event);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("Event command need 4 parts: task description, " +
                    "'/from', Start time of" +
                    " task and end time of task. You are missing on something. Check your command!");
        }
    }

    /**
     * Adds a Deadline task to the list and prints a confirmation message.
     * Throws an exception if the command format is incorrect.
     *
     * @param deadline the Deadline task to be added
     * @throws MithrandirException if the command format is invalid
     */
    public void addDeadlineToList(Deadline deadline) throws MithrandirException {
        try {
            this.IOComponent.printAddToList(deadline);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("Deadline command need 3 parts: task description, '/by' and deadline, " +
                    "you are missing on something. Check your command!");
        }
    }

    /**
     * Delegates to the IOComponent to print a farewell message.
     */
    public void exit() {
        this.IOComponent.exit();
    }

    /**
     * Marks a task as done and prints a confirmation message.
     *
     * @param task the task to be marked as done
     */
    public void mark(Task task) {
        this.IOComponent.printMarkDoneSuccessful(task.toString());
    }

    /**
     * Marks a task as undone and prints a confirmation message.
     *
     * @param task the task to be marked as undone
     */
    public void unmark(Task task) {
        this.IOComponent.printMarkUndoneSuccessful(task.toString());
    }

    /**
     * Deletes a task from the list and prints a confirmation message.
     *
     * @param task the task to be deleted
     * @throws IndexOutOfBoundsException if the task index is invalid
     */
    public void delete(Task task) throws IndexOutOfBoundsException {
        this.IOComponent.printRemoved(task.toString());
    }

    /**
     * Prints a given input message using the IOComponent.
     *
     * @param input the message to be printed
     */
    public void print(String input) {
        Mithrandir.ui.IOComponent.print(input);
    }
}
