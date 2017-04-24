package exemplo09;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppTesteFind {

	public static void main(String[] args) {
	
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		
		Socio s1 = em.find(Socio.class,1);
		
		System.out.println(s1);
		
		//Faz a chamada a coleção para recuperar os elementos do banco de dados.
		s1.getTelefones().size();
		
		System.out.println(s1);
		
		
		System.out.println("Sucesso");
				
		em.close();
		factory.close();
		

	}

}
