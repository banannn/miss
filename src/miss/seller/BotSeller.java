package miss.seller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import miss.model.Product;
import miss.model.Property;

public class BotSeller extends Seller {

	// modes
	private static final int SELECT_PRODUCT = 1;
	private static final int SELECT_PROPERTIES = 2;
	private static final int NEGOTIATE_PRICE = 3;
	private static final int OFFER_FROM_PRICE = 3;
	
	private boolean startOffer = true;
	private List<Double> negotiationHistory;
	
    private final IProductFinder productFinder = new ProductFinder();
    private final IBotSellerLogic botSellerLogic = new BotSellerLogic();
    private String[] defaultResponses;
    private int nextDefaultResponse;
    private Set<Integer> properties = null;
    private Product product = null;
    private Product productWanted = null;
    private BigDecimal value = null;
    private boolean negotiationEnds = false;
    private int mode = SELECT_PRODUCT;
    
    @Override
    public void setProducts(List<Product> products) {
        super.setProducts(products);
        defaultResponses = new String[]{
                "Wybierz z listy: " + BotSellerTools.joinNames(", ", products),
                "Podaj swoją maksymalną cenę",
        };
        nextDefaultResponse = 0;
    }

    @Override
    public boolean negotiationEnds() {
        return negotiationEnds;
    }

    @Override
    public void addResponse(String response) {
//		System.out.println("got response " + response );
    	response = response.trim().toUpperCase();
    	if (response.equals("end")) {
    		negotiationEnds = true;
    		return;
    	}
    		
    	if (mode == SELECT_PRODUCT) {
    		product = botSellerLogic.findProductByName(response, products);
    		mode = SELECT_PROPERTIES;
    	}
    	else if (mode == SELECT_PROPERTIES) {
    		try {
    			int id = Integer.valueOf(response);
    			if (id != -1) {
    				if (properties == null)
    					properties=  new HashSet<Integer>();
    				properties.add(id);
    				if (properties.size() == product.getProperties().size()) {
    					mode = NEGOTIATE_PRICE;
    					startOffer = true;
    					negotiationHistory = new ArrayList<Double>();
    				}
    			} else {
    				mode = NEGOTIATE_PRICE;
    				startOffer = true;
    				negotiationHistory = new ArrayList<Double>();
    			}
    		} catch (NumberFormatException e) {
    			System.out.println("nie rozumiem..");
    		}
    	}
    	else if (mode == NEGOTIATE_PRICE) {
    		try {
    			Double price = Double.valueOf(response);
				negotiationHistory.add(price);
    		} catch (NumberFormatException e) {
    			System.out.println("nie rozumiem..");
    		}
    	}
    	
//        response = response.trim().toUpperCase();
//        if (product != null && value != null && response.equals("OK")) negotiationEnds = true;
//        
//        try {
//            value = new BigDecimal(response);
//        } catch (NumberFormatException e) {
//            productWanted = botSellerLogic.findProductByName(response, products);
//        }
//        if (productWanted != null)
//            product = productWanted;
//        if (product != null && value != null && product.getValue().compareTo(value) == 1)
//            product = null;
//        if (productWanted == null && value != null)
//            product = botSellerLogic.findProductByValue(value, products, productFinder);
    }

    @Override
    public String getNextText() {
    	String response = null;
    	if (mode == SELECT_PRODUCT) {
    		response = defaultResponses[0];
    	} else if (mode == SELECT_PROPERTIES) {
    		response = getPropertyAnswer();
    	}
    	else if (mode == NEGOTIATE_PRICE) {
    		response = getNegotiateAnswer();
    	}
//		System.out.println("muu");
//        if (product == null && value == null) {
//            String response = defaultResponses[nextDefaultResponse];
//            nextDefaultResponse = (nextDefaultResponse + 1) % defaultResponses.length;
//            return response;
//        }
//        if (product == null)
//            return defaultResponses[0];
//        
//        if (mode == SELECT_PROPERTIES)
//        	return getPropertyAnswer();
//        
//        if (value == null)
//            return defaultResponses[1];
//        return "Oferta: " + product.getName() + " za " + value.toString() + ", potwierdź: OK";
    	
    	return response;
    }

    
    private String getPropertyAnswer() {
    	StringBuilder resp = new StringBuilder("Jakie dodatki chcesz? ");
    	int i =0;
    	for (Property p : product.getProperties()) {
    		resp.append(i++ + ". " + p.getName() + " " );
    	}
    	return resp.toString();
    }
    
    private String getNegotiateAnswer() {
    	Double price = product.getValue().doubleValue();
    	if (properties != null)
    	for (Integer i : properties) {
    		price += product.getProperties().get(i).getValue().doubleValue();
    	}
    	
    	if (negotiationHistory.isEmpty()) {
    		// first offer
    		negotiationHistory.add(price*1.3);
    		return "Proponuje cene: " + price*1.3;
    	} else {
    		Double newPrice = analyzeHistory();
    		if (newPrice == null || newPrice < 0.9*price) {
    			// offer new sth
    		} else {
    			return "Proponuje cene: " + newPrice;
    		}
    	}
    	negotiationEnds = true;
    	return "nie dogadamy sie..";
    		
    	
//    	StringBuilder resp = new StringBuilder("Jakie dodatki chcesz? ");
//    	int i =0;
//    	for (Property p : product.getProperties()) {
//    		resp.append(i++ + ". " + p.getName() + " " );
//    	}
//    	return resp.toString();
    }
    
    private Double analyzeHistory() {
    	if (negotiationHistory.size() <= 2)
    		return negotiationHistory.get(0) * 0.95;
    	return negotiationHistory.get(negotiationHistory.size()-2) * 0.95;
    }
}
