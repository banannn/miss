package miss.participant;

import miss.message.Message;
import miss.message.OfferAccept;

import java.util.Random;

public class Bot implements Participant {

    private final Message[] messages;
    private boolean negotiationEnds = false;

    private Random random = new Random();


    public Bot(Message[] messages) {
        this.messages = messages;
    }

    @Override
    public boolean negotiationEnds() {
        return negotiationEnds;
    }

    @Override
    public void addResponse(Message response) {
        negotiationEnds = response instanceof OfferAccept;
    }

    @Override
    public Message getNextText() {
        return messages[random.nextInt(messages.length)];
    }

}
