import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Georgiana Danila
 *
 */
/*
 * are metoda de criptare si decriptare dupa o regula asociata valorii parametrului code
 * de exemplu, pentru codul 0, se asociaza fiecarei litere o valoare para, incepand de la 0
 */
public class EncryptDecryptEvenNumbers extends EncryptDecrypt{

	private Scanner scanner;

	//generates a list of LetterMappings
	public ArrayList<LetterMapping> createArrayListMapping(int code) {
		List<LetterMapping> list = new ArrayList<>();
		int mappingCode = code;
		for (int i=97; i<123; i++) {
			char letter = (char)i;
			int number = mappingCode;
			mappingCode+=2;
			list.add(new LetterMapping(letter,number));
		}
		return (ArrayList<LetterMapping>) list;
	}

	//generates a HashMap with the values of some letter mappings
	public HashMap<String,Integer> createHashMap(int code) {
		Map<String,Integer> hashMap = new HashMap<>();
		int mappingCode = code;
		for (int i=97; i<123; i++) {
			String letter = String.valueOf((char)i);
			Integer number = mappingCode;
			mappingCode+=2;
			hashMap.put(letter, number);
		}
		return (HashMap<String, Integer>) hashMap;
	}

	/*
	 * cripteaza stringul primit ca parametru, regula de criptare este data de valoarea codului
	 * intoarce stringul criptat
	 */
	@Override
	public String encrypt(String text, int code, int usedMapping) {
		char[] textArray = text.toCharArray();
		ArrayList<LetterMapping> mapping = createArrayListMapping(code);
		StringBuilder encryptedText = new StringBuilder();
		
		for (int i=0; i<text.length(); i++) {
			for (int j=0; j<mapping.size(); j++) {
				if (textArray[i] == mapping.get(j).getLetter()) {
					encryptedText.append((mapping.get(j).getNumber())+" ");
					break;
				}
			}
		}	
		return encryptedText.toString();
	}

	/* decripteaza stringul, dupa regula corespunzatoare codului
	 * intoarce stringul decriptat
	 */
	@Override
	public String decrypt(String text, int code, int usedMapping) {
		ArrayList<LetterMapping> mapping = createArrayListMapping(code);
		StringBuilder decryptedText = new StringBuilder();
		scanner = new Scanner(text);
		String token;
		
		while (scanner.hasNext()) {
			token = scanner.next();
			for (int j=0; j<mapping.size(); j++) {
				if (Integer.valueOf(token) == mapping.get(j).getNumber()) {
					decryptedText.append(mapping.get(j).getLetter());
					break;
				}
			}
		}
		return decryptedText.toString();
	}

}
