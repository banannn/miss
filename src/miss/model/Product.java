package miss.model;

import java.util.List;

/**
 * product which agent want to buy/sell
 * @author adam
 *
 */
public class Product {

	private Long id;
	private String name;
	private List<Property> properties;
	
	public Product(Long id, String name, List<Property> properties) {
		this.name = name;
		this.id = id;
		this.properties = properties;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Property> getProperties() {
		return properties;
	}

	public void setProperties(List<Property> properties) {
		this.properties = properties;
	} 
	
}
