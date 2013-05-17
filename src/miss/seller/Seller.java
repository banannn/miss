package miss.seller;

import miss.model.Product;
import miss.participant.Participant;

import java.util.List;

public abstract class Seller implements Participant {

	public List<Product> products;


	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

}
