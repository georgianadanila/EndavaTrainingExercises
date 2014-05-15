package CircularList;

import java.io.Serializable;
import java.util.NoSuchElementException;

/**
 * 
 * @author Georgiana Danila
 *
 */
public class CircularList implements Serializable{
	private Node tail;
	private int size;
	
	public CircularList() {
		size = 0;
		tail = null;
	}
	
	//verifica daca lista este goala
	public boolean isEmpty() {
		return (size == 0);
	}
	
	//intoarce dimensiunea listei
	public int getSize() {
		return size;
	}
	
	//adauga un element in lista, la inceput
	public void add(Node node) {
		if (isEmpty()) {
			node.setNext(node);
			tail = node;
		}
		else {
			Node head = tail.getNext();
			node.setNext(head);
			tail.setNext(node);
		}
		size++;
	}
	
	//sterge un elemet din lista, de la inceput
	public int remove() {
		if (isEmpty())
			throw new NoSuchElementException();
		else {
			Node head = tail.getNext();
			int value = head.getValue();
			if (head == tail) {
				tail = null;
			}
			else {
				tail.setNext(head.getNext());
			}
			size--;
			return value;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder listStrig = new StringBuilder();
		
		if (!isEmpty()) {
			Node head = tail.getNext();
			Node node = head.getNext();
			
			listStrig.append(head.getValue() + " ");
			while (node != head) {
				listStrig.append(node.getValue() + " ");
				node = node.getNext();
			}
			return listStrig.toString();
		}
		return "";
	}
}
