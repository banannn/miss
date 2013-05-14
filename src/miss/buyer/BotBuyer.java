package miss.buyer;

public class BotBuyer extends Buyer {

	@Override
	public boolean negotiationEnds() {
		return false;
	}

	@Override
	public void addResponse(String response) {
	}

	@Override
	public String getNextText() {
		return null;
	}

	

}
