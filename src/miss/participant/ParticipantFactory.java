package miss.participant;

import miss.message.Messages;
import miss.rule.Rules;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ParticipantFactory {
    public static Participant createBot(File messagesFile, File rulesFile) throws JAXBException {

        Messages messages;

        JAXBContext jaxbContext = JAXBContext.newInstance("miss.message");
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        messages = (Messages) jaxbUnmarshaller.unmarshal(messagesFile);

        return new Bot(messages, new Rules(messages) /* TODO wczytywanie XML-a z regułami */);

    }

    public static Participant createHuman() {
        return new Human();
    }
}
