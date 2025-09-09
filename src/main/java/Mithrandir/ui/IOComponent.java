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
    public static void print(String message) {
        System.out.println(separator);
        System.out.println(message);
        System.out.println(separator);
    }

    /**
     * Prints a greeting message from Gandalf.
     */
    public void greet() {
        print("A wizard is never late, nor is he early. "
                + "He arrives precisely when he means to. "
                + "Greetings from Gandalf.");
    }

    /**
     * Prints a farewell message from Gandalf.
     */
    public void exit() {
        print("Farewell. My work is now finished.");
    }

    /**
     * Prints a message stating that a Todo task has been added to the list.
     *
     * @param todo the Todo task that has been added
     */
    public void printAddToList(Todo todo) {
        print("Added Todo: " + todo);
    }

    /**
     * Prints a message stating that an Event task has been added to the list.
     *
     * @param event the Event task that has been added
     */
    public void printAddToList(Event event) {
        print("Added Event: " + event);
    }

    /**
     * Prints a message stating that a Deadline task has been added to the list.
     *
     * @param deadline the Deadline task that has been added
     */
    public void printAddToList(Deadline deadline) {
        print("Added Deadline: " + deadline);
    }

    /**
     * Prints a list of strings, each prefixed with its index in the list.
     *
     * @param input an array of strings to be printed
     */
    public void printList(String[] input) {
        System.out.println(separator);
        for (int i = 0; i < input.length; i++) {
            System.out.printf("%d. %s%n", i + 1, input[i].trim());
        }
        System.out.println(separator);
    }

    /**
     * Prints a message indicating that a task has been successfully marked as done.
     *
     * @param input a string representation of the task that has been marked done
     */
    public void printMarkDoneSuccessful(String input) {
        print("Well done! The following task is deemed complete:\n" + input);
    }

    /**
     * Prints a message indicating that a task has been successfully marked as undone.
     *
     * @param input a string representation of the task that has been marked undone
     */
    public void printMarkUndoneSuccessful(String input) {
        print("Alas! It's the job that's never started as takes longest to finish. This task is " +
                "marked undone:\n" + input);
    }

    /**
     * Prints a message indicating that a task has been removed.
     *
     * @param input a string representation of the task that has been removed
     */
    public void printRemoved(String input) {
        print("Removed task.Task: " + input);
    }

    /**
     * Prints the found tasks with a themed message.
     *
     * @param input the string representation of the found tasks to be displayed
     */
    public void printFoundTasks(String input){
        print("Ah... so you seek among your tasks, do you?\n" +
                "Very well. I shall unveil what lies hidden in your list...\n" + input);
    }

    public void printNotFoundTasks(){
        print("""
                Ah... so you seek among your tasks, do you?
                Yet I find no record of such a thing in your keeping...
                Be watchful, for only the tasks you have written may answer your call.""");
    }
}
