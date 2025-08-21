public enum Command {
    BYE {
        @Override
        public void execute(ChatBot chatBot, String input) {
            chatBot.exit();
        }
    },
    ADD {
        @Override
        public void execute(ChatBot chatBot, String input) {
            chatBot.addToList(input);
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
    };
    abstract void execute(ChatBot chatBot, String input);
}