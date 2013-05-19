package miss.message;

public abstract class Message {
    public abstract Message parseResponse(String response);
}
