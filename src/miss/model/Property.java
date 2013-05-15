package miss.model;


import java.math.BigDecimal;

public class Property {

	private Long id;
	private String name;
	private BigDecimal value;
	
	public Property(Long id, String name, BigDecimal value) {
		this.name = name;
		this.id = id;
		this.value = value;
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

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}
	
}
