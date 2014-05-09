/**
 * 
 * @author Georgiana Danila
 *
 */
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PersistenceComponent persistenceComponent = new PersistenceComponent();
		BusinessComponent businessComponent = new BusinessComponent();
		
		businessComponent.setPersistenceComponent(persistenceComponent);
		try {
			businessComponent.doWork(new Object());
		} catch (BusinessException ex) {
			Throwable cause = ex.getCause();
			if (cause instanceof PersistenceException) {
				PersistenceException pex = (PersistenceException) cause;
				System.out.println("PersistenceException caught: "+pex.getMessage());
			}
		}
	}

}
