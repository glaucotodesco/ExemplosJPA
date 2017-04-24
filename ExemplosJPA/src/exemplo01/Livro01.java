package exemplo01;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Livro
 *
 */
@Entity
public class Livro01 implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	@Id
	private long codigo;
	private String autor;
	private double valor;
	private String titulo;
	
	public Livro01() {
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
	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	@Override
	public String toString() {
		return "Livro01 [codigo=" + codigo + ", autor=" + autor + ", valor="
				+ valor + ", titulo=" + titulo + "]";
	}   
	
	
	
   
}
