package exemplo02;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class AppTeste02 {

	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		
		Cidade c;
		
		
		c = new Cidade();
		
		c.setId(1);
		c.setNome("Sorocaba");
		c.setEstado("São Paulo");
		c.setPopulacao(1000);
		
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
		
		
		c = em.find(Cidade.class, 1);
		
		
		System.out.println(c.toString());
		
		em.close();
		factory.close();
		
		
			
				
				

	}

}
