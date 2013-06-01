package miss.rules;

import miss.message.DecimalAnswer;
import miss.message.Message;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

public class GreaterThanOrEqualVerifier extends Verifier {

    private BigDecimal value;

    @Override
    public boolean isConsistent(Message message) {
    	System.out.println(value == null ? "null value" : "not null value");
    	System.out.println(message == null ? "null message" : "not null message1" +
    			"");
        return ((DecimalAnswer) message).getAnswer().compareTo(value) >= 0;
    }

    public BigDecimal getValue() {
        return value;
    }

    @XmlElement
    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
