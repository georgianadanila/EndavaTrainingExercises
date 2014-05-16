
/**
 * 
 * @author Georgiana Danila
 *
 */
public class LetterMapping {
	private char letter;
	private int number;
	
	public LetterMapping() {
		
	}
	
	public LetterMapping(char letter, int number) {
		this.letter = letter;
		this.number = number;
	}
	
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	@Override
	public String toString() {
		return letter +"=" + number;
	}
	
	
}
