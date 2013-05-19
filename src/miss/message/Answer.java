package miss.message;

public abstract class Answer extends Message {

    protected Answer() {}

    public Answer(Long id) {
        super(id);
    }

    @Override
    public Message parseResponse(String response) {
        return null;  // TODO
    }

}
