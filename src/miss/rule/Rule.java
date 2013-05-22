package miss.rule;

import miss.message.Message;

/**
 * określa jaka wiadomość ma być wysłana z konkretnego stanu
 * @author adam
 *
 */
public class Rule {

	private Long state;
	private Message nextMessage;
	
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	

}
