package util;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pergunta1.CCantor;
import pergunta1.CCompositor;
import pergunta1.CGravacao;
import pergunta1.CMusica;
import pergunta1.TipoMusica;

public class CriarBanco {

	public static void main(String[] args) {
	
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("SolucaoProva2");
		EntityManager em = emf.createEntityManager();
		
		init(em);
		
		em.close();
		emf.close();
		 
	}
		
	
	public static void init(EntityManager em) {
		
		
		
		CCompositor co1 = new CCompositor();
		co1.setmCodigo(1);
		co1.setmNome("Compositor 1");
		
		
		CCompositor co2 = new CCompositor();
		co2.setmCodigo(2);
		co2.setmNome("Compositor 2");
		
		CCompositor co3 = new CCompositor();
		co3.setmCodigo(3);
		co3.setmNome("Compositor 3");
		
		CMusica m1 = new CMusica();
		m1.setmCodigo(1);
		m1.setmTipo(TipoMusica.CLASSICA);
		m1.setmLetra("Letra da musica 1");
		m1.setmTitulo("Titulo da musica 1");
		
		CMusica m2 = new CMusica();
		m2.setmCodigo(2);
		m2.setmTipo(TipoMusica.DANCE);
		m2.setmLetra("Letra da musica 2");
		m2.setmTitulo("Titulo da musica 2");
		
		
		CMusica m3 = new CMusica();
		m3.setmCodigo(3);
		m3.setmTipo(TipoMusica.ROCK);
		m3.setmLetra("Letra da musica 3");
		m3.setmTitulo("Titulo da musica 3");
		
		CMusica m4 = new CMusica();
		m4.setmCodigo(4);
		m4.setmTipo(TipoMusica.ROCK);
		m4.setmLetra("Letra da musica 4");
		m4.setmTitulo("Titulo da musica 4");
		
		
		m1.getmCompositores().add(co1);
		co1.getmMusicas().add(m1);
		m4.getmCompositores().add(co1);
		co1.getmMusicas().add(m4);
	
	
		m2.getmCompositores().add(co2);
		co2.getmMusicas().add(m2);
		
		m3.getmCompositores().add(co3);
		co3.getmMusicas().add(m3);
		m3.getmCompositores().add(co2);
		co2.getmMusicas().add(m3);
	
		//Salva Compositores e Músicas
		em.persist(co1);
		em.persist(co2);
		em.persist(co3);
		em.persist(m1);
		em.persist(m2);
		em.persist(m3);
		em.persist(m4);
		
		
		CCantor ca1 = new CCantor();
		ca1.setmCodigo(1);
		ca1.setmNome("Cantor 1");
		
		CCantor ca2 = new CCantor();
		ca2.setmCodigo(2);
		ca2.setmNome("Cantor 2");
		
		
		CCantor ca3 = new CCantor();
		ca3.setmCodigo(3);
		ca3.setmNome("Cantor 3");
		
		CGravacao g1 = new CGravacao();
		g1.setmCodigo(1);
		g1.setmData(new Date());
		g1.setmCantor(ca1);
		g1.setmMusica(m1);
		ca1.getmGravacoes().add(g1);
		m1.getmGravacoes().add(g1);
		
		CGravacao g2 = new CGravacao();
		g2.setmCodigo(2);
		g2.setmData(new Date());
		g2.setmCantor(ca2);
		g2.setmMusica(m1);
		ca2.getmGravacoes().add(g2);
		m1.getmGravacoes().add(g2);
		
		CGravacao g3 = new CGravacao();
		g3.setmCodigo(3);
		g3.setmData(new Date());
		g3.setmCantor(ca2);
		g3.setmMusica(m2);
		ca2.getmGravacoes().add(g3);
		m2.getmGravacoes().add(g3);
		
		
		CGravacao g4 = new CGravacao();
		g4.setmCodigo(4);
		g4.setmData(new Date());
		g4.setmCantor(ca3);
		g4.setmMusica(m3);
		ca3.getmGravacoes().add(g4);
		m3.getmGravacoes().add(g4);
		
		CGravacao g5 = new CGravacao();
		g5.setmCodigo(5);
		g5.setmData(new Date());
		g5.setmCantor(ca1);
		g5.setmMusica(m3);
		ca1.getmGravacoes().add(g4);
		m3.getmGravacoes().add(g4);
		
		
		//Grava cantores e gravacoes
		em.persist(ca1);
		em.persist(ca2);
		em.persist(ca3);
		
		em.persist(g1);
		em.persist(g2);
		em.persist(g3);
		em.persist(g4);
		em.persist(g5);
		
		
		
		
		
		
		em.getTransaction().begin();
		em.getTransaction().commit();	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}


	

}
