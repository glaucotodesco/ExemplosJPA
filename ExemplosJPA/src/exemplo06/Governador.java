package exemplo06;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Governador
 *
 */
@Entity
@Table(name="TBL_Governador")
public class Governador implements Serializable {

	   
	@Id
	private int id;
	private String nome;
	private String partido;
	private static final long serialVersionUID = 1L;
	
	@OneToOne(mappedBy="governador")
	private Estado estado;
	
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public Governador() {
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
	public String getPartido() {
		return this.partido;
	}

	public void setPartido(String partido) {
		this.partido = partido;
	}
   
}
