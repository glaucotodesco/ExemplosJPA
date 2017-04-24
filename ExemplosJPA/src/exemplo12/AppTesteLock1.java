package exemplo12;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import exemplo11.Material;



public class AppTesteLock1 implements Runnable{

	EntityManager em;
	int cod;
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		
		
		Material m = new Material();
		
		EntityManager        em      = factory.createEntityManager();
			em.getTransaction().begin();
			m.setIdMaterial(2);
			m.setDescricao("Teste");
			Material m2 = em.merge(m);
		em.getTransaction().commit();
		em.close();
		
		
		
		AppTesteLock1 app1 = new AppTesteLock1();
		app1.em         = factory.createEntityManager();
		app1.cod        = 1;
		new Thread(app1).start();
		
		
		AppTesteLock1 app2 = new AppTesteLock1();
		app2.em         = factory.createEntityManager();
		app2.cod        = 2;
		new Thread(app2).start();
		
		
		
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	@Override
	public void run() {

	 Material m=null;
	 
	 for(int i=0; i < 10; i++)
	 {
	  try
	  {
		em.getTransaction().begin();
			m = em.find(Material.class, 2);
			m.setDescricao("" + new Date().toString());
		em.getTransaction().commit();
	  }
	  catch(Exception e)
	  {
		  System.out.println("Erro - Lock Otimista da Thread:   " + cod + ". Versao: " + m.getVersao());
		  
	  }
	    try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }	
		
		
	}

}
