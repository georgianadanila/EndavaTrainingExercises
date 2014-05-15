package CircularList;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import serialization.superNOTSerializable_subSerializable.Developer;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class SerializationTest {

	public static void main(String[] args) {
		CircularList list = new CircularList();
		Random randomObject = new Random();
		ObjectOutputStream os = null;
		ObjectInputStream is = null;

		for (int i=0; i<20; i++) {
			list.add(new Node(randomObject.nextInt(100)));
		}

		System.out.println("Before serialization:\n" +list);

		//serialize the list
		try {
			os = new ObjectOutputStream(new FileOutputStream("employee.bin"));
			os.writeObject(list);
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
		
		//deserialize the list
		try {
			is = new ObjectInputStream(new FileInputStream("employee.bin"));
			CircularList deserializedList = (CircularList)is.readObject();
			System.out.println("Deserialized:\n" + deserializedList);
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
