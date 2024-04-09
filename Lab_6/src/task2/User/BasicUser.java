package task2.User;

import task2.Message;

public class BasicUser implements User{

    private final String name;

    public BasicUser(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void update(Message message) {
        BasicUser basicUser = (BasicUser) message.getUser();
        System.out.println("[" + name + "] " + basicUser.getName() + " @ " + message.getDestinationTopic() + ": " + message.getContent());
    }
}
