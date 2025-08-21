import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ChatBot {
    private final IOComponent IOComponent =  new IOComponent();
    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private final ArrayList<String> toDoList = new ArrayList<String>();

    public void run() throws IOException{
        this.IOComponent.greet();
        String nextLine = bufferedReader.readLine();
        while (true){
            nextLine = nextLine.trim();
            if (nextLine.equalsIgnoreCase("bye")){
                this.IOComponent.exit();
                return;
            } else if (nextLine.equalsIgnoreCase("list")){
                this.printList();
            } else {
                this.addToList(nextLine);
            }
            nextLine = bufferedReader.readLine();
        }
    }

    public void addToList(String input){
        this.toDoList.add(input);
        this.IOComponent.printAddToList(input);
    }

    public void printList(){
        this.IOComponent.printList(this.toDoList.toString()
                .replace("[", "").replace("]", "").split(","));
    }

}
