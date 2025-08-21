public class Mithrandir {
    public static void main(String[] args) {
        ChatBot chatBot = new ChatBot();
        try{
            chatBot.run();
        } catch(Exception e){
            System.err.println("IOException");
        }
    }
}
