package miss.participant;

import javax.xml.bind.JAXBException;

import miss.parser.Parser;

public class ParticipantFactory {
	
	
	
    public static Participant createBot(String messagesFile, String rulesFile,
    		Parser parser) throws JAXBException {
    	
    	return parser.parse(messagesFile, rulesFile);

    }

    public static Participant createHuman() {
        return new Human();
    }
}
