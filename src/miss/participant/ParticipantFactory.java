package miss.participant;

import miss.message.Messages;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ParticipantFactory {
    public static Participant createBot(File file) throws JAXBException {

        Messages messages;

        JAXBContext jaxbContext = JAXBContext.newInstance("miss.message");
        Unmarshaller jaxbUnarshaller = jaxbContext.createUnmarshaller();

        messages = (Messages) jaxbUnarshaller.unmarshal(file);

        return new Bot(messages.getMessages());

    }

    public static Participant createHuman() {
        return new Human();
    }
}
