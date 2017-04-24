package exemplo11;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Material
 *
 */
@Entity
public class Material implements Serializable {

	@Id
	private int idMaterial;
	private String descricao;
	private double valor;

	@Version
	private int versao;

	private static final long serialVersionUID = 1L;

	public Material() {
		super();
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}

	public int getIdMaterial() {
		return this.idMaterial;
	}

	public void setIdMaterial(int idMaterial) {
		this.idMaterial = idMaterial;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@PrePersist
	public void prePersistMetodo() {
		System.out.println("Uma entidade será persistida no banco");
	}

	@PostPersist
	public void posPersistMetodo() {
		System.out.println("Uma entidade foi persistida no banco");
	}

	@PostUpdate
	public void postUpdate() {
		System.out.println("Uma entidade foi alterada no banco. Versão = " + getVersao());
	}

	@PreRemove
	@PostRemove
	public void remove() {
		System.out.println("Uma entidade será ou foi removida");

	}

	@Override
	public String toString() {
		return "Material [idMaterial=" + idMaterial + ", descricao="
				+ descricao + ", valor=" + valor + ", versao=" + versao + "]";
	}
	
	
	

}
