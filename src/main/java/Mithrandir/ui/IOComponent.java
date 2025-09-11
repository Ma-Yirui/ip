package Mithrandir.ui;

import Mithrandir.task.Deadline;
import Mithrandir.task.Event;
import Mithrandir.task.Todo;

public class IOComponent {
    private static final String separator = new String(new char[50]).replace('\0', '-');

    /**
     * Prints a message surrounded by separator lines.
     *
     * @param message the message to be printed
     */
    public static String print(String message) {
        System.out.println(separator);
        System.out.println(message);
        System.out.println(separator);
        return message;
    }

    /**
     * Prints a greeting message from Gandalf.
     */
    public String greet() {
        return print("A wizard is never late, nor is he early. "
                + "He arrives precisely when he means to. "
                + "Greetings from Gandalf.");
    }

    /**
     * Prints a farewell message from Gandalf.
     */
    public String exit() {
        return print("Farewell. My work is now finished.");
    }

    /**
     * Prints a message stating that a Todo task has been added to the list.
     *
     * @param todo the Todo task that has been added
     */
    public String printAddToList(Todo todo) {
        return print("Added Todo: " + todo);
    }

    /**
     * Prints a message stating that an Event task has been added to the list.
     *
     * @param event the Event task that has been added
     */
    public String printAddToList(Event event) {
        return print("Added Event: " + event);
    }

    /**
     * Prints a message stating that a Deadline task has been added to the list.
     *
     * @param deadline the Deadline task that has been added
     */
    public String printAddToList(Deadline deadline) {
        return print("Added Deadline: " + deadline);
    }

    /**
     * Prints a message indicating that a task has been successfully marked as done.
     *
     * @param input a string representation of the task that has been marked done
     */
    public String printMarkDoneSuccessful(String input) {
        return print("Well done! The following task is deemed complete:\n" + input);
    }

    /**
     * Prints a message indicating that a task has been successfully marked as undone.
     *
     * @param input a string representation of the task that has been marked undone
     */
    public String printMarkUndoneSuccessful(String input) {
        return print("Alas! It's the job that's never started as takes longest to finish. This task is " +
                "marked undone:\n" + input);
    }

    /**
     * Prints a message indicating that a task has been removed.
     *
     * @param input a string representation of the task that has been removed
     */
    public String printRemoved(String input) {
        return print("Removed task.Task: " + input);
    }

    /**
     * Prints the found tasks with a themed message.
     *
     * @param input the string representation of the found tasks to be displayed
     */
    public String printFoundTasks(String input){
        return print("Ah... so you seek among your tasks, do you?\n" +
                "Very well. I shall unveil what lies hidden in your list...\n" + input);
    }

    public String printNotFoundTasks(){
        return print("""
                Ah... so you seek among your tasks, do you?
                Yet I find no record of such a thing in your keeping...
                Be watchful, for only the tasks you have written may answer your call.""");
    }
}
