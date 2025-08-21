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

    public void printAddToList(Todo todo){
        System.out.println(separator);
        System.out.println("Added Todo: " + todo);
        System.out.println(separator);
    }

    public void printAddToList(Event event){
        System.out.println(separator);
        System.out.println("Added Event: " + event);
        System.out.println(separator);
    }

    public void printAddToList(Deadline deadline){
        System.out.println(separator);
        System.out.println("Added Deadline: " + deadline);
        System.out.println(separator);
    }

    public void printList(String[] input){
        System.out.println(separator);
        for (int i = 0; i < input.length; i+=1){
            System.out.println(String.format("%d.", i + 1) + input[i].trim());
        }
        System.out.println(separator);
    }

    public void printMarkDoneSuccessful(String input){
        System.out.println(separator);
        System.out.println("Well done! The following task is deemed complete:\n" + input);
        System.out.println(separator);
    }

    public void printMarkDoneUnsuccessful(){
        System.out.println(separator);
        System.out.println("You cannot mark one task repeatedly!");
        System.out.println(separator);
    }

    public void printMarkUndoneSuccessful(String input){
        System.out.println(separator);
        System.out.println("Alas! It's the job that's never started as takes longest to finish. This task is " +
                "marked undone:\n" + input);
        System.out.println(separator);
    }

    public void printMarkUndoneUnsuccessful(){
        System.out.println(separator);
        System.out.println("You cannot unmark one task repeatedly!");
        System.out.println(separator);
    }

}
