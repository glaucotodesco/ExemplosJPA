package exemplo02;

import java.io.Serializable;
import java.lang.String;
import java.util.Calendar;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Exemplo02
 *
 */
@Entity
@Table(name="TBL_LIVRO")

@NamedQueries 
({
	@NamedQuery(name="Livro02.findAll",           query=" Select l From Livro02 l"),
	@NamedQuery(name="Livro02.findValorAbaixo",   query=" Select l From Livro02 l Where l.valor < :valor"),
 
})
public class Livro02 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="MyKey")
	private long codigo;

	@Column(length=50)
	private String autor;
	
	@Column(length=70, nullable=false)
	private String titulo;
	
	@Column(name="PRECO")
	private double valor;

	@Lob
	private byte[] capa;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar anoPuplicacao;
	
	
	@Transient
	private double custo;
	

	public Livro02() {
		super();
	}   
	public long getCodigo() {
		return this.codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}   
	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}   
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}   
	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public byte[] getCapa() {
		return capa;
	}
	
	public void setCapa(byte[] capa) {
		this.capa = capa;
	}
	public Calendar getAnoPuplicacao() {
		return anoPuplicacao;
	}
	public void setAnoPuplicacao(Calendar anoPuplicacao) {
		this.anoPuplicacao = anoPuplicacao;
	}
	
	
	@Override
	public String toString() {
		return "Livro [codigo=" + codigo + ", autor=" + autor + ", titulo="
				+ titulo + ", valor=" + valor + "]";
	}
   
	
	
	
}
