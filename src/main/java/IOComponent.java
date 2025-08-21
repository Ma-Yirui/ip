import java.io.BufferedReader;
import java.io.IOException;

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

}
