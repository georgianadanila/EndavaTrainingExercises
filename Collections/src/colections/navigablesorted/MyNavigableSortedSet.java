package colections.navigablesorted;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * The only way to iterate through a set is using an iterator.
 * 
 * @author gtrandafir
 * 
 */
public class MyNavigableSortedSet {
	public static void main(String[] arg) {
		NavigableSet<String> original = new TreeSet<>();
		original.add("1");
		original.add("2");
		original.add("3");
		original.add("4");
		original.add("5");

		// this subset will contain "2" and "3"
		SortedSet<String> subset = original.subSet("2", "4");
		Iterator<String> it = subset.iterator();

		while (it.hasNext()) {
			String value = (String) it.next();
			System.out.println("Value :" + value);
		}
	}
}
