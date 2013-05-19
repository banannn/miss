package miss.participant;

import miss.message.DecimalQuestion;
import miss.message.Question;
import miss.message.MultipleChoiceQuestion;
import miss.message.SingleChoiceQuestion;

import java.util.Arrays;

public class ParticipantFactory {
    public static Participant createBot() {

        long id = 0l;

        return new Bot(
                new Question[]{
                        new SingleChoiceQuestion(++id, Arrays.asList("BMW", "FIAT")),
                        new MultipleChoiceQuestion(++id, Arrays.asList("alufele", "muryn w bagazniku")),
                        new MultipleChoiceQuestion(++id, Arrays.asList("asd", "qwe")),
                        new DecimalQuestion(++id, "Jaka jest Twoja maksymalna cena?"),
                }
        );

    }

    public static Participant createHuman() {
        return new Human();
    }
}
