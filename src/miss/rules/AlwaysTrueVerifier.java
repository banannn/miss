package miss.rules;

import miss.message.Message;

public class AlwaysTrueVerifier extends Verifier {
    @Override
    public boolean isConsistent(Message message) {
        return true;
    }
}
