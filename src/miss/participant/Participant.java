package miss.participant;

public interface Participant {
    /**
     * returns true if Participant thinks that is end of negotiations
     */
    boolean negotiationEnds();

    /**
     * adds buyer's response and changes state of Participant
     */
    void addResponse(String response);

    /**
     * returns repsonse
     * @return
     */
    String getNextText();
}
