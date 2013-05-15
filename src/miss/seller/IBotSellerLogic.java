package miss.seller;

import miss.model.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciej
 * Date: 15.05.13
 * Time: 21:01
 */
public interface IBotSellerLogic {
    Product findProductByName(String name, List<Product> products);

    Product findProductByValue(BigDecimal value, List<Product> products, IProductFinder productFinder);
}
