/**
 * 
 * @author Georgiana Danila
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IfThenElse ifObj = new IfThenElse();
		ifObj.print();
		
		System.out.println("----------");
		
		Switch switchObj = new Switch();
		switchObj.switchExample();
		
		System.out.println("----------");
		
		Exceptions exceptObj = new Exceptions();
		exceptObj.writeList();
		
		System.out.println("----------");
		
		FinallyExample finallyObj = new FinallyExample();
		System.out.println("Returned value is: "+finallyObj.method());
		System.out.println(finallyObj.method1());
		finallyObj.method2();
		
	}

}
