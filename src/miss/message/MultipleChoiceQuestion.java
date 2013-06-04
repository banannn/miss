package miss.message;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoiceQuestion extends ChoiceQuestion {

    public static final String WYBIERZ_WYBRANĄ_LICZBĘ_ELEMENTÓW_Z_LISTY_PODAJ_LICZBY_ODDZIELONE_PRZECINKAMI = "Wybierz wybraną liczbę elementów z listy (podaj liczby oddzielone przecinkami): ";
    public static final String SEPERATOR = ",";

    private MultipleChoiceQuestion(){
    }

    public MultipleChoiceQuestion(Long id, List<String> choices) {
        super(id, choices);
    }

    @Override
    public Message parseResponse(String response) {
        List<String> answer = new ArrayList<>();
        for (String s : response.split(SEPERATOR)){
            int i = Integer.parseInt(s) - 1;
            answer.add(choices.get(i));
        }
        return new MultipleChoiceAnswer(answer.toArray(new String[answer.size()]));
    }

    @Override
    public String toString() {
        return WYBIERZ_WYBRANĄ_LICZBĘ_ELEMENTÓW_Z_LISTY_PODAJ_LICZBY_ODDZIELONE_PRZECINKAMI + listChoices();
    }
}
