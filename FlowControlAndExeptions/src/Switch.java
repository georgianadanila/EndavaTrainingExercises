/**
 * 
 * @author Georgiana Danila
 *
 */
public class Switch {
	int i=3;
	
	public void switchExample() {
		switch(i) {
			case 0:
				System.out.println("zero");
				break;
			default:
				System.out.println("default");
				break;
			case 3:
				System.out.println("three");
			case 1:
				System.out.println("one");
		}
	}
}
