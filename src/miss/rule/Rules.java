package miss.rule;

import miss.message.Message;
import miss.message.Messages;

// TODO - póki co jest wydmuszka zwracająca kolejno wiadomości
public class Rules {
    private final Message[] messages;
    private int next = -1;


    public Rules(Messages messages) {
        this.messages = messages.getMessages();
    }

    public Message getNextMessage(Message sent, Message received) {

        next = (next + 1) % messages.length;

        return messages[next];

    }

}
