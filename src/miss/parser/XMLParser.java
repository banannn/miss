package miss.parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import miss.message.Messages;
import miss.participant.Bot;
import miss.participant.Participant;
import miss.rules.Rules;

public class XMLParser implements Parser {

	private JAXBContext jaxbContext;
    private Unmarshaller jaxbUnmarshaller;
    
	public XMLParser() {
		
	}
	
	@Override
	public Participant parse(String msgFile, String ruleFile) {
		Messages messages = null;
		Rules rules = null;
        try {
			jaxbContext = JAXBContext.newInstance("miss.message");
	        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        messages = (Messages) jaxbUnmarshaller.unmarshal( 
	        					new File(msgFile));

	        jaxbContext = JAXBContext.newInstance("miss.rules");
	        jaxbUnmarshaller = jaxbContext.createUnmarshaller();
	        rules = (Rules) jaxbUnmarshaller.unmarshal(
	        					new File(ruleFile));
	        
	        rules.setMessages(messages);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
        
        return new Bot(rules);
	}

}
