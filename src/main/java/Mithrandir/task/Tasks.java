package Mithrandir.task;

public enum Tasks {
    TODO {
        @Override
        public Task createTask(String completionStatus, String description) {
            Todo newTask = new Todo(description);
            if (completionStatus.equals("done")) {
                newTask.markDone();
            } else {
                newTask.markUndone();
            }
            return newTask;
        }
    },
    EVENT {
        @Override
        public Task createTask(String completionStatus, String description) {
            Event newTask = new Event(description);
            if (completionStatus.equals("done")) {
                newTask.markDone();
            } else {
                newTask.markUndone();
            }
            return newTask;
        }
    },
    DEADLINE {
        @Override
        public Task createTask(String completionStatus, String description) {
            Deadline newTask = new Deadline(description);
            if (completionStatus.equals("done")) {
                newTask.markDone();
            } else {
                newTask.markUndone();
            }
            return newTask;
        }
    };

    public abstract Task createTask(String completionStatus, String description) throws Exception;
}
