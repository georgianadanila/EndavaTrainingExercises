package serialization.superNOTSerializable_subSerializable;

import java.io.Serializable;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class Employee {
	private String name;
	
	public Employee() {
		
	}
	
	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
