package serialization.superNOTSerializable_subSerializable;

import java.io.Serializable;

/**
 * 
 * @author Georgiana Danila
 *
 */
//cand superclasa nu e serializabila, dar subclasa este
public class Developer extends Employee implements Serializable{
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
