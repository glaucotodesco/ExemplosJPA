package exemplo05;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppTeste {

	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		
		//************* Executar e ver as estruturas das tabelas ******************/
		
		Cliente c = new Cliente();
		c.setCodigo(1);
		c.setNome("Joao");
		c.setSaldo(10);
		
		Funcionario f = new Funcionario();
		f.setCodigo(2);
		f.setNome("Pedro");
		f.setSalario(100.3);
		
		Pessoa p = new Pessoa();
		p.setCodigo(3);
		p.setNome("Ana");
		
		em.getTransaction().begin();
			em.persist(c);
			em.persist(f);
			em.persist(p);
		em.getTransaction().commit();
		
		em.close();
		
	}

}
