package colections.exercises;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Lets make our own iterable collection. We want to be able to write a
 * "foreach" on our collection. Solution?
 * 
 * @author George Trandafir
 * @grad-author Georgiana Danila
 * 
 */
public class Ex3 {
	public static void main(String[] args) {
		Town<String> myTown = new Town<>();
		for (Town town : myTown) {
			System.out.println(town);
		}
	}
}

/*
 * Primeam eroare la compilare, deoarece constructia for-each are in spate un iterator
 * pentru a folosi constructia, trebuie ca obiectul prin care iterez sa implementeze
 * interfata Iterable
 */
class Town<T> implements Iterable<Town>{
	private T type;
	List<T> townList = new ArrayList<T>();
	
	@Override
	public Iterator iterator() {
		return townList.iterator();
	}
}