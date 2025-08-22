import MithrandirExceptions.*;

public enum Command {
    BYE {
        @Override
        public void execute(ChatBot chatBot, String input) throws MithrandirException {
            if(!input.isEmpty()) {
                throw new InvalidArgumentException("BYE command have no argument!");
            }
            chatBot.exit();
        }
    },
    LIST {
        @Override
        public void execute(ChatBot chatBot, String input) throws MithrandirException {
            if(!input.isEmpty()) {
                throw new InvalidArgumentException("LIST command have no argument!");
            }
            chatBot.printList();
        }
    },
    MARK {
        @Override
        public void execute(ChatBot chatBot, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("MARK command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                chatBot.mark(index);
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("MARK command need one INTEGER as argument!");
            }
        }
    },
    UNMARK {
        @Override
        public void execute(ChatBot chatBot, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("UNMARK command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                chatBot.unmark(index);
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("UNMARK command need one INTEGER as argument!");
            }
        }
    },
    TODO {
        @Override
        public void execute(ChatBot chatBot, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("TODO command need STRING as task description!");
            }
            chatBot.addTodoToList(input);
        }
    },
    EVENT {
        @Override
        public void execute(ChatBot chatBot, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("EVENT command need 3 parts: task description, '/by' and deadline " +
                        "of the task!");
            }
            try {
                chatBot.addEventToList(input);
            } catch (MithrandirException e) {
                throw e;
            }
        }
    },
    DEADLINE {
        @Override
        public void execute(ChatBot chatBot, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("Deadline command need 4 parts: task description, '/by', " +
                        "start time of task and end time of task!");
            }
            try {
                chatBot.addDeadlineToList(input);
            } catch (MithrandirException e) {
                throw e;
            }
        }
    },
    DELETE {
        @Override
        public void execute(ChatBot chatBot, String input) throws MithrandirException {
            if (input.isEmpty()) {
                throw new InvalidArgumentException("DELETE command need EXACTLY ONE integer as argument!");
            }
            try {
                int index = Integer.parseInt(input.split(" ")[0]) - 1;
                chatBot.delete(index);
            } catch (NumberFormatException e) {
                throw new InvalidArgumentException("DELETE command need one INTEGER as argument!");
            } catch (IndexOutOfBoundsException e) {
                throw new InvalidArgumentException("Index to be deleted is out of bounds of the todo list!");
            }
        }
    }
    ;
    abstract void execute(ChatBot chatBot, String input) throws MithrandirException;
}