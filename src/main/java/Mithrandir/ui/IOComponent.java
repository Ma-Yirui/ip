package Mithrandir.ui;

import Mithrandir.task.Todo;
import Mithrandir.task.Event;
import Mithrandir.task.Deadline;

public class IOComponent {
    private static final String separator = new String(new char[50]).replace('\0', '-');

    public static void print(String message) {
        System.out.println(separator);
        System.out.println(message);
        System.out.println(separator);
    }

    public void greet() {
        print("A wizard is never late, nor is he early. "
                + "He arrives precisely when he means to. "
                + "Greetings from Gandalf.");
    }

    public void exit(){
        print("Farewell. My work is now finished.");
    }

    public void echo(String input){
        print(input);
    }

    public void printAddToList(Todo todo){
        print("Added Todo: " + todo);
    }

    public void printAddToList(Event event){
        print("Added Event: " + event);
    }

    public void printAddToList(Deadline deadline){
        print("Added Deadline: " + deadline);
    }

    public void printList(String[] input){
        System.out.println(separator);
        for (int i = 0; i < input.length; i+=1){
            System.out.println(String.format("%d.", i + 1) + input[i].trim());
        }
        System.out.println(separator);
    }

    public void printMarkDoneSuccessful(String input){
        print("Well done! The following task is deemed complete:\n" + input);
    }

    public void printMarkDoneUnsuccessful(){
        print("You cannot mark one task repeatedly!");
    }

    public void printMarkUndoneSuccessful(String input){
        System.out.println(separator);
        System.out.println("Alas! It's the job that's never started as takes longest to finish. This task is " +
                "marked undone:\n" + input);
        System.out.println(separator);
    }

    public void printMarkUndoneUnsuccessful(){
        print("You cannot unmark one task repeatedly!");
    }

    public void printRemoved(String input){
        print("Removed task.Task: " + input);
    }

    /**
     * Prints the found tasks with a themed message.
     *
     * @param input the string representation of the found tasks to be displayed
     */
    public void printFoundTasks(String input){
        print("Ah… so you seek among your tasks, do you?\n" +
                "Very well. I shall unveil what lies hidden in your list...\n" + input);
    }

    public void printNotFoundTasks(){
        print("""
                Ah… so you seek among your tasks, do you?
                Yet I find no record of such a thing in your keeping...
                Be watchful, for only the tasks you have written may answer your call.""");
    }
}
