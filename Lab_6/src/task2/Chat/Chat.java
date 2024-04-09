package task2.Chat;

import task2.Message;
import task2.User.User;

public interface Chat {
    void subscribeUser(User user, String topic);
    void unsubscribeUser(User user, String topic);
    void notifyUser(Message message);

    void sendMessage(User sourceUser, String destinationTopic, String message);
}
