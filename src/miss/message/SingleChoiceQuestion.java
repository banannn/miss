package miss.message;

import java.util.List;

public class SingleChoiceQuestion extends ChoiceQuestion {

    public static final String WYBIERZ_JEDEN_ELEMENT_Z_LISTY = "Wybierz jeden element z listy: ";

    public SingleChoiceQuestion(Long id, List<String> choices) {
        super(id, choices);
    }

    @Override
    public Message parseResponse(String response) {
        int i = new Integer(response) - 1;
        return new SingleChoiceAnswer(choices.get(i));
    }

    @Override
    public String toString() {
        return WYBIERZ_JEDEN_ELEMENT_Z_LISTY + listChoices();
    }

}
