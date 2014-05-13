import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class PrimeNumberThreadOnChunks implements Runnable{
	private List<Integer> allNumbers;
	private List<Integer> primeNumbers;
	private int start;
	private int end;
	
	public PrimeNumberThreadOnChunks(List<Integer> allNumbers,  List<Integer> primeNumbers, int start, int end) {
		this.allNumbers = allNumbers;
		this.primeNumbers = primeNumbers;
		this.start = start;
		this.end = end;
	}

	//checks if a number is prime
	public boolean isPrime(Integer number) {
		if (number <= 1) {
			return false;
		}
		if (number > 2 && number%2==0) {
			return false;
		}
		for (int i=2; i*i<=number; i++) {
			if (number%i == 0) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public void run() {
		for (int i=start; i<end; i++) {
			Integer number = allNumbers.get(i);
			if (isPrime(number)) {
				synchronized(primeNumbers){
					primeNumbers.add(number);
				}
			}

		}
	}
}
