import MithrandirExceptions.InvalidArgumentException;
import MithrandirExceptions.MithrandirException;

import java.util.ArrayList;

public class ChatBot {
    private final IOComponent IOComponent =  new IOComponent();
    private final ArrayList<Task> toDoList = new ArrayList<>();

    public void greet(){
        this.IOComponent.greet();
    }

    public void addTodoToList(String input){
        Todo todo = new Todo(input);
        this.toDoList.add(todo);
        this.IOComponent.printAddToList(todo);
    }

    public void addEventToList(String input) throws MithrandirException {
        try {
            Event event = new Event(input);
            this.toDoList.add(event);
            this.IOComponent.printAddToList(event);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("EVENT command need 3 parts: task description, '/by' and deadline, you" +
                    " are missing on something. Check your command!");
        }
    }

    public void addDeadlineToList(String input) throws MithrandirException {
        try {
            Deadline deadline = new Deadline(input);
            this.toDoList.add(deadline);
            this.IOComponent.printAddToList(deadline);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidArgumentException("DEADLINE command need 4 parts: task description, '/by', Start time of" +
                    " task and end time of task. You are missing on something. Check your command!");
        }

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

    public void delete(int index) throws IndexOutOfBoundsException {
        Task task = this.toDoList.remove(index);
        this.IOComponent.printRemoved(task.toString());
    }

    public void print(String input){
        IOComponent.print(input);
    }
}
