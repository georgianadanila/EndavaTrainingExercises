import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Georgiana Danila
 * 
 */
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader in = null;
		BufferedReader inEncrypted = null;
		PrintWriter outEncrypted = null;
		PrintWriter outDecrypted = null;
		long startTime, endTime;
		String line;
		EncryptDecryptFactory factory = EncryptDecryptFactory.getInstance();

		try {
			outEncrypted = new PrintWriter("LargeFile-encrypted.txt");
			outDecrypted = new PrintWriter("LargeFile-decrypted.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}

		/*
		 * cripteaza un fisier folosind una din clasele create cu factory, corespunzatoare unui algoritm de criptare
		 * pentru a schimba lettermappingul la asrraylist se schimba al treilea parametru in 1
		 */
		startTime = System.currentTimeMillis();
		try {
			in = new BufferedReader(new FileReader("LargeFile.txt"));
			
			while ((line = in.readLine()) != null) {
				outEncrypted.println(factory.createEncryptionDecryption(
						EncryptDecryptFactory.Method.OddNumbers).encrypt(line,0,0));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
					outEncrypted.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/*
		 * decripteaza fisierul, tot cu o metoda din clasa creata cu factory
		 * pentru a schimba lettermappingul la asrraylist se schimba al treilea parametru in 1
		 */
		try {
			inEncrypted = new BufferedReader(new FileReader(
					"LargeFile-encrypted.txt"));
			while ((line = inEncrypted.readLine()) != null) {
				outDecrypted.println(factory.createEncryptionDecryption(
						EncryptDecryptFactory.Method.OddNumbers).decrypt(line,0,0));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				inEncrypted.close();
				outDecrypted.close();
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Timp total criptare/decriptare "+(endTime-startTime)+" milisecunde");

	}

}
