import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * 
 * @author Georgiana Danila
 *
 */
/*
 * cripteaza si decripteaza dupa o alta metoda
 * aceleasi metode ca si in clasa EncryptDecryptEvenNumbers
 */
public class EncryptDecryptOddNumbers extends EncryptDecrypt{

	//generates a list of LetterMappings
	public ArrayList<LetterMapping> createArrayListMapping(int code) {
		List<LetterMapping> list = new ArrayList<>();
		int mappingCode = code;
		for (int i=97; i<123; i++) {
			char letter = (char)i;
			int number = mappingCode;
			mappingCode+=code*2+1;
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

	@Override
	public String encrypt(String text, int code, int usedMapping) {
		char[] textArray = text.toCharArray();
		ArrayList<LetterMapping> arrayMapping = createArrayListMapping(code);
		HashMap<String, Integer> hashMapMapping = createHashMap(code);
		StringBuilder encryptedText = new StringBuilder();
		
		if (usedMapping == 1) {
			for (int i=0; i<text.length(); i++) {
				for (int j=0; j<arrayMapping.size(); j++) {
					if (textArray[i] == arrayMapping.get(j).getLetter()) {
						encryptedText.append((arrayMapping.get(j).getNumber())+" ");
						break;
					}
				}
			}	
		}
		if (usedMapping == 0) {
			for (int i=0; i<text.length(); i++) {
				encryptedText.append(hashMapMapping.get(String.valueOf(textArray[i]))+ " ");
			}
		}
		return encryptedText.toString();
	}

	@Override
	public String decrypt(String text, int code, int usedMapping) {
		ArrayList<LetterMapping> mapping = createArrayListMapping(code);
		HashMap<String, Integer> hashMapMapping = createHashMap(code);
		StringBuilder decryptedText = new StringBuilder();
		Scanner scanner = new Scanner(text);
		String token;
		
		if (usedMapping == 1) {
			while (scanner.hasNext()) {
				token = scanner.next();
				for (int j=0; j<mapping.size(); j++) {
					if (Integer.valueOf(token) == mapping.get(j).getNumber()) {
						decryptedText.append(mapping.get(j).getLetter());
						break;
					}
				}
			}
		}
		if (usedMapping == 0) {
			while (scanner.hasNext()) {
				token = scanner.next();
				for (Entry<String, Integer> entry : hashMapMapping.entrySet()) {
					if (entry.getValue() == Integer.valueOf(token))
						decryptedText.append(entry.getKey());
				}	
			}
		}
		return decryptedText.toString();
	}
}
