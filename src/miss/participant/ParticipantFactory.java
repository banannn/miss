package miss.participant;

import miss.message.Messages;
import miss.rule.Rules;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class ParticipantFactory {
    public static Participant createBot(File messagesFile, File rulesFile) throws JAXBException {

        JAXBContext jaxbContext;
        Unmarshaller jaxbUnmarshaller;

        jaxbContext = JAXBContext.newInstance("miss.message");
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Messages messages = (Messages) jaxbUnmarshaller.unmarshal(messagesFile);

        jaxbContext = JAXBContext.newInstance("miss.rule");
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Rules rules = (Rules) jaxbUnmarshaller.unmarshal(rulesFile);

        rules.setMessages(messages);

        return new Bot(messages, rules);

    }

    public static Participant createHuman() {
        return new Human();
    }
}
