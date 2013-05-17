package miss.seller;

import miss.model.Product;
import miss.model.Property;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    // Source: http://stackoverflow.com/questions/1670862/obtaining-powerset-of-a-set-in-java (modified)
    public static Set<Set<Property>> powerSet(Set<Property> originalSet) {
        Set<Set<Property>> sets = new HashSet<Set<Property>>();
        if (originalSet.isEmpty()) {
            sets.add(new HashSet<Property>());
            return sets;
        }
        List<Property> list = new ArrayList<Property>(originalSet);
        Property head = list.get(0);
        Set<Property> rest = new HashSet<Property>(list.subList(1, list.size()));
        for (Set<Property> set : powerSet(rest)) {
            Set<Property> newSet = new HashSet<Property>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }
        return sets;
    }
}
