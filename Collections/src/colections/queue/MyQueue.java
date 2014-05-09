package colections.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MyQueue {
	public static void main(String[] args){
		Queue<String> queueA = new LinkedList<>();

		queueA.add("element 0");
		queueA.add("element 1");
		queueA.add("element 2");

		//access via Iterator
		Iterator<String> iterator = queueA.iterator();
		while(iterator.hasNext()){
		  String element =  iterator.next();
		  System.out.println(element);
		}
		System.out.println("++++++++++++++++++++++++");
		//access via new for-loop
		for(String element : queueA) {
			System.out.println(element);
		}
	}
}
