/**
 * 
 * @author Georgiana Danila
 *
 */

/*
 * clasa abstracta extinsa de EncryptDecryptEvenNumber si EncryptDecryptOddNumber, cu metode de criptare specifice
 * UsedMapping=1 pentru mapare cu ArrayList, UsedMapping=0 pentru mapare cu HashMap
 */
public abstract class EncryptDecrypt {
	public abstract String encrypt(String text, int code, int usedMapping);
	public abstract String decrypt(String text, int code, int usedMapping);
}
