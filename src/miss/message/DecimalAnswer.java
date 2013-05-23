package miss.message;

import java.math.BigDecimal;

public class DecimalAnswer extends Answer {

    private final BigDecimal answer;

    public DecimalAnswer(BigDecimal answer){
        this.answer = answer;
    }

    public BigDecimal getAnswer() {
        return answer;
    }
}
