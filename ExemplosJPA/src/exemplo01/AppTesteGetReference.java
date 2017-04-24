package exemplo01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;


public class AppTesteGetReference {

	public static void main(String[] args) {
	
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		
				
		Livro01 l3=null;
		
		try
		{
					l3 = em.getReference(Livro01.class, 2l);
					System.out.println(l3.toString());
		}
		catch(EntityNotFoundException e)
		{
					System.out.println("Não cadastrado");
		}
		
		
		
		
				
		  
		
		System.out.println("Fim");
				
		em.close();
		factory.close();
		

	}

}
