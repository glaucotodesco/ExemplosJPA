package exemplo05;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */

/* Testar com as 3 formas de implementar o mapeamento de herançao no banco 
 * 
 *   @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
 *   @Inheritance(strategy=InheritanceType.JOINED)
 *   @Inheritance(strategy=InheritanceType.SINGLE_TABLE)
 * //
 * */

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
//@DiscriminatorColumn(name="nomeDaColunaDescritiva", discriminatorType=DiscriminatorType.STRING,length=20)
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private long codigo;
	
	
	private String nome;
	

	public Pessoa() {
		super();
	}   
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}   
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
   
}
