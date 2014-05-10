package colections.homework.main;

import java.util.Iterator;
import java.util.Random;

import colections.homework.test.TestRandomizedQueue;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	public Item[] randomizedQueue;
	public int numberOfElements=0;
	Random randomObject = new Random();
	int randomIndex, lastIndex;
	
	// construct an empty randomized queue
	public RandomizedQueue() {
		randomizedQueue = (Item[])new Object[10];
	}

	// is the queue empty?
	public boolean isEmpty() {
		if (numberOfElements != 0) {
			return false;
		}
		return true;
	}

	// return the number of items on the queue
	public int size() {
		return numberOfElements;
	}

	// add the item
	public void enqueue(Item item) {
		if (numberOfElements == randomizedQueue.length) {
			Item[] temporaryQueue = (Item[])new Object[randomizedQueue.length*2];
			for (int i=0; i<randomizedQueue.length; i++) {
				temporaryQueue[i] = randomizedQueue[i];
			}
			randomizedQueue = temporaryQueue;
		}
		randomizedQueue[numberOfElements] = item;
		numberOfElements++;
	}

	// delete and return a random item
	public Item dequeue() {
		randomIndex = randomObject.nextInt(numberOfElements);
		Item dequeuedItem = randomizedQueue[randomIndex];
		if (numberOfElements == randomizedQueue.length/4) {
			Item[] temporaryQueue = (Item[])new Object[randomizedQueue.length/2];
			for (int i=0; i<numberOfElements; i++) {
				temporaryQueue[i] = randomizedQueue[i];
			}
			randomizedQueue = temporaryQueue;
		}
<<<<<<< HEAD
		if (randomIndex != numberOfElements)
=======
		//if (randomIndex != numberOfElements)
>>>>>>> 169d91f943c4424531f0d7fba98e2fe63c148119
			randomizedQueue[randomIndex] = randomizedQueue[numberOfElements-1];
		numberOfElements--;
		return dequeuedItem;
	}

	// return (but do not delete) a random item
	public Item sample() {
		randomIndex = randomObject.nextInt(numberOfElements);
		return randomizedQueue[randomIndex];
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {	
		randomObject.setSeed(System.currentTimeMillis());
		
		Iterator<Item> it = new Iterator<Item>() {
			int itCounter=0;
			
			@Override
			public boolean hasNext() {
				if (itCounter < numberOfElements) {
					return true;
				}
				return false;
			}

			@Override
			public Item next() {
<<<<<<< HEAD
				randomIndex = randomObject.nextInt(numberOfElements);
				while (randomIndex == lastIndex) {
					randomIndex = randomObject.nextInt(numberOfElements);
				}
=======
				Random random = new Random();
				random.setSeed(System.currentTimeMillis() + itCounter);
				randomIndex = random.nextInt(numberOfElements);
>>>>>>> 169d91f943c4424531f0d7fba98e2fe63c148119
				lastIndex = randomIndex;
				itCounter++;
				return randomizedQueue[randomIndex];
			}

			@Override
			public void remove() {
<<<<<<< HEAD
				if (randomIndex != numberOfElements)
					randomizedQueue[randomIndex] = randomizedQueue[numberOfElements];
=======
				randomizedQueue[randomIndex] = randomizedQueue[numberOfElements];
>>>>>>> 169d91f943c4424531f0d7fba98e2fe63c148119
				numberOfElements--;
			}
		};
		return it;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i=0; i<numberOfElements; i++)
			stringBuilder.append(randomizedQueue[i] + " ");
		return stringBuilder.toString();
	}
	
	// unit testing
	public static void main(String[] args) {
		TestRandomizedQueue test = new TestRandomizedQueue();
			
		test.testEnqueue();
		test.testDequeue();
		test.toString();
		test.testIterator();
		
	}
}
