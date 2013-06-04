package miss.message;

public class Breakdown extends Answer {
    private String text;

    @Override
    public boolean isFinal() {
        return true;
    }

    @Override
    public String toString() {
        return text;
    }
}
