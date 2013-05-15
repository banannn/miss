package miss.seller;

import miss.model.Product;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Maciej
 * Date: 15.05.13
 * Time: 21:10
 */
public class ProductFinder implements IProductFinder {
    @Override
    public boolean isBetter(BigDecimal value, Product bestMatch, Product product) {
        return value.compareTo(product.getValue()) >= 0
                &&
                (
                        bestMatch == null
                                ||
                                bestMatch.getValue().compareTo(product.getValue()) <= 0
                );
    }
}
