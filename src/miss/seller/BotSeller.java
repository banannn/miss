package miss.seller;

public class BotSeller extends Seller {

	@Override
	public boolean negotiationEnds() {
		return false;
	}

	@Override
	public void addResponse(String response) {
		System.out.println("got response " + response );
		// TODO
	}

	@Override
	public String getNextText() {
		System.out.println("muu");
		return "muuu ";
	}

}
