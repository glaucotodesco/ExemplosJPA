package exemplo10;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
public class Client implements Serializable {

	   
	@Id
	private int id;
	private String nome;
	

	@Embedded
	private Address endereco;
	
	
	private static final long serialVersionUID = 1L;
	

	public Client() {
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
	public Address getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Address endereco) {
		this.endereco = endereco;
	}
   
}
