package colections.homework.test;

<<<<<<< HEAD
import java.util.Iterator;
=======
>>>>>>> 169d91f943c4424531f0d7fba98e2fe63c148119
import java.util.Random;

import colections.homework.main.RandomizedQueue;

public class TestRandomizedQueue {

	public RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<>();
	Random randomObject = new Random();
	
	@Override
	public String toString() {
		return randomizedQueue.toString();
	}
	/*
	 * testeaza metoda enqueue - adaug elemente in ordine crescatoare
	 */
	public void testEnqueue() {
<<<<<<< HEAD
		int nr = 55;
=======
		int nr = 15;
>>>>>>> 169d91f943c4424531f0d7fba98e2fe63c148119
		for (int i=0; i<nr; i++) {
			randomizedQueue.enqueue(i);
		}
		System.out.println("Coada initiala are " + nr + " elemente");
	}
	
	/*
	 * testeaza metoda dequeue - elementele sunt scoase random si afisate
	 */
	public void testDequeue() {
<<<<<<< HEAD
		int nr = 20;
=======
		int nr = 10;
>>>>>>> 169d91f943c4424531f0d7fba98e2fe63c148119
		System.out.println(nr + " elemente scose din coada (in ordinea in care sunt scoase)");
		for (int i=0; i<nr; i++) {
			System.out.print(randomizedQueue.dequeue() + " ");	
		}
		System.out.println("\nAu mai ramas " + randomizedQueue.size() + " elemente.");
		System.out.println(randomizedQueue);
	}
	
	/*
<<<<<<< HEAD
	 * testeaza iteratorul
=======
	 * testeaza iteratorul - doar metodele next si hasNext 
>>>>>>> 169d91f943c4424531f0d7fba98e2fe63c148119
	 */
	public void testIterator() {
		System.out.println("Parcurgere elemente cu iterator si afisarea lor");
		for (Integer elem : randomizedQueue) {
			System.out.print(elem + " ");
		}
		System.out.println();
	}
}
