import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class Main {

	public static void main(String[] args) throws IOException{
		int allNumbersLength = 100000;
		int threadNo = 5;
		int sizeOfChunk = allNumbersLength/threadNo;
		List<Integer> allNumbers = new ArrayList<>(allNumbersLength);
		List<Integer> primeNumbers1 = new ArrayList<>();
		List<Integer> primeNumbers2 = new ArrayList<>();
		List<Integer> primeNumbers3 = new ArrayList<>();
		List<Thread> threadList = new ArrayList<>();
		Random randomObject = new Random();
		long startTime, endTime;


		//populate original list with random numbers
		for (int i=0; i<allNumbersLength; i++) {
			allNumbers.add(i);
		}

		
		//-----------one thread computes result for entire list-----------------
		startTime = System.currentTimeMillis();
		Thread singleThread = new Thread (new PrimeNumberThreadOnChunks(allNumbers,primeNumbers1,0,allNumbers.size()));
		singleThread.start();

		//wait for thread to finish
		try {
			singleThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		endTime = System.currentTimeMillis();
		System.out.println("Rezultatul in cazul rularii cu un singur thread dureaza: "+(endTime-startTime) + " milisecunde");
		//System.out.println(primeNumbers1);
		threadList.clear();

		
		//-----------multiple threads compute results for one chunk from the list each--------------
		startTime = System.currentTimeMillis();
		for (int i=0; i<threadNo; i++) {
			int start = i*sizeOfChunk;
			int end = i*sizeOfChunk+sizeOfChunk;
			//the last thread gets the remaining elements of list
			if (i==threadNo-1 && end!= allNumbersLength) {
				end = allNumbersLength;
			}
			Thread primeNumbersTread = new Thread(new PrimeNumberThreadOnChunks(allNumbers,primeNumbers2,start,end));
			threadList.add(primeNumbersTread);
			
			primeNumbersTread.start();
		}

		//wait for all threads to finish
		for (int i=0; i<threadNo; i++) {
			try {
				threadList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Rezultatul in cazul rularii cu mai multe threaduri, pe chunkuri, dureaza: "+(endTime-startTime) + " milisecunde");
		//System.out.println(primeNumbers2);
		threadList.clear();
		System.out.println(primeNumbers1.containsAll(primeNumbers2));

		
		//--------------multiple threads compute results for one element each------------------------
		for (int i=0; i<threadNo; i++) {
			Thread primeNumbersTread = new Thread(new PrimeNumberThreadOnElements(allNumbers,primeNumbers3));
			threadList.add(primeNumbersTread);
			startTime = System.currentTimeMillis();
			primeNumbersTread.start();
		}

		//wait for all threads to finish
		for (int i=0; i<threadNo; i++) {
			try {
				threadList.get(i).join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		endTime = System.currentTimeMillis();
		System.out.println("Rezultatul in cazul rularii cu mai multe threaduri, pe cate un element, dureaza: "+(endTime-startTime) + " milisecunde");
		threadList.clear();
		//System.out.println(primeNumbers3);
		System.out.println(primeNumbers3.containsAll(primeNumbers1));
	}

}
