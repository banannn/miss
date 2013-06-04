package miss.rules;

import miss.message.ChoiceAnswer;
import miss.message.Message;

public class ContainsVerifier extends Verifier {
    private String item;

    @Override
    public boolean isConsistent(Message message) {
        return ((ChoiceAnswer)message).contains(item);
    }
}
