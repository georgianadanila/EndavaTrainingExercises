package colections.comparator;

import java.util.Comparator;

public class Graduate {
	private Integer age;

	private Comparator<Graduate> comparator;

	public Graduate(Integer age, Comparator<Graduate> comparator) {
		super();
		this.age = age;
		this.comparator = comparator;
	}

	public Comparator<Graduate> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<Graduate> comparator) {
		this.comparator = comparator;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Graduate(String name, Integer age) {
		this.age = age;
	}
	
	public int whoIsBigger(Graduate graduate) {
		return this.comparator.compare(this, graduate);
	}

	public static void main(String[] args) {
		Comparator<Graduate> comparator = new GraduateAgeComparator(); 
		Graduate graduate1 = new Graduate(1, comparator);
		Graduate graduate2 = new Graduate(2, comparator);
		System.out.println(graduate1.whoIsBigger(graduate2));
	}
}

class GraduateAgeComparator implements Comparator<Graduate> {

	@Override
	public int compare(Graduate o1, Graduate o2) {
		return o1.getAge() - o2.getAge();
	}

}
