package miss.message;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Messages {

    private Message[] messages;

    public Message[] getMessages() {
        return messages;
    }

    @XmlElement(name = "message")
    public void setMessages(Message[] messages) {
        this.messages = messages;
    }
}