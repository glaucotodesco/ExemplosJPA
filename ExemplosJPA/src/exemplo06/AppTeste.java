package exemplo06;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppTeste {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("PU_Exemplos");
		EntityManager em = factory.createEntityManager();

		em.getTransaction().begin();
		
		Governador g = new Governador();
		g.setId(1);
		g.setNome("João");
		g.setPartido("PPP");

		Estado e = new Estado();
		e.setId(1);
		e.setGovernador(g);
		e.setNome("São Paulo");

		em.persist(e);
		em.persist(g);
		
		em.getTransaction().commit();
		em.close();

		
		System.out.println("Sucesso");
		
	

	}

}
