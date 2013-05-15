package miss.seller;

import miss.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class BotSeller extends Seller {

    private final IProductFinder productFinder = new ProductFinder();
    private final IBotSellerLogic botSellerLogic = new BotSellerLogic();
    private String[] defaultResponses;
    private int nextDefaultResponse;
    private Product product = null;
    private Product productWanted = null;
    private BigDecimal value = null;
    private boolean negotiationEnds = false;

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
        if (product != null && value != null && response.equals("OK")) negotiationEnds = true;
        try {
            value = new BigDecimal(response);
        } catch (NumberFormatException e) {
            productWanted = botSellerLogic.findProductByName(response, products);
        }
        if (productWanted != null)
            product = productWanted;
        if (product != null && value != null && product.getValue().compareTo(value) == 1)
            product = null;
        if (productWanted == null && value != null)
            product = botSellerLogic.findProductByValue(value, products, productFinder);
    }

    @Override
    public String getNextText() {
//		System.out.println("muu");
        if (product == null && value == null) {
            String response = defaultResponses[nextDefaultResponse];
            nextDefaultResponse = (nextDefaultResponse + 1) % defaultResponses.length;
            return response;
        }
        if (product == null)
            return defaultResponses[0];
        if (value == null)
            return defaultResponses[1];
        return "Oferta: " + product.getName() + " za " + value.toString() + ", potwierdź: OK";
    }

}
