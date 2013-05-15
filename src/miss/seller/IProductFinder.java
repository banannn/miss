package miss.seller;

import miss.model.Product;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Maciej
 * Date: 15.05.13
 * Time: 21:08
 */
public interface IProductFinder {
    boolean isBetter(BigDecimal value, Product bestMatch, Product product);
}
