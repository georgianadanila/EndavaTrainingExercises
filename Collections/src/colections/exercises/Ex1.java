package colections.exercises;

import java.util.Set;
import java.util.TreeSet;

/**
 * Compile and run. What's the problem?
 * 
 * @author George Trandafir
 * @grad-author Georgiana Danila
 */
public class Ex1 {
	public static void main(String[] args) {
		Graduate graduate1 = new Graduate(1);
		Graduate graduate2 = new Graduate(2);
		Set<Graduate> set = new TreeSet<>();
		set.add(graduate1);
		set.add(graduate2);
		for (Graduate graduate : set) {
			System.out.println(graduate);
		}
	}
}

/*
 * Deoarece Set nu poate contine duplicate, trebuie sa compare elementele
 * atunci cand le adauga, deci are nevoie de implementarea interfetei Comparable,
 * si implicit de implementarea metodei compareTo
 */
class Graduate implements Comparable<Graduate>{
	private Integer age;

	public Graduate(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Graduate [age=" + age + "]";
	}

	@Override
	public int compareTo(Graduate grad) {
		return this.age - grad.age;
	}
}
