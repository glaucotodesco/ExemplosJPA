package exemplo11;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class TesteCallBacks {

	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		
		
		Material m = new Material();
		
		EntityManager        em      = factory.createEntityManager();
		em.getTransaction().begin();
				m.setIdMaterial(2);
				m.setDescricao("Teste");
			    em.persist(m);
		em.getTransaction().commit();

		/*
		em.getTransaction().begin();
			Material m2 = em.merge(m);
			em.remove(m2);
	    em.getTransaction().commit();
*/
		
		
		em.clear();
		em.close();
		factory.close();
	    
		System.out.println("FIM");
		
	}

	
}
