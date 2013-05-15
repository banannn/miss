package miss.seller;

import miss.model.Product;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciej
 * Date: 15.05.13
 * Time: 21:13
 */
public class BotSellerTools {

    public static String joinNames(String delimiter, List<Product> products) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for (Product product : products) {
            if (!first) sb.append(delimiter);
            sb.append(product.getName());
            first = false;
        }
        return sb.toString();
    }

}
