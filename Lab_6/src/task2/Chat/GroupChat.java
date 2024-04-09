package task2.Chat;

import task2.User.BasicUser;
import task2.Message;
import task2.User.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GroupChat implements Chat{

    private final Map<String, ArrayList<User>> topics;

    public GroupChat() {
        this.topics = new HashMap<>();
    }

    @Override
    public void subscribeUser(User user, String topic) {
        ArrayList<User> users = topics.get(topic);
        if(users == null){
            topics.put(topic, new ArrayList<>());
            users = topics.get(topic);
        }
        users.add(user);
    }

    @Override
    public void unsubscribeUser(User user, String topic) {
        ArrayList<User> users = topics.get(topic);
        if(users != null){
            users.remove(user);
        }
    }

    @Override
    public void notifyUser(Message message) {
        String destinationTopic = message.getDestinationTopic();
        User sourceUser = message.getUser();
        ArrayList<User> users = topics.get(destinationTopic);

        if(users != null){
            int index = users.indexOf(sourceUser);
            if(index >=0 ){
                BasicUser basicUser;
                for(int i=0;i<users.size();i++){
                    if(sourceUser instanceof BasicUser){
                        basicUser = (BasicUser) users.get(i);
                        if(i == index) {
                            continue;
                        }
                        basicUser.update(message);
                    }
                }
            }
        }
    }

    @Override
    public void sendMessage(User sourceUser, String destinationTopic, String message) {
        notifyUser(new Message(sourceUser,destinationTopic,message));
    }
}
