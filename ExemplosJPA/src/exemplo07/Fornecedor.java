package exemplo07;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Fornecedor
 * @JoinTable(name="TBL_FORN_PRODUTO",joinColumns=@JoinColumn(name="fornecedor_id"), 
	inverseJoinColumns=@JoinColumn(name="produto_id"))
	
   @OneToMany(cascade=CascadeType.ALL, mappedBy= "fornecedor")
 */
@Entity
public class Fornecedor implements Serializable {
	@Id
	private int id;
	private String nome;
	
		
	@OneToMany(mappedBy="fornecedor")
	private Collection <Produto> produtos = new ArrayList <Produto>();
	
	
	private static final long serialVersionUID = 1L;

	public Fornecedor() {
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
	
	
	public void addProduto(Produto p)
	{
		
		produtos.add(p);
	}
	
	public Collection<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(Collection<Produto> produtos) {
		this.produtos = produtos;
	}
   
	
	
}
