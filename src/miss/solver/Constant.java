package miss.solver;

/**
 * określa jaka wiadomość ma być wysłana z konkretnego stanu
 * @author adam
 *
 */
public class Constant extends Solver {

	private long nextMessage;


    public long getNextMessage() {
        return nextMessage;
    }

    public void setNextMessage(long nextMessage) {
        this.nextMessage = nextMessage;
    }
}
