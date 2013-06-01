package miss;

import miss.parser.ParserFactory;
import miss.participant.Participant;
import miss.participant.ParticipantFactory;

import javax.xml.bind.JAXBException;
import java.io.File;

public class App {

    public static void main(String[] args) {

        Supervisor supervisor = new Supervisor(getSeller(), getBuyer());
        supervisor.startNegotiations();

    }

    private static Participant getBuyer() {
        return ParticipantFactory.createHuman();
    }

    private static Participant getSeller() {
        try {
            return ParticipantFactory.createBot(
                    "resources/messages.xml",
                    "resources/rules.xml",
                    ParserFactory.createXmlParser()
            );
        } catch (JAXBException e) {
            e.printStackTrace();
            System.exit(-1);
            return null;
        }
    }

}
