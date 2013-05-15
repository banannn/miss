package miss.test;

import miss.model.Product;
import miss.model.Property;
import miss.seller.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Maciej
 * Date: 15.05.13
 * Time: 21:03
 */
public class BotSellerTest {

    private IBotSellerLogic botSellerLogic = new BotSellerLogic();
    private IProductFinder productFinder = new ProductFinder();

    private Product a = new Product(1l, "A", new BigDecimal("100"), new ArrayList<Property>());
    private Product b = new Product(2l, "B", new BigDecimal("200"), new ArrayList<Property>());

    @DataProvider
    public Object[][] testJoinNamesDataProvider() {
        String delimiter = ", ";
        return new Object[][]{
                {delimiter, Arrays.asList(a), "A"},
                {delimiter, Arrays.asList(a, b), "A, B"},
        };
    }

    @Test(dataProvider = "testJoinNamesDataProvider")
    public void testJoinNames(String delimiter, List<Product> products, String expected) {
        String result = BotSellerTools.joinNames(delimiter, products);
        Assert.assertEquals(result, expected);
    }

    @DataProvider
    public Object[][] testFindProductByNameDataProvider() {
        return new Object[][]{
                {"A", Arrays.asList(a, b), a},
                {"B", Arrays.asList(a, b), b},
                {"C", Arrays.asList(a, b), null},
        };
    }

    @Test(dataProvider = "testFindProductByNameDataProvider")
    public void testFindProductByName(String name, List<Product> products, Product expected) {
        Product result = botSellerLogic.findProductByName(name, products);
        Assert.assertEquals(result, expected);
    }

    @DataProvider
    public Object[][] testFindProductByValueDataProvider() {
        return new Object[][]{
                {new BigDecimal("250"), Arrays.asList(a, b), b},
                {new BigDecimal("250"), Arrays.asList(b, a), b},
                {new BigDecimal("200"), Arrays.asList(a, b), b},
                {new BigDecimal("200"), Arrays.asList(b, a), b},
                {new BigDecimal("150"), Arrays.asList(a, b), a},
                {new BigDecimal("150"), Arrays.asList(b, a), a},
                {new BigDecimal("100"), Arrays.asList(a, b), a},
                {new BigDecimal("100"), Arrays.asList(b, a), a},
                {new BigDecimal("50"), Arrays.asList(a, b), null},
                {new BigDecimal("50"), Arrays.asList(b, a), null},
        };
    }

    @Test(dataProvider = "testFindProductByValueDataProvider")
    public void testIntegrationFindProductByValue(BigDecimal value, List<Product> products, Product expected) {
        Product result = botSellerLogic.findProductByValue(value, products, new ProductFinder());
        Assert.assertEquals(result, expected);
    }

    @DataProvider
    public Object[][] testProductFinderDataProvider() {
        return new Object[][]{
                {new BigDecimal("250"), null, b, true},
                {new BigDecimal("250"), a, b, true},
                {new BigDecimal("250"), b, a, false},
                {new BigDecimal("200"), null, b, true},
                {new BigDecimal("200"), a, b, true},
                {new BigDecimal("200"), b, a, false},
                {new BigDecimal("150"), null, b, false},
                {new BigDecimal("150"), a, b, false},
                {new BigDecimal("100"), null, b, false},
                {new BigDecimal("100"), a, b, false},
                {new BigDecimal("50"), null, b, false},
                {new BigDecimal("50"), a, b, false},
                {new BigDecimal("50"), b, a, false},
        };
    }

    @Test(dataProvider = "testProductFinderDataProvider")
    public void testProductFinder(BigDecimal value, Product bestMatch, Product product, boolean expected) {
        boolean result = productFinder.isBetter(value, bestMatch, product);
        Assert.assertEquals(result, expected);
    }
}
