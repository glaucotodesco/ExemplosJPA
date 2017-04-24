package exemplo09;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

public class AppTestePersist {

	public static void main(String[] args) {
	
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		
		Socio s1 = new Socio();
		s1.setIdSocio(1);
		s1.setNome("Joao");
		s1.addTelefone("15 99392349");
		s1.addTelefone("15 33123123");
		s1.addTelefone("18 54324544");
		
		
		em.persist(s1);
		
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		 System.out.println("Sucesso");
				
		em.close();
		
        em      = factory.createEntityManager();
		
		
	    s1 = em.find(Socio.class,1);
		
		System.out.println(s1);
		
		//Faz a chamada a coleção para recuperar os elementos do banco de dados.
		s1.getTelefones().size();
		
		System.out.println(s1);
		
		
		System.out.println("Sucesso");
				
		em.close();
		
		
		factory.close();
		

	}

}
