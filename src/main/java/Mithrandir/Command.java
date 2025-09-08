package Mithrandir;

import java.io.IOException;

import Mithrandir.MithrandirExceptions.InvalidArgumentException;
import Mithrandir.MithrandirExceptions.MithrandirException;
import Mithrandir.storage.FileStorage;
import Mithrandir.task.Deadline;
import Mithrandir.task.Event;
import Mithrandir.task.Todo;
import Mithrandir.ui.Ui;

public enum Command {
    BYE {
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException {
            if (!input.isEmpty()) {
                throw new InvalidArgumentException("BYE command have no argument!");
            }
            ui.exit();
        }
    },
    LIST {
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException {
            if (!input.isEmpty()) {
                throw new InvalidArgumentException("LIST command have no argument!");
            }
            ui.print(list.toString());
        }
    },
    MARK {
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("MARK command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                list.Mark(index);
                ui.mark(list.getTask(index));
                storage.Store(list.generateFileStrings());
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("MARK command need one INTEGER as argument!");
            }
        }
    },
    UNMARK {
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("UNMARK command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                list.Unmark(index);
                ui.unmark(list.getTask(index));
                storage.Store(list.generateFileStrings());
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("UNMARK command need one INTEGER as argument!");
            }
        }
    },
    TODO {
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("TODO command need STRING as Mithrandir.task description!");
            }
            Todo todo = new Todo(input);
            ui.addTodoToList(todo);
            list.addTask(todo);
            storage.Store(list.generateFileStrings());
        }
    },
    EVENT {
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("Event command need 4 parts: task description, '/by', " +
                        "start time of task and end time of task!");
            }
            try {
                Event event = new Event(input);
                ui.addEventToList(event);
                list.addTask(event);
                storage.Store(list.generateFileStrings());
            } catch (MithrandirException e) {
                throw e;
            }
        }
    },
    DEADLINE {
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("Deadline command need 3 parts: task description, '/by' and " +
                        "deadline " +
                        "of the task!");
            }
            try {
                Deadline deadline = new Deadline(input);
                ui.addDeadlineToList(deadline);
                list.addTask(deadline);
                storage.Store(list.generateFileStrings());
            } catch (MithrandirException e) {
                throw e;
            }
        }
    },
    DELETE {
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("DELETE command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                ui.delete(list.DeleteTask(index));
                storage.Store(list.generateFileStrings());
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("DELETE command need one INTEGER as argument!");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidArgumentException("Index to be deleted is out of bounds of the todo list!");
            }
        }
    };

    abstract void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException;
}