public class Deadline extends Task {
    private final String fromTime;
    private final String toTime;

    public Deadline(String description) {
        super(description.split("/from")[0].trim());
        String[] params = description.split("/from")[1].split("/to");
        this.fromTime = params[0].trim();
        this.toTime = params[1].trim();
    }

    @Override
    public String toString() {
        return String.format("[D]%s (from: %s to: %s)", super.toString(), this.fromTime,  this.toTime);
    }
}
