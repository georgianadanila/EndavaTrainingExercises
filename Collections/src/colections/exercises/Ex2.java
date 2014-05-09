package colections.exercises;

import java.util.HashSet;
import java.util.Set;

/**
 * Is the result correct?
 * @author gtrandafir
 * @grad-author Georgiana Danila
 *
 */
public class Ex2 {
	public static void main(String[] args) {
		Set<Circle> circleList = new HashSet<Circle>();
		circleList.add(new Circle(10, 20, 5));
		System.out.println(circleList.contains(new Circle(10, 20, 5)));
	}
}

class Circle {
	private int xPos, yPos, radius;

	public Circle(int x, int y, int r) {
		xPos = x;
		yPos = y;
		radius = r;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (radius != other.radius)
			return false;
		if (xPos != other.xPos)
			return false;
		if (yPos != other.yPos)
			return false;
		return true;
	}
	
	/*
	 * Rezultatul era gresit deoarece metoda hashCode nu era suprascrisa,
	 * astfel incat sa depinda de campurile obiectului, iar equals folosea
	 * hashCode-ul implicit, care se uita la referintele obiectelor comparate
	 * referintele vor fi intotdeauna diferite, chiar daca toate campurile
	 * au aceleasi valori
	 */
	@Override
	public int hashCode() {
		return this.radius*(this.xPos + this.yPos)%251;
	}

}