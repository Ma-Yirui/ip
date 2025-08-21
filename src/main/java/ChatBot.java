import java.util.ArrayList;

public class ChatBot {
    private final IOComponent IOComponent =  new IOComponent();
    private final ArrayList<Task> toDoList = new ArrayList<>();

    public void greet(){
        this.IOComponent.greet();
    }

    public void addToList(String input){
        this.toDoList.add(new Task(input));
        this.IOComponent.printAddToList(input);
    }

    public void printList(){
        this.IOComponent.printList(this.toDoList.toString()
                .substring(1, this.toDoList.toString().length() - 1).split(","));
    }

    public void exit(){
        this.IOComponent.exit();
    }

    public void mark(int index) {
        Task task = this.toDoList.get(index);
        if (task.isMarked()) {
            this.IOComponent.printMarkDoneUnsuccessful();
            return;
        }
        task.markDone();
        this.IOComponent.printMarkDoneSuccessful(task.toString());
    }

    public void unmark(int index) {
        Task task = this.toDoList.get(index);
        if (!task.isMarked()) {
            this.IOComponent.printMarkUndoneUnsuccessful();
            return;
        }
        task.markUndone();
        this.IOComponent.printMarkUndoneSuccessful(task.toString());
    }
}
