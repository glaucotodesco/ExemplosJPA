package pergunta1;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Cantor")
public class CCantor {
	
	@Id
	@Column(name="codigo")
	private int mCodigo;
	
	@Column(name="nome")
	private String mNome;
	
	@Version
	private int mVersion;
	
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="mCantor")
	private Collection <CGravacao> mGravacoes = new ArrayList <CGravacao>();
	
	
	public int getmCodigo() {
		return mCodigo;
	}
	public void setmCodigo(int mCodigo) {
		this.mCodigo = mCodigo;
	}
	public String getmNome() {
		return mNome;
	}
	public void setmNome(String mNome) {
		this.mNome = mNome;
	}
	public int getmVersion() {
		return mVersion;
	}
	public void setmVersion(int mVersion) {
		this.mVersion = mVersion;
	}
	public Collection<CGravacao> getmGravacoes() {
		return mGravacoes;
	}
	public void setmGravacoes(Collection<CGravacao> mGravacoes) {
		this.mGravacoes = mGravacoes;
	}
	
	
	
	

}
