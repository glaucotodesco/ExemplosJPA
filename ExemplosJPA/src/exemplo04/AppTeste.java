package exemplo04;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import exemplo02.Livro02;



public class AppTeste {

	public static void main(String[] args) {
	
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		
		
		
		Livro02 l1 = new Livro02();
		l1.setCodigo(1);
		l1.setAutor("1");
		l1.setValor(10);
		l1.setTitulo("AAAAAAAAAAAA");
	
		Livro02 l2 = new Livro02();
		l2.setCodigo(2);
		l2.setAutor("2");
		l2.setValor(20);
		l2.setTitulo("BBBBBBBBBBBBBB");
		
		try
		{
			em.getTransaction().begin();
				em.persist(l1);
				em.persist(l2);
			em.getTransaction().commit();
		
		}
		catch(Exception e)
		{
			System.out.println("Erro ao gravar um novo livro" +  e.getMessage());
		}
		
	    
		//Consulta (mais flexivel)	
		//Acrescente a consulta na classe Livro02
		Query q = em.createQuery("Select l From Livro02 l");
		List <Livro02> list = q.getResultList();
			
		for(Livro02 l: list)
		{
		      System.out.println(l);	
		}
			
	    //Consulta pré-construida (mais eficiente)
		list = em.createNamedQuery("Livro02.findAll").getResultList();
		for(Livro02 l: list)
		{
		      System.out.println(l);	
		}
		
		
		
		
		
		
		em.close();
		factory.close();
			
			
			
				
				

	}

}
