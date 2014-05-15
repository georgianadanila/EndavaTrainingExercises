package serialization.superSerializable_PREVENTsubSerializable;

import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author Georgiana Danila
 * superclasa e serializabila, si, prin mostenire, si subclasa este
 * pentru a preveni ca subclasa sa fie serializabila, trebuie sa suprascriu metoda writeObject arunc o exceptie in ea 
 */

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

	private void writeObject(ObjectOutputStream os) throws NotSerializableException {
		throw new NotSerializableException();
	}
}
