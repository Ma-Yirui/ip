package Mithrandir.task;

public class Task {
    private final String description;
    private Boolean isDone = false;

    public Task(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getMark() {
        return isDone ? "x" : " ";
    }

    public void markDone() {
        isDone = true;
    }

    public void markUndone() {
        isDone = false;
    }

    public boolean isMarked() {
        return isDone;
    }

    public String toFileString() {
        return String.format("%s || %s", isMarked() ? "done" : "undone", getDescription());
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", getMark(), getDescription());
    }
}
