package pergunta2;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pergunta1.CCantor;
import pergunta1.CCompositor;
import pergunta1.CGravacao;
import pergunta1.CMusica;
import pergunta1.TipoMusica;
import util.CriarBanco;

public class Pergunta2 {
	
	public static void main(String[] args) {
		
		//Cria banco de dados;
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PU_Exemplos");
		EntityManager em = emf.createEntityManager();
		
		CriarBanco.init(em);
		
		
		
		int codigoCompositor =100;
		
		CCompositor compositor = em.find(CCompositor.class, 1);
		
		if(compositor==null)
		{
			
			compositor = new CCompositor();
			compositor.setmCodigo(codigoCompositor);
			compositor.setmNome("NovoCantor" + codigoCompositor);
		
			int codigoMusica =10;
			CMusica novaMusica = new CMusica();
			novaMusica.setmCodigo(codigoMusica);
			novaMusica.setmLetra("NovaLetra" + codigoMusica);
			novaMusica.setmTipo(TipoMusica.ROCK);
			novaMusica.setmTitulo("Novo Titilo"+ codigoMusica);
			
			compositor.getmMusicas().add(novaMusica);
			novaMusica.getmCompositores().add(compositor);
			
			em.persist(compositor);
			em.persist(novaMusica);
			
			em.getTransaction().begin();
			em.getTransaction().commit();
		}
	
		int codigoCantor = 11;
		CCantor novoCantor = new CCantor();
		novoCantor.setmCodigo(codigoCantor);
		novoCantor.setmNome("NovoCantor" + codigoCantor);

		em.persist(novoCantor);
		
		int codigoGravacao=10;
		for(CMusica musica: compositor.getmMusicas())
		{
			
			CGravacao novaGravacao = new CGravacao();
			novaGravacao.setmCodigo(codigoGravacao++);
			novaGravacao.setmData(new Date());
			novaGravacao.setmCantor(novoCantor);
			novaGravacao.setmMusica(musica);
			
			musica.getmGravacoes().add(novaGravacao);
			novoCantor.getmGravacoes().add(novaGravacao);
			
			em.persist(novaGravacao);
			em.merge(musica);
			
		}
		
		
		//Salva no banco as novas informações
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
		
	}

}
