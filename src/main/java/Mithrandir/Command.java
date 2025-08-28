package Mithrandir;

import Mithrandir.MithrandirExceptions.*;
import Mithrandir.task.Deadline;
import Mithrandir.task.Event;
import Mithrandir.task.Task;
import Mithrandir.task.Todo;

public enum Command {
    BYE {
        @Override
        public void execute(ChatBot chatBot, TaskList list, String input) throws MithrandirException {
            if(!input.isEmpty()) {
                throw new InvalidArgumentException("BYE command have no argument!");
            }
            chatBot.exit();
        }
    },
    LIST {
        @Override
        public void execute(ChatBot chatBot, TaskList list, String input) throws MithrandirException {
            if(!input.isEmpty()) {
                throw new InvalidArgumentException("LIST command have no argument!");
            }
            chatBot.print(list.toString());
        }
    },
    MARK {
        @Override
        public void execute(ChatBot chatBot, TaskList list, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("MARK command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                list.Mark(index);
                chatBot.mark(list.getTask(index));
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("MARK command need one INTEGER as argument!");
            }
        }
    },
    UNMARK {
        @Override
        public void execute(ChatBot chatBot, TaskList list, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("UNMARK command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                list.Unmark(index);
                chatBot.unmark(list.getTask(index));
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("UNMARK command need one INTEGER as argument!");
            }
        }
    },
    TODO {
        @Override
        public void execute(ChatBot chatBot, TaskList list, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("TODO command need STRING as Mithrandir.task description!");
            }
            Todo todo = new Todo(input);
            chatBot.addTodoToList(todo);
            list.addTask(todo);
        }
    },
    EVENT {
        @Override
        public void execute(ChatBot chatBot, TaskList list, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("Event command need 4 parts: task description, '/by', " +
                        "start time of task and end time of task!");
            }
            try {
                Event event = new Event(input);
                chatBot.addEventToList(event);
                list.addTask(event);
            } catch (MithrandirException e) {
                throw e;
            }
        }
    },
    DEADLINE {
        @Override
        public void execute(ChatBot chatBot, TaskList list, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("Deadline command need 3 parts: task description, '/by' and " +
                        "deadline " +
                        "of the task!");
            }
            try {
                Deadline deadline = new Deadline(input);
                chatBot.addDeadlineToList(deadline);
                list.addTask(deadline);
            } catch (MithrandirException e) {
                throw e;
            }
        }
    },
    DELETE {
        @Override
        public void execute(ChatBot chatBot, TaskList list, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("DELETE command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                chatBot.delete(list.DeleteTask(index));
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("DELETE command need one INTEGER as argument!");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidArgumentException("Index to be deleted is out of bounds of the todo list!");
            }
        }
    }
    ;
    abstract void execute(ChatBot chatBot, TaskList list, String input) throws MithrandirException;
}