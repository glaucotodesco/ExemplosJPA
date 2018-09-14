package exemplo01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppTestePersist {

	public static void main(String[] args) {
	
		
		
		EntityManagerFactory factory =
	    Persistence.createEntityManagerFactory("PU_Exemplos");
		
		EntityManager        em 
		= factory.createEntityManager();
		
		
		Livro01 l1 = new Livro01();
		l1.setAutor("Maria");
		l1.setCodigo(7);
		l1.setValor(444);
		l1.setTitulo("AAAAAAAAAAA");
		
		
		em.persist(l1);
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		System.out.println("Sucesso");
				
		em.close();
		factory.close();
		

	}

}
