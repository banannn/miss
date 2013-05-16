package miss.seller;

import miss.model.Product;
import miss.model.Property;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public Product findProductWithPropertiesByValue(BigDecimal value, List<Product> products, IProductWithPropertiesFinder productFinder) {
        Product bestMatch = null;
        for (Product product : products)
            for (Set<Property> properties : BotSellerTools.powerSet(new HashSet<Property>(product.getProperties()))) {
                Product candidate = new Product(product.getId(), product.getName(), product.getValue(), new ArrayList<Property>(properties));
                if (productFinder.isBetterWithProperties(value, bestMatch, candidate))
                    bestMatch = candidate;
            }
        return bestMatch;
    }

}
