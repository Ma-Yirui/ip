package Mithrandir.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class Event extends Task {
    private final LocalDateTime fromTime;
    private final LocalDateTime toTime;

    /**
     * Constructs a new Event object from a given description.
     *
     * @param description A string containing the description of the event.
     *                    The description must be in the format:
     *                    task description /from start time /to end time.
     *                    The start time and end time must be in the format:
     *                    dd/MM/yyyy HH:mm.
     * @throws DateTimeParseException if the start time or end time in the description
     *                                cannot be parsed into a LocalDateTime object.
     */
    public Event(String description) throws DateTimeParseException {
        super(description.split("/from")[0].trim());
        String[] params = description.split("/from")[1].split("/to");
        this.fromTime = LocalDateTime.parse(params[0].trim(), this.formatter);
        this.toTime = LocalDateTime.parse(params[1].trim(), this.formatter);
    }

    @Override
    public String toFileString() {
        return "EVENT || " + super.toFileString() +  String.format(" /from %s /to %s",
                this.fromTime.format(this.formatter), this.toTime.format(this.formatter));
    }

    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(), this.fromTime.format(this.formatter),
                this.toTime.format(this.formatter));
    }
}
