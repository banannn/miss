package miss.rules;


/**
 * określa do jakiego stanu przechodzimy po otrzymaniu konkretnej wiadomości
 * @author adam
 *
 */
public class Transition {

	private Long startState;
	private Long endState;
	private Verifier verifier;
	
	public Long getStartState() {
		return startState;
	}
	public void setStartState(Long startState) {
		this.startState = startState;
	}
	public Long getEndState() {
		return endState;
	}
	public void setEndState(Long endState) {
		this.endState = endState;
	}

    public Verifier getVerifier() {
        return verifier;
    }

    public void setVerifier(Verifier verifier) {
        this.verifier = verifier;
    }
}
