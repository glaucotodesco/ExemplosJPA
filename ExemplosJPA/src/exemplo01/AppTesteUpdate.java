package exemplo01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppTesteUpdate {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager em = factory.createEntityManager();

		Livro01 l1 = em.find(Livro01.class, 7l);

		if (l1 != null) {
			l1.setAutor("XXXXXXXXXXXXXXXX");
			System.out.println("Sucesso");

			l1 = em.find(Livro01.class, 7l);
			System.out.println(l1);
		} else {
			System.out.println("Não cadastrado");
		}

		em.getTransaction().begin();
		em.getTransaction().commit();

		System.out.println("Sucesso");

		em.close();
		factory.close();

	}

}
