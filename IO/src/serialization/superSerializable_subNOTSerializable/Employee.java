package serialization.superSerializable_subNOTSerializable;

import java.io.Serializable;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class Employee implements Serializable{
	private String name;
	
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
