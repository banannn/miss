package miss.rule;

import miss.message.Message;

public abstract class Verifier {

    abstract boolean isConsistent(Message message);

}
