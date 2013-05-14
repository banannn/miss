package miss;

import java.util.ArrayList;
import java.util.List;

import miss.buyer.Buyer;
import miss.buyer.HumanBuyer;
import miss.model.Product;
import miss.model.Property;
import miss.seller.BotSeller;
import miss.seller.Seller;

public class App {

	public static void main(String[] args) {
		
		Supervisor supervisor = new Supervisor(getBuyer(), getSeller());
		supervisor.startNegotiations();

	}
	
	private static Buyer getBuyer() {
		return new HumanBuyer();
	}
	// mock 
	private static Seller getSeller() {

		List<Property> pps = new ArrayList<Property>();
		pps.add(new Property(1l, "alufele", 123.));
		pps.add(new Property(2l, "muryn w bagazniku", 111.));
		Product pr = new Product(1l, "BMW", pps);
		
		List<Property> pps2 = new ArrayList<Property>();
		pps2.add(new Property(3l, "asd", 123.));
		pps2.add(new Property(4l, "qwe", 111.));
		Product pr2 = new Product(2l, "FIAT", pps2);
	
		List<Product> pds = new ArrayList<>();
		pds.add(pr);
		pds.add(pr2);
		
		Seller seller = new BotSeller();
		seller.setProducts(pds);
		
		return seller;
	}

}
