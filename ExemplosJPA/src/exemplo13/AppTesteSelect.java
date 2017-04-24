package exemplo13;


import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;

import exemplo11.Material;



public class AppTesteSelect {

	
	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplos");
		
		
		
		
		EntityManager        em      = factory.createEntityManager();
			em.getTransaction().begin();
		
			Material m1 = new Material();
			m1.setIdMaterial(2010);
			m1.setDescricao("Teste1");
			m1.setValor(30);
			
			Material m2 = new Material();
			m2.setIdMaterial(3020);
			m2.setDescricao("Teste2");
			m2.setValor(55);
			
			em.persist(m1);
			em.persist(m2);

		em.getTransaction().commit();
		
		
		
		
		CriteriaBuilder 		builder 	= em.getCriteriaBuilder();
		CriteriaQuery<Material> cQuery 		= builder.createQuery(Material.class);
		Root <Material>			from 	  	= cQuery.from(Material.class);
        cQuery.select(from);
        TypedQuery<Material>    typeQuery   = em.createQuery(cQuery);
        List <Material> list 				= typeQuery.getResultList();
        
        
        
        
        
        for(Material mat: list)
		{
			System.out.println(mat);
		}
		
	
		
		em.close();
	}



}
