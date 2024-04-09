package task2;

import task2.Chat.GroupChat;
import task2.User.BasicUser;

public class Main {
    public static void main(String[] args){
        GroupChat groupChat = new GroupChat();
        BasicUser Adrian = new BasicUser("Adrian");
        BasicUser Maria = new BasicUser("Maria");
        BasicUser Matei = new BasicUser("Matei");
        BasicUser Ion = new BasicUser("Ion");

        groupChat.subscribeUser(Adrian,"programare");
        groupChat.subscribeUser(Maria,"programare");
        groupChat.subscribeUser(Matei,"programare");
        groupChat.subscribeUser(Ion,"programare");

        groupChat.subscribeUser(Adrian,"gatit");
        groupChat.subscribeUser(Maria,"gatit");

        groupChat.sendMessage(Ion ,"programare","Salutare");
        groupChat.sendMessage(Adrian,"gatit","Bon apetit");
        groupChat.sendMessage(Adrian,"unexistentTopic","Salut");
    }
}
