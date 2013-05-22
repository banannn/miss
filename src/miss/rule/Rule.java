package miss.rule;

/**
 * określa jaka wiadomość ma być wysłana z konkretnego stanu
 * @author adam
 *
 */
public class Rule {

	private Long state;
	private long nextMessage;
	
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}


    public long getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(long nextMessage) {
        this.nextMessage = nextMessage;
    }
}
