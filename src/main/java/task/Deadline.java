package task;

public class Deadline extends Task {
    private final String byTime;


    public Deadline(String description) {
        super(description.split("/by")[0].trim());
        this.byTime = description.split("/by")[1].trim();

    }

    @Override
    public String toString(){
        return String.format("[E]%s (by: %s)", super.toString(), this.byTime);
    }
}
