package miss.participant;

import miss.message.Message;
import miss.rules.Rules;

public class Bot extends Participant {

    private Rules rules;

    public Bot(Rules rules) {
        this.rules = rules;
    }

    @Override
    public Message getNextText() {
        return rules.getNextMessage(received);
    }

}
