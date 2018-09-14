package exemplo03;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import org.eclipse.persistence.annotations.ConversionValue;
import org.eclipse.persistence.annotations.ObjectTypeConverter;

/**
 * Entity implementation class for Entity: Classe
 *
 */

@Entity
public class Classe implements Serializable {
	
	@Id
	private int id;
	private String curso;
	private String semestre;
	
	
	
	//@Enumerated(EnumType.ORDINAL)
	
	//@Enumerated(EnumType.ORDINAL)
	//@Convert(converter=PeriodoConverter.class)
	private Periodo periodo = Periodo.VESPERTINO;
	
	private static final long serialVersionUID = 1L;

	public Classe() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getCurso() {
		return this.curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}   
	public String getSemestre() {
		return this.semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public Periodo getPeriodo() {
		return periodo;
	}
	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}
	
	@Override
	public String toString() {
		return "Classe [id=" + id + ", curso=" + curso + ", semestre="
				+ semestre + ", periodo=" + periodo + "]";
	}
	
	
	
	
   
}
