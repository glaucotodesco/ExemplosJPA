package exemplo08;

/**
 * 
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Aluno implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	private int matricula;
	private String nome;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
    		name="TblCursoAluno",
    		joinColumns              = @JoinColumn(name ="c_matricula"),
    		inverseJoinColumns       = @JoinColumn(name ="c_idCurso") 
  	)
	private  Collection<Curso> cursos = new ArrayList<Curso>();
	 
	public Aluno() {
		super();
	}
	public Aluno(int matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Collection<Curso> getCursos() {
		return cursos;
	}
	public void setCursos(Collection<Curso> cursos) {
		this.cursos = cursos;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
