package miss.rule;

import javax.xml.bind.annotation.XmlElement;

import miss.message.Message;

public class IdEqualsVerifier extends Verifier {
//    @XmlElement
//    public void setMessageId(long messageId) {
//        this.messageId = messageId;
//    }
//
//    public long getMessageId() {
//        return messageId;
//    }

    private Message messageId;

    @Override
    public boolean isConsistent(Message messageId) {
        return messageId == this.messageId;
    }
}
