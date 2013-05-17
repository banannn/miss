package miss.seller;

import miss.model.Product;
import miss.model.Property;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: Maciej
 * Date: 15.05.13
 * Time: 21:10
 */
public class ProductFinder implements IProductFinder, IProductWithPropertiesFinder {
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

    @Override
    public boolean isBetterWithProperties(BigDecimal value, Product bestMatch, Product product) {
        BigDecimal productValue = calculateValueWithProperties(product);

        if (productValue.compareTo(value) == 1) return false;

        BigDecimal bestMatchValue = calculateValueWithProperties(bestMatch);

        return productValue.compareTo(bestMatchValue) == 1;

    }

    public BigDecimal calculateValueWithProperties(Product bestMatch) {
        if (bestMatch == null) return BigDecimal.ZERO;
        BigDecimal bestMatchValue;
        bestMatchValue = bestMatch.getValue();
        for (Property property : bestMatch.getProperties())
            bestMatchValue = bestMatchValue.add(property.getValue());
        return bestMatchValue;
    }
}
