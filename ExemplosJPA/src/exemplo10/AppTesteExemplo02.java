package exemplo10;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;



public class AppTesteExemplo02 {

	public static void main(String[] args) {
	
		
		Client p;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em;
		
		em = factory.createEntityManager();
			em.getTransaction().begin();
				p = new Client();
				p.setId(1);
				p.setNome("Joao");
				
				Address e = new Address();
				//e.setId(1);
				e.setCidade("Sorocaba");
				e.setRua("Rua X");
		
				p.setEndereco(e);
				
				em.merge(p);
				em.getTransaction().commit();
		em.close();
	
		
		em = factory.createEntityManager();
			p = em.getReference(Client.class, 1);
		em.close();
	
	
		
		
		
		
		System.out.println("Sucesso");
				
		factory.close();
		

	}

}
