package exemplo02;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;




public class AppTeste {

	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		
		Livro02 l1 = new Livro02();
		
	
		l1.setAutor("asdasd");
		l1.setValor(5);
		l1.setTitulo("Jasdawwww2ava4");
		
		try
		{
			em.getTransaction().begin();
				em.persist(l1);
			em.getTransaction().commit();
		
		}
		catch(Exception e)
		{
			System.out.println("Erro ao gravar um novo livro" +  e.getMessage());
		}
		
		
		System.out.println("FIM");
		em.close();
		factory.close();
			
			
			
				
				

	}

}
