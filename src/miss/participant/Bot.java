package miss.participant;

import miss.message.Message;
import miss.message.Messages;
import miss.message.OfferAccept;
import miss.rule.Rules;

public class Bot implements Participant {

    private final Messages messages;
    private boolean negotiationEnds = false;

    private Message received;
    private Message sent;
    private Rules rules;


    public Bot(Messages messages, Rules rules) {
        this.messages = messages;
        this.rules = rules;
    }

    @Override
    public boolean negotiationEnds() {
        return negotiationEnds;
    }

    @Override
    public void addResponse(Message response) {
        this.received = response;
        negotiationEnds = response instanceof OfferAccept;
    }

    @Override
    public Message getNextText() {
        this.sent = rules.getNextMessage(sent, received);
        return this.sent;
    }

}
