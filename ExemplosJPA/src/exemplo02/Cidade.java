package exemplo02;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cidade
 *
 */
@Entity
@Access(AccessType.FIELD)
public class Cidade implements Serializable {

	   
	@Id
	private int id;
	private String nome;
	private String estado;
	private long populacao;
	private static final long serialVersionUID = 1L;

	public Cidade() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	
	@Access(AccessType.PROPERTY)
	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		System.out.println("Teste");
		this.estado = estado;
	}   
	public long getPopulacao() {
		return this.populacao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	
	
	@Override
	public String toString() {
		return "Cidade [id=" + id + ", nome=" + nome + ", estado=" + estado
				+ ", populacao=" + populacao + "]";
	}
   
	
	
}
