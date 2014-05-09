/**
 * 
 * @author Georgiana Danila
 *
 */
public class GoToDemo {
	public static void main (String[] args) {
        boolean b = true;
        first : {
            second : {
                third : {
                    System.out.println("Inside the third block");
                    if (b) {
                        break second;
                    }
                }
                System.out.println("Inside the second block");  //  nu se va executa
            }
            System.out.println("Inside the first block");
        }
    }

}
