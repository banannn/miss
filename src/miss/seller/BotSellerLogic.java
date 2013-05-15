package miss.seller;

import miss.model.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciej
 * Date: 15.05.13
 * Time: 20:59
 */
public class BotSellerLogic implements IBotSellerLogic {

    @Override
    public Product findProductByName(String name, List<Product> products) {
        for (Product product : products)
            if (name.equals(product.getName()))
                return product;
        return null;
    }

    @Override
    public Product findProductByValue(BigDecimal value, List<Product> products, IProductFinder productFinder) {
        Product bestMatch = null;
        for (Product product : products)
            if (productFinder.isBetter(value, bestMatch, product))
                bestMatch = product;
        return bestMatch;
    }

}
