package serpis.ad;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContainerEntitityManager {
	
	protected static EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("serpis.ad.bbddpedidos");
	public static void close() {
		entityManagerFactory.close();
	}
}
