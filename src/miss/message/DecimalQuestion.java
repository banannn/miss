package miss.message;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

public class DecimalQuestion extends Question {
    @XmlElement
    private final String question;

    private DecimalQuestion(){
        question = null;
    }

    public DecimalQuestion(Long id, String question) {
        super(id);
        this.question = question;
    }

    @Override
    public Message parseResponse(String response) {
        return new DecimalAnswer(new BigDecimal(response));
    }

    @Override
    public String toString() {
        return question;
    }
}
