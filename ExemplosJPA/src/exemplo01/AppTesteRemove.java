package exemplo01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppTesteRemove {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager em = factory.createEntityManager();

		//Livro01 l1 = em.find(Livro01.class, 4l);
		
		//Entidade nao gerenciada (Erro)
		Livro01 l1 = new Livro01();
		l1.setCodigo(88l);

		if (l1 != null) {
			em.remove(l1);
			System.out.println("Sucesso");
		} else {
			System.out.println("N�o cadastrado");
		}

		em.getTransaction().begin();
		em.getTransaction().commit();

		System.out.println("Fim");

		em.close();
		factory.close();

	}

}
