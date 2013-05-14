package miss.buyer;

/**
 * Base class for buyers
 * @author adam
 *
 */
public abstract class Buyer {

	
	/**
	 * returns true if Buyer thinks that is end of negotiations
	 */
	public abstract boolean negotiationEnds();

	/**
	 * adds seller's response and changes state of Seller
	 */
	public abstract void addResponse(String response);
	
	/**
	 * returns repsonse to buyer, and prints it in human readable form
	 * @return
	 */
	public abstract String getNextText();
	
}
