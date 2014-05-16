/**
 * 
 * @author Georgiana Danila
 *
 */
/*
 * clasa Factory este un singleton
 */
public class EncryptDecryptFactory {
	private static EncryptDecryptFactory INSTANCE = null;
	public enum Method {
        OddNumbers,
        EvenNumbers
    }
	
	private EncryptDecryptFactory() {
	}
	
	public static EncryptDecryptFactory getInstance(){
		
		if (INSTANCE == null) {
			INSTANCE = new EncryptDecryptFactory();
		}
		return INSTANCE;
	}
	
	public EncryptDecrypt createEncryptionDecryption(Method methodType) {
        switch (methodType) {
            case OddNumbers:
                return new EncryptDecryptOddNumbers();
            case EvenNumbers:
                return new EncryptDecryptEvenNumbers();
        }
        throw new IllegalArgumentException("The method type " + methodType + " is not recognized.");
    }



}
