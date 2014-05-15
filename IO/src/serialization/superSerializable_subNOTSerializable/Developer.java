package serialization.superSerializable_subNOTSerializable;

import java.io.Serializable;

/**
 * 
 * @author Georgiana Danila
 *
 */
//cand superclasa e serializabila, automat si subclasa va fi
public class Developer extends Employee {
	private int salary;
	
	public Developer(String name, int salary) {
		super(name);
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}	
}
