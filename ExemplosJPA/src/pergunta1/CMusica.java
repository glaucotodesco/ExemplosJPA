package pergunta1;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="Musica")
public class CMusica {
	
	@Id
	@Column(name="codigo")
	private int    mCodigo;
	
	@Column(name="Titulo")
	private String mTitulo;
	
	@Column(name="letra")
	private String mLetra;
	
	@ManyToMany
	private Collection <CCompositor> mCompositores = new ArrayList<CCompositor>();
	
	@OneToMany(cascade=CascadeType.PERSIST,mappedBy="mMusica")
	private Collection <CGravacao>   mGravacoes = new ArrayList<CGravacao>();
	
	@Enumerated(EnumType.ORDINAL)
	private TipoMusica mTipo;
	
	public TipoMusica getmTipo() {
		return mTipo;
	}
	public void setmTipo(TipoMusica mTipo) {
		this.mTipo = mTipo;
	}
	@Version
	private int mVersion;
		
	
	public int getmVersion() {
		return mVersion;
	}
	public void setmVersion(int mVersion) {
		this.mVersion = mVersion;
	}
	public int getmCodigo() {
		return mCodigo;
	}
	public void setmCodigo(int mCodigo) {
		this.mCodigo = mCodigo;
	}
	public String getmTitulo() {
		return mTitulo;
	}
	public void setmTitulo(String mTitulo) {
		this.mTitulo = mTitulo;
	}
	public String getmLetra() {
		return mLetra;
	}
	public void setmLetra(String mLetra) {
		this.mLetra = mLetra;
	}
	public Collection<CCompositor> getmCompositores() {
		return mCompositores;
	}
	public void setmCompositores(Collection<CCompositor> mCompositores) {
		this.mCompositores = mCompositores;
	}
	public Collection<CGravacao> getmGravacoes() {
		return mGravacoes;
	}
	public void setmGravacoes(Collection<CGravacao> mGravacoes) {
		this.mGravacoes = mGravacoes;
	}
	
	
	
 
}
