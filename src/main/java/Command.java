public enum Command {
    BYE {
        @Override
        public void execute(ChatBot chatBot, String input) {
            chatBot.exit();
        }
    },
    LIST {
        @Override
        public void execute(ChatBot chatBot, String input) {
            chatBot.printList();
        }
    },
    MARK {
        @Override
        public void execute(ChatBot chatBot, String input) {
            int index = Integer.parseInt(input.split(" ")[0]) - 1;
            chatBot.mark(index);
        }
    },
    UNMARK {
        @Override
        public void execute(ChatBot chatBot, String input) {
            int index = Integer.parseInt(input.split(" ")[0]) - 1;
            chatBot.unmark(index);
        }
    },
    TODO {
        @Override
        public void execute(ChatBot chatBot, String input) {
            chatBot.addTodoToList(input);
        }
    },
    EVENT {
        @Override
        public void execute(ChatBot chatBot, String input) {
            chatBot.addEventToList(input);
        }
    },
    DEADLINE {
        @Override
        public void execute(ChatBot chatBot, String input) {
            chatBot.addDeadlineToList(input);
        }
    };
    abstract void execute(ChatBot chatBot, String input);
}