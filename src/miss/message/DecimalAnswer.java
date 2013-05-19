package miss.message;

import java.math.BigDecimal;

public class DecimalAnswer extends Answer {

    private final BigDecimal answer;

    DecimalAnswer(BigDecimal answer){
        this.answer = answer;
    }

}
