package exemplo09;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Socio
 *
 */
@Entity
public class Socio implements Serializable {

	   
	@Id
	private int idSocio;
	private String nome;
	
	
	@ElementCollection
	@CollectionTable(name="Tbl_Socio_Telefones",
	joinColumns=@JoinColumn(name="id_socio"))
	@Column(name="telefone")
	private Collection<String> telefones = new ArrayList <String>();
	
	
	private static final long serialVersionUID = 1L;

	public Socio() {
		super();
	}   

	public int getIdSocio() {
		return this.idSocio;
	}

	public void setIdSocio(int idSocio) {
		this.idSocio = idSocio;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}   
	public Collection<String> getTelefones() {
		return this.telefones;
	}

	public void setTelefones(Collection<String> telefones) {
		this.telefones = telefones;
	}
	
	public void addTelefone(String telefone)
	{
		
		telefones.add(telefone);
		
	}
	@Override
	public String toString() {
		return "Socio [idSocio=" + idSocio + ", nome=" + nome + ", telefones="
				+ telefones + "]";
	}
	
	
	
	
   
}



