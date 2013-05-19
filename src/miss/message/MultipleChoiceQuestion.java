package miss.message;

import java.util.List;

public class MultipleChoiceQuestion extends ChoiceQuestion {

    public static final String WYBIERZ_WYBRANĄ_LICZBĘ_ELEMENTÓW_Z_LISTY_PODAJ_LICZBY_ODDZIELONE_PRZECINKAMI = "Wybierz wybraną liczbę elementów z listy (podaj liczby oddzielone przecinkami): ";

    public MultipleChoiceQuestion(Long id, List<String> choices) {
        super(id, choices);
    }

    @Override
    public Message parseResponse(String response) {
        return null;  //TODO
    }

    @Override
    public String toString() {
        return WYBIERZ_WYBRANĄ_LICZBĘ_ELEMENTÓW_Z_LISTY_PODAJ_LICZBY_ODDZIELONE_PRZECINKAMI + listChoices();
    }
}
