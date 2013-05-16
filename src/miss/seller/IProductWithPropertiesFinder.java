package miss.seller;

import miss.model.Product;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: M
 * Date: 16.05.13
 * Time: 14:46
 */
public interface IProductWithPropertiesFinder {
    boolean isBetterWithProperties(BigDecimal value, Product bestMatch, Product product);
}
