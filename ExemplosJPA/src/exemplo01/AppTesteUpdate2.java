package exemplo01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class AppTesteUpdate2 {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager em = factory.createEntityManager();

		Livro01 l1 = new Livro01();
		l1.setCodigo(7);
		l1.setAutor("BlaBlaBla");
		l1.setValor(10);
		l1.setTitulo("QQQQ");

		//Save or Update
		l1 = em.merge(l1);
		
		em.remove(l1);
		
		em.getTransaction().begin();
		em.getTransaction().commit();

		System.out.println("Sucesso");

		em.close();
		factory.close();

	}

}
