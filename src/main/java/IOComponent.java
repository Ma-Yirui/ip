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
        print("Removed Task: " + input);
    }
}
