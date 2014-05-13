package colections.homework.main;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

import colections.homework.test.TestRandomizedQueue;

/**
 * 
 * @author Georgiana Danila
 * 
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
	private Item[] randomizedQueue;
	private int numberOfElements;
	private Random randomObject;
	private int randomIndex, lastIndex;

	// construct an empty randomized queue
	public RandomizedQueue() {
		randomizedQueue = (Item[]) new Object[10];
		randomObject = new Random();
		numberOfElements = 0;
	}

	// is the queue empty?
	public boolean isEmpty() {
		return (numberOfElements != 0);
	}

	// return the number of items on the queue
	public int size() {
		return numberOfElements;
	}

	/*
	 * in cazul in care se umple coada, se dubleaza dimensiunea ei
	 */
	public Item[] resizeOnEnqueue() {
		Item[] temporaryQueue = (Item[]) new Object[randomizedQueue.length * 2];
		for (int i = 0; i < randomizedQueue.length; i++) {
			temporaryQueue[i] = randomizedQueue[i];
		}
		return temporaryQueue;
	}
	
	// add the item
	public void enqueue(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		if (numberOfElements == randomizedQueue.length) {
			randomizedQueue = resizeOnEnqueue();
		}
		randomizedQueue[numberOfElements] = item;
		numberOfElements++;
	}

	/*
	 * in cazul in care numarul de elemente din coada ajunge la un sfert din dimensiunea ei
	 * se face resize (dimensiunea se injumatateste)
	 */
	public Item[] resizeOnDequeue() {
		Item[] temporaryQueue = (Item[]) new Object[randomizedQueue.length / 2];
		for (int i = 0; i < numberOfElements; i++) {
			temporaryQueue[i] = randomizedQueue[i];
		}
		return temporaryQueue;
	}
	
	// delete and return a random item
	public Item dequeue() {
		if (numberOfElements == 0) {
			throw new NoSuchElementException();
		}
		randomIndex = randomObject.nextInt(numberOfElements);
		Item dequeuedItem = randomizedQueue[randomIndex];
		if (numberOfElements == randomizedQueue.length / 4) {
			randomizedQueue = resizeOnDequeue();
		}
		// nu stergi elementul random din vector =>
		// ultimul element trebuie sa fie ...
		randomizedQueue[randomIndex] = randomizedQueue[numberOfElements - 1];
		numberOfElements--;
		return dequeuedItem;
	}

	// return (but do not delete) a random item
	public Item sample() {
		if (numberOfElements == 0) {
			throw new NoSuchElementException();
		}
		randomIndex = randomObject.nextInt(numberOfElements);
		return randomizedQueue[randomIndex];
	}

	// return an independent iterator over items in random order
	public Iterator<Item> iterator() {
		randomIndex = randomObject.nextInt(numberOfElements);
		
		Iterator<Item> it = new Iterator<Item>() {
			int itCounter = 0;
			
			@Override
			public boolean hasNext() {
				return itCounter < numberOfElements;
			}
			

			@Override
			public Item next() {
				if (randomIndex == numberOfElements-1) {
					randomIndex=0;
				}
				else {
					randomIndex++;
				}
				lastIndex = randomIndex;
				itCounter++;
				return randomizedQueue[randomIndex];
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		return it;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < numberOfElements; i++)
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
