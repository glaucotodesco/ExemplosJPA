package exemplo07;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppTeste {

	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		

		Fornecedor f = new Fornecedor();
		f.setId(1991);
		f.setNome("Venda do Zé");
		
		
		Produto p1 = new Produto();
		p1.setId(21);
		p1.setDescricao("Bala");
		p1.setValor(10);
		p1.setFornecedor(f);
		
		Produto p2 = new Produto();
		p2.setId(52);
		p2.setDescricao("Bolacha");
		p2.setValor(20.4);
		p2.setFornecedor(f);
		
		
		f.addProduto(p1);
		f.addProduto(p2);
		
		
		em.persist(f);
		em.persist(p1);
		em.persist(p2);
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		
		System.out.println("Sucesso");
		
	}

}
