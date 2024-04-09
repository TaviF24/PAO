package task2;

import task2.User.User;

public class Message implements Cloneable{
    private final User user;
    private final String destinationTopic;
    private final String content;

    public Message(User user, String destinationTopic, String content) {
        this.user = user;
        this.destinationTopic = destinationTopic;
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public String getDestinationTopic() {
        return destinationTopic;
    }

    public String getContent() {
        return content;
    }

    @Override
    public Message clone() {
        try {
            return (Message) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
