package pergunta3;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pergunta1.CCompositor;
import pergunta1.CGravacao;
import pergunta1.CMusica;
import util.CriarBanco;

public class Pergunta3 {

	public static void main(String[] args) {

		// Cria banco de dados;
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("PU_Exemplos");
		EntityManager em = emf.createEntityManager();

		CriarBanco.init(em);
		
		int codigoCompositor=1;
		
		CCompositor c = em.find(CCompositor.class, codigoCompositor);
		
		if(c!= null)
		{
			System.out.println("Dados do compositor:");
			System.out.println("Código:" + c.getmCodigo());
			System.out.println("Nome:" + c.getmNome());
			System.out.println("***** Musicas do compositor:");
			for(CMusica musica: c.getmMusicas())
			{
				System.out.println("");
				System.out.println("********** Código Musica:"  + musica.getmCodigo());
				System.out.println("********** Código Tipo:"    + musica.getmTipo());
				System.out.println("********** Código Titulo :" + musica.getmTitulo());
				System.out.println("********** Código Letra :"  + musica.getmLetra());
				
				System.out.println("*************** Gravações da Música");
				for(CGravacao gravacao: musica.getmGravacoes())
				{
					System.out.println("");
					System.out.println("*************** Código da gravacao: " + gravacao.getmCodigo());
					System.out.println("*************** Data  da gravacao: " + gravacao.getmData());
					System.out.println("*************** Cantor  da gravacao: " + gravacao.getmCantor().getmNome());
				}		
			}
		}
		
		
		em.close();
		emf.close();
	}
	
	

}
