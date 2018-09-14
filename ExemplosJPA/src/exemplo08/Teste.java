package exemplo08;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager        em      = factory.createEntityManager();
		
		
		
		Aluno a1 = new Aluno(1,"Ana");
		Aluno a2 = new Aluno(2,"Pedro");
		Aluno a3 = new Aluno(3,"Jose");				
		
		Curso c1 = new Curso(1,"Java");
		Curso c2 = new Curso(2,"C#");
		Curso c3 = new Curso(3,"PHP");
		
		
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		
		

		
		c1.getAlunos().add(a1);
		c1.getAlunos().add(a2);
		
		c2.getAlunos().add(a1);
		c2.getAlunos().add(a2);
		c2.getAlunos().add(a3);
		
		c3.getAlunos().add(a3);
	
		em.merge(c1);
		em.merge(c2);
		em.merge(c3);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
	
		
		em.close();
		factory.close();
		
		System.out.println("Sucesso!");
		

	}

}
