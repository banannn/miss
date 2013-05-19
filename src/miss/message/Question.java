package miss.message;

public abstract class Question extends Message {
    private final Long id;

    public Question(Long id) {
        this.id = id;
    }
}
