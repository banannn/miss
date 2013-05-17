package miss;

import miss.participant.Participant;
import miss.participant.ParticipantFactory;

public class App {

    public static void main(String[] args) {

        Supervisor supervisor = new Supervisor(getSeller(), getBuyer());
        supervisor.startNegotiations();

    }

    private static Participant getBuyer() {
        return ParticipantFactory.createHuman();
    }

    private static Participant getSeller() {
        return ParticipantFactory.createBot();
    }

}
