import java.util.List;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class PrimeNumberThreadOnElements implements Runnable{
	private List<Integer> allNumbers;
	private List<Integer> primeNumbers;
	private static int i;

	public PrimeNumberThreadOnElements(List<Integer> allNumbers,  List<Integer> primeNumbers) {
		this.allNumbers = allNumbers;
		this.primeNumbers = primeNumbers;
		i=0;
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
		Integer number=null;
		while (true) {
			synchronized (allNumbers) {
				if (i==allNumbers.size())
					break;
				else {
					number = allNumbers.get(i);
					i++;
				}
			}
			if (isPrime(number)) {
				synchronized (primeNumbers) {
					primeNumbers.add(number);
				}
			}
			
		}
	}

}
