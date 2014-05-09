package colections.exercises;

import java.util.Map;
import java.util.TreeMap;

/**
 * Compile and run. What's the problem?
 * 
 * @author George Trandafir
 * @grad-author Georgiana Danila
 * 
 */
public class Ex4 {
	public static void main(String[] args) {
		House house1 = new House(50);
		House house2 = new House(1);
		Square square1 = new Square(22, 22);
		Square square2 = new Square(25, 23);
		Map<Square,House> map = new TreeMap<>();
		
		map.put(square1, house1);
		map.put(square2, house2);
		System.out.println(map.containsKey(square1));
		for (Square index : map.keySet()) {
			System.out.println(map.get(index));
		}
	}
}

/*
 * Square trebuie sa implementeze Comparable, deoarece elementele adaugate intr-un TreeMap
 * trebuie sa aiba cheile comparabile; motivul este acela ca elementele se adauga in TreeMap
 * in ordinea cheilor
 */
class Square implements Comparable<Square>{
	private int xPos, yPos;

	public Square(int x, int y) {
		xPos = x;
		yPos = y;
	}

	@Override
	public int compareTo(Square o) {
		if (this.xPos - o.xPos == 0)
			return 0;
		else if (this.xPos - o.xPos < 0)
			return -1;
		return 1;
	}	

}


class House {
	private Integer age;

	public House(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "House [age=" + age + "]";
	}
}
