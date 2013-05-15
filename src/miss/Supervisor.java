package miss;

import miss.buyer.Buyer;
import miss.seller.Seller;


public class Supervisor {

	private Buyer buyer;
	private Seller seller;
	
	
	public Supervisor(Buyer buyer, Seller seller) {
		this.buyer = buyer;
		this.seller = seller;
	}
	
	
	public void startNegotiations() {
		while(!buyer.negotiationEnds() && !seller.negotiationEnds() ) {
            buyer.addResponse(seller.getNextText());
			seller.addResponse(buyer.getNextText());
		}
	}
	
	
	
}
