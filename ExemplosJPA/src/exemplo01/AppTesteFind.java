package exemplo01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppTesteFind {

	public static void main(String[] args) {
	
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		Livro01 l2 = em.find(Livro01.class, 4l);
		if(l2!= null)
		     System.out.println(l2.toString());
		else
			System.out.println("Não cadastrado");
            
			
	    System.out.println("FIM");
				
		em.close();
		factory.close();
		

	}

}
