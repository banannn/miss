package miss.participant;

import miss.message.Message;

public abstract class Participant {
    protected Message received;
    private boolean negotiationEnds;

    /**
     * returns true if Participant thinks that is end of negotiations
     */
    public boolean negotiationEnds() {
        return negotiationEnds;
    }

    /**
     * adds buyer's response and changes state of Participant
     */
    public void addResponse(Message response) {
        this.received = response;
        if (response != null && !negotiationEnds)
            negotiationEnds = response.isFinal();
    }

    /**
     * returns repsonse
     * @return
     */
    public abstract Message getNextText();
}
