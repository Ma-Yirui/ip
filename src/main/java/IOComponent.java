import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class IOComponent {
    private static final String separator = new String(new char[50]).replace('\0', '-');

    public void greet() {
        System.out.println(separator);
        System.out.println("A wizard is never late, nor is he early. "
                + "He arrives precisely when he means to. "
                + "Greetings from Gandalf.");
        System.out.println(separator);
    }

    public void exit(){
        System.out.println(separator);
        System.out.println("Farewell. My work is now finished.");
        System.out.println(separator);
    }

    public void echo(String input){
        System.out.println(separator);
        System.out.println(input);
        System.out.println(separator);
    }

    public void printAddToList(String input){
        System.out.println(separator);
        System.out.println("Added: " + input);
        System.out.println(separator);
    }

    public void printList(String[] input){
        System.out.println(separator);
        for (int i = 0; i < input.length; i+=1){
            System.out.println(String.format("%d. ", i + 1) + input[i].trim());
        }
        System.out.println(separator);
    }

}
