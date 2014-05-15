package serialization.superNOTSerializable_subSerializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
 * 
 * @author Georgiana Danila
 *  serializarea/deserializarea nu functioneaza, deoarece obiectul Developer contine in constructorul sau
 *  un camp ce apartine unei clase ce nu a fost declarata serializabila, deci se va arunca exceptie 
 *  ca sa nu mai arunce exceptie, adaug in clasa parinte si constructorul default, pentru a initializa campul name la valoarea null
 */
public class Test {

	public static void main(String[] args){
		Employee employee = new Employee("Popescu Ion");
		Developer developer = new Developer("Ionescu Marius", 2500);
		ObjectOutputStream os = null;

		//serialize child class
		try {
			os = new ObjectOutputStream(new FileOutputStream("employee.bin"));
			os.writeObject(developer);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if (os != null)
				try {
					os.close();
				}
			catch (IOException e) {}
		}

		//deserialize child class
		ObjectInputStream is = null;
		try {
			is = new ObjectInputStream(new FileInputStream("employee.bin"));
			Developer dev = (Developer)is.readObject();
			System.out.println("Deserialized: " + "\nNume = " + dev.getName() + "\nSalariu = "+dev.getSalary());
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			if (is != null)
				try {
					is.close();
				}
			catch (IOException e) {}
		}
	}

}
