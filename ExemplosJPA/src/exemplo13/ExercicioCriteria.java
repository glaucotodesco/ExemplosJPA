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



public class ExercicioCriteria {

	
	public static void main(String[] args) {
		
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("PU_Exemplo01");
		
		
		Material m;
	
		EntityManager        em;
		
		em= factory.createEntityManager();
		
		m = em.find(Material.class, 2);
			
		if(m==null)
		{
				m = new Material();
			    m.setIdMaterial(2);
				m.setDescricao("Teste");
				m.setValor(30);
				em.persist(m);
				
		}
		else
		{
			m.setValor(10.000);
		}	
			
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		CriteriaBuilder 		builder 	= em.getCriteriaBuilder();
		CriteriaQuery<Material> query 		= builder.createQuery(Material.class);
		Root <Material>			from 	  	= query.from(Material.class);
		ParameterExpression<Double> pValorInical 	= builder.parameter(Double.class);
		ParameterExpression<Double> pValorFinal 	= builder.parameter(Double.class);
		
	     
		TypedQuery<Material>   typeQuery 	= em.createQuery(
				query.select(from)
				.where(builder.between(from.<Double>get("valor"),pValorInical, pValorFinal))
		);
				
		typeQuery.setParameter(pValorInical, 10.0);
		typeQuery.setParameter(pValorFinal,  20.0);
		
		List <Material> list = typeQuery.getResultList();
		
		
		for(Material mat: list)
		{
			System.out.println(mat);
		}
		
		em.close();
		

	

		
		
		
		
		
		
		

		
	}



}
