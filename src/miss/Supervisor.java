package miss;

import miss.buyer.Buyer;
import miss.model.Product;
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
			seller.addResponse(buyer.getNextText());
			buyer.addResponse(seller.getNextText());
		}
	}
	
	
	
}
