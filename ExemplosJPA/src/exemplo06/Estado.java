package exemplo06;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Estado
 *
 */
@Entity
@Table(name="TBL_Estado")
public class Estado implements Serializable {

	@Id
	private int id;
	private String nome;

	@OneToOne
	@JoinColumn(name="id_governador")
	private Governador governador;
	
	
	private static final long serialVersionUID = 1L;

	public Estado() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	
	
	public Governador getGovernador() {
		return governador;
	}
	public void setGovernador(Governador governador) {
		this.governador = governador;
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
   
}
