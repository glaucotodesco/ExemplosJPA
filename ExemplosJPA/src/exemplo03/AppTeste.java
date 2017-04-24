package exemplo03;




import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class AppTeste {

	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		
		Classe c;
		
		
		c = new Classe();
		
		c.setId(1);
		c.setCurso("Computação");
		c.setSemestre("Primeiro");
		c.setPeriodo(Periodo.VESPERTINO);
		
		try
		{
			em.getTransaction().begin();
				em.persist(c);
			em.getTransaction().commit();
			System.out.println("Salvo com sucesso!");
		
		}
		catch(Exception e)
		{
			System.out.println("Erro ao gravar" +  e.getMessage());
		}
		
	    
		em.close();
		
			
		
		/********************************************************************************************/
		em      = factory.createEntityManager();
		
		
		c = em.find(Classe.class, 1);
		
		
		System.out.println(c.toString());
		
		em.close();
		factory.close();
		
		
			
				
				

	}

}
