package Mithrandir.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;

public class Deadline extends Task {
    private final LocalDateTime byTime;


    public Deadline(String description) throws DateTimeParseException {
        super(description.split("/by")[0].trim());
        this.byTime = LocalDateTime.parse(description.split("/by")[1].trim(), this.formatter);
    }

    @Override
    public String toFileString() {
        return "DEADLINE || " + super.toFileString() + String.format(" /by %s", this.byTime.format(this.formatter));
    }

    @Override
    public String toString(){
        return String.format("[D]%s (by: %s)", super.toString(), this.byTime.format(this.formatter));
    }
}
