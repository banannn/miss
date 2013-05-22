package miss.rule;

import javax.xml.bind.annotation.XmlElement;

public class IdEqualsVerifier extends Verifier {
    @XmlElement
    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public long getMessageId() {
        return messageId;
    }

    private long messageId;

    @Override
    public boolean isConsistent(long messageId) {
        return messageId == this.messageId;
    }
}
