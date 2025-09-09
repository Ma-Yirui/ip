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
        /**
         * Executes the BYE command to exit the application.
         *
         * @param ui the user interface component
         * @param list the task list (not used in this command)
         * @param input the command input, must be empty
         * @param storage the file storage component (not used in this command)
         * @throws InvalidArgumentException if input is not empty
         */
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException {
            if (!input.isEmpty()) {
                throw new InvalidArgumentException("BYE command have no argument!");
            }
            ui.exit();
        }
    },
    LIST {
        /**
         * Executes the LIST command to display all tasks in the task list.
         *
         * @param ui the user interface component
         * @param list the task list to display
         * @param input the command input, must be empty
         * @param storage the file storage component (not used in this command)
         * @throws InvalidArgumentException if input is not empty
         */
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException {
            if (!input.isEmpty()) {
                throw new InvalidArgumentException("LIST command have no argument!");
            }
            if (list.isEmpty()) {
                ui.print("No tasks in the list.");
            } else {
                ui.print(list.toString());
            }
        }
    },
    MARK {
        /**
         * Executes the MARK command to mark a task as done.
         *
         * @param ui the user interface component
         * @param list the task list containing the task to mark
         * @param input the command input containing the task index (1-based)
         * @param storage the file storage component to save changes
         * @throws InvalidArgumentException if input is empty or not a valid integer
         * @throws IOException if an error occurs while saving to storage
         */
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("MARK command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                list.Mark(index);
                ui.mark(list.getTask(index));
                storage.store(list.generateFileStrings());
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("MARK command need one INTEGER as argument!");
            }
        }
    },
    UNMARK {
        /**
         * Executes the UNMARK command to mark a task as not done.
         *
         * @param ui the user interface component
         * @param list the task list containing the task to unmark
         * @param input the command input containing the task index (1-based)
         * @param storage the file storage component to save changes
         * @throws InvalidArgumentException if input is empty or not a valid integer
         * @throws IOException if an error occurs while saving to storage
         */
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("UNMARK command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                list.Unmark(index);
                ui.unmark(list.getTask(index));
                storage.store(list.generateFileStrings());
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("UNMARK command need one INTEGER as argument!");
            }
        }
    },
    TODO {
        /**
         * Executes the TODO command to create a new Todo task.
         *
         * @param ui the user interface component
         * @param list the task list to add the new task to
         * @param input the command input containing the task description
         * @param storage the file storage component to save changes
         * @throws InvalidArgumentException if input is empty
         * @throws IOException if an error occurs while saving to storage
         */
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("TODO command need STRING as Mithrandir.task description!");
            }
            Todo todo = new Todo(input);
            ui.addTodoToList(todo);
            list.addTask(todo);
            storage.store(list.generateFileStrings());
        }
    },
    EVENT {
        /**
         * Executes the EVENT command to create a new Event task.
         *
         * @param ui the user interface component
         * @param list the task list to add the new task to
         * @param input the command input containing task description and time information
         * @param storage the file storage component to save changes
         * @throws InvalidArgumentException if input is empty
         * @throws MithrandirException if the event format is invalid
         * @throws IOException if an error occurs while saving to storage
         */
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
                storage.store(list.generateFileStrings());
            } catch (MithrandirException e) {
                throw e;
            }
        }
    },
    DEADLINE {
        /**
         * Executes the DEADLINE command to create a new Deadline task.
         *
         * @param ui the user interface component
         * @param list the task list to add the new task to
         * @param input the command input containing task description and deadline information
         * @param storage the file storage component to save changes
         * @throws InvalidArgumentException if input is empty
         * @throws MithrandirException if the deadline format is invalid
         * @throws IOException if an error occurs while saving to storage
         */
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
                storage.store(list.generateFileStrings());
            } catch (MithrandirException e) {
                throw e;
            }
        }
    },
    DELETE {
        /**
         * Executes the DELETE command to remove a task from the task list.
         *
         * @param ui the user interface component
         * @param list the task list to remove the task from
         * @param input the command input containing the task index (1-based)
         * @param storage the file storage component to save changes
         * @throws InvalidArgumentException if input is empty, not a valid integer, or index is out of bounds
         * @throws IOException if an error occurs while saving to storage
         */
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("DELETE command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                ui.delete(list.DeleteTask(index));
                storage.store(list.generateFileStrings());
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("DELETE command need one INTEGER as argument!");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidArgumentException("Index to be deleted is out of bounds of the todo list!");
            }
        }
    },
    FIND {
        @Override
        public void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("FIND command need STRING as argument!");
            }
            System.out.println(input);
            TaskList foundTasks = list.findTasks(input);
            ui.printFoundTasks(foundTasks);
        }

    }
    ;
    abstract void execute(Ui ui, TaskList list, String input, FileStorage storage) throws MithrandirException, IOException;
}