package miss;

import miss.participant.Participant;


public class Supervisor {

    private Participant participant1;
    private Participant participant2;


    public Supervisor(Participant participant1, Participant participant2) {
        this.participant1 = participant1;
        this.participant2 = participant2;
    }


    public void startNegotiations() {
        while (!participant2.negotiationEnds() && !participant1.negotiationEnds()) {
            participant2.addResponse(participant1.getNextText());
            participant1.addResponse(participant2.getNextText());
        }
    }


}
