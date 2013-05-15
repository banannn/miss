package miss.buyer;

import java.util.Scanner;


public class HumanBuyer extends Buyer {

	
	private  Scanner scanner;

	public HumanBuyer() {
		scanner = new Scanner(System.in);
	}
	
	@Override
	public boolean negotiationEnds() {
		return false;
	}

	@Override
	public void addResponse(String response) {
		System.out.println("buyer: got response " + response);
	}

	/**
	 * should show list of option to user and wait for input
	 * then return text
	 */
	@Override
	public String getNextText() {
		String response = scanner.nextLine();
//		System.out.println("buyer: next text " + response);
		return response;
	}

}
