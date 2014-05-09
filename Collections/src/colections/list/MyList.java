package colections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyList {
	public static void main(String[] args) {
//		List<String> listA = new ArrayList<>();
		List<String>listA = new LinkedList<>();
		listA.add("element 0");
		listA.add("element 1");
		listA.add("element 2");

		// access via index
		String element0 = listA.get(0);
		String element1 = listA.get(1);
		String element3 = listA.get(2);

		// access via Iterator
		Iterator<String> iterator = listA.iterator();
		while (iterator.hasNext()) {
			String element = iterator.next();
			System.out.println(element);
		}

		System.out.println("+++++++++++++++++++");
		// access via new for-loop
		for (String string : listA) {
			System.out.println(string);
		}
		
		
	}
}
