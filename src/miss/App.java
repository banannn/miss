package miss;

import miss.buyer.Buyer;
import miss.buyer.HumanBuyer;
import miss.model.Product;
import miss.model.Property;
import miss.seller.BotSeller;
import miss.seller.Seller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
		pps.add(new Property(1l, "alufele", new BigDecimal("123.")));
		pps.add(new Property(2l, "muryn w bagazniku", new BigDecimal("111.")));
		Product pr = new Product(1l, "BMW", new BigDecimal("5000"), pps);
		
		List<Property> pps2 = new ArrayList<Property>();
		pps2.add(new Property(3l, "asd", new BigDecimal("123.")));
		pps2.add(new Property(4l, "qwe", new BigDecimal("111.")));
		Product pr2 = new Product(2l, "FIAT", new BigDecimal("2000"), pps2);
	
		List<Product> pds = new ArrayList<Product>();
		pds.add(pr);
		pds.add(pr2);
		
		Seller seller = new BotSeller();
		seller.setProducts(pds);
		
		return seller;
	}

}
