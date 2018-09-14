package pergunta1;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Version;
@Entity
@Table(name="Compositor")
@Inheritance(strategy=InheritanceType.JOINED)
public class CCompositor {
	
	@Id
	@Column(name="codigo")
	private int mCodigo;
	
	@Column(name="nome")
	private String mNome;

	@Version
	private int mVersion;
	
	@ManyToMany(mappedBy="mCompositores")
	private Collection <CMusica> mMusicas  = new ArrayList<CMusica>();

	
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

	public Collection<CMusica> getmMusicas() {
		return mMusicas;
	}

	public void setmMusicas(Collection<CMusica> mMusicas) {
		this.mMusicas = mMusicas;
	}
	
	

}
