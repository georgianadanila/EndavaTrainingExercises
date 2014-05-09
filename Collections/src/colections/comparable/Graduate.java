package colections.comparable;

public class Graduate implements Comparable<Graduate> {
	private Integer age;

	public Graduate(Integer age) {
		this.age = age;
	}

	@Override
	public int compareTo(Graduate o) {
		return this.age - o.age;
	}

	public static void main(String[] args) {
		Graduate graduate1 = new Graduate(1);
		Graduate graduate2 = new Graduate(2);
		System.out.println(graduate1.compareTo(graduate2));
	}
}
