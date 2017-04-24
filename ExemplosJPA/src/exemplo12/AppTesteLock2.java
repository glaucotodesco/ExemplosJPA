package exemplo12;


import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

import exemplo11.Material;



public class AppTesteLock2 implements Runnable{

	EntityManager em;
	int cod;
	
	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		
		
		Material m = new Material();
		
		EntityManager        em      = factory.createEntityManager();
			em.getTransaction().begin();
			m.setIdMaterial(2);
			m.setDescricao("Teste");
			m.setValor(2000);
			Material m2 = em.merge(m);
			
		em.getTransaction().commit();
		em.close();
		
		
		AppTesteLock2 app1 = new AppTesteLock2();
		app1.em         = factory.createEntityManager();
		app1.cod        = 1;
		new Thread(app1).start();
		
		
		AppTesteLock2 app2 = new AppTesteLock2();
		app2.em         = factory.createEntityManager();
		app2.cod        = 2;
		new Thread(app2).start();
		
		try {
			Thread.sleep(100000);
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
		em.getTransaction().begin();
			m = em.find(Material.class, 2, LockModeType.PESSIMISTIC_WRITE);
			m.setDescricao("" + new Date().toString());
		em.getTransaction().commit();
		
		System.out.println("Lock Pessimista da Thread: " + cod + " Valor= "  + m.getDescricao());
		
		try {
			Thread.sleep((int)(Math.random()*3000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
	  
	  
	  
		
	 	
		
		
	}

}
