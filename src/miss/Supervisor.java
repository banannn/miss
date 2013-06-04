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
		for(;;) {
            if(negotiationEnds()) return;
            participant2.addResponse(participant1.getNextText());
            if(negotiationEnds()) return;
            participant1.addResponse(participant2.getNextText());
		}
	}

    private boolean negotiationEnds() {
        return participant2.negotiationEnds() || participant1.negotiationEnds();
    }


}
