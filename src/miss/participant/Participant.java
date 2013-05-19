package miss.participant;

import miss.message.Message;

public interface Participant {
    /**
     * returns true if Participant thinks that is end of negotiations
     */
    boolean negotiationEnds();

    /**
     * adds buyer's response and changes state of Participant
     */
    void addResponse(Message response);

    /**
     * returns repsonse
     * @return
     */
    Message getNextText();
}
