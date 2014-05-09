package colections.dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class MyDeque {
	public static void main(String[] args){
		Deque<String> deque = new ArrayDeque<>();
		deque.add("first string");
		deque.add("second string");
		deque.add("third string");
		Iterator<String> it = deque.iterator();
		while(it.hasNext()) {
			String value = it.next();
			System.out.println(value);
		}
				
		for (String string : deque) {
			System.out.println(string);
		}
	}
}
