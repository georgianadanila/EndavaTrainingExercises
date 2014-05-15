package serialization.superSerializable_PREVENTsubSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * @author Georgiana Danila
 *
 */
//superclasa e serializabila
public class Employee implements Serializable{
	private String name;
	ObjectOutputStream os = null;
	ObjectInputStream is = null;
	
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
