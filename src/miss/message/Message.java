package miss.message;

import javax.xml.bind.annotation.XmlElement;

public abstract class Message {
    protected Message(){
        id = null;
    }

    public abstract Message parseResponse(String response);

    @XmlElement
    private final Long id;

    public Message(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
