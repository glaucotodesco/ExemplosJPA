package exemplo07;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Produto
 *
 */
@Entity
public class Produto implements Serializable {

	   
	@Id
	private int id;
	private String descricao;
	private double valor;
	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	//@JoinColumn(name="idFornecedor")
	@JoinTable(name="TBL_FORN_PRODUTO",
			inverseJoinColumns=@JoinColumn(name="fornecedor_id"),
					joinColumns=@JoinColumn(name="produto_id"))
	private Fornecedor fornecedor;
	
	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}
	public Produto() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}   
	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
   
}
