package miss.message;

import java.math.BigDecimal;

public class DecimalQuestion extends Question {
    private final String question;

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
