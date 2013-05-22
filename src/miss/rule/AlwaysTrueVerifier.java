package miss.rule;

public class AlwaysTrueVerifier extends Verifier {
    @Override
    public boolean isConsistent(long messageId) {
        return true;
    }
}
