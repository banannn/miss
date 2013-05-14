package miss.seller;

import java.util.List;

import miss.model.Product;

public abstract class Seller {

	public List<Product> products;

	
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	/**
	 * returns true if Seller thinks that is end of negotiations
	 */
	public abstract boolean negotiationEnds();

	/**
	 * adds buyer's response and changes state of Seller
	 */
	public abstract void addResponse(String response);
	
	/**
	 * returns repsonse to buyer
	 * @return
	 */
	public abstract String getNextText();
	
}
