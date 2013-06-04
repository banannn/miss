package miss.rules;

import miss.message.Message;

public class AndVerifier extends Verifier {
    private Verifier[] verifiers;

    @Override
    public boolean isConsistent(Message message) {
        for (Verifier verifier : verifiers)
            if (!verifier.isConsistent(message))
                return false;
        return true;
    }
}
