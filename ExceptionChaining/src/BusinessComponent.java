
public class BusinessComponent {

	private PersistenceComponent persistenceComponent;
	
	public void setPersistenceComponent(PersistenceComponent persistenceComponent) {
		this.persistenceComponent = persistenceComponent;
	}
	
	public void doWork(Object o) throws BusinessException {
		try {
			persistenceComponent.persist(o);
		} catch (PersistenceException ex) {
			throw new BusinessException(ex);
		}
	}
}
