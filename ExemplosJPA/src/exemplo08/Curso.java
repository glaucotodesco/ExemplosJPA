package exemplo08;

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
public class Curso implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int idCurso;
	private String nome;
	
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="cursos")
	/*@JoinTable(
	    		name="TblCursoAluno",
	    		joinColumns              = @JoinColumn(name ="c_idCurso"),
	    		inverseJoinColumns       = @JoinColumn(name ="c_matricula") 
	  	)
	 */
	
    private Collection <Aluno> alunos = new ArrayList<>();
	
	
	public Curso() {
		super();
	}

	public Curso(int idCurso, String nome)
	{
		this.idCurso = idCurso;
		this.nome    =nome;
	}
	
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Collection<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(Collection<Aluno> alunos) {
		this.alunos = alunos;
	}
	
	
	
	
}
