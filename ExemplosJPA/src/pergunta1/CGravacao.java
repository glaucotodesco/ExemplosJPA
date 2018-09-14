package pergunta1;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name="Gravacao")
public class CGravacao {

	@Id
	@Column(name="codigo")
	private int mCodigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data")
	private Date mData;
	
	@ManyToOne
	@JoinTable(name="Musica_Gravacao",
	   joinColumns=@JoinColumn(name="codigoGravacao"),
	   inverseJoinColumns=@JoinColumn(name="codigoMusica")
	)
	private CMusica mMusica;
	
	@ManyToOne
	@JoinTable(name="Cantor_Gravacao",
		   joinColumns=@JoinColumn(name="codigoGravacao"),
		   inverseJoinColumns=@JoinColumn(name="codigoCantor")
		)
	private CCantor  mCantor;
	
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
	public Date getmData() {
		return mData;
	}
	public void setmData(Date mData) {
		this.mData = mData;
	}
	public CMusica getmMusica() {
		return mMusica;
	}
	public void setmMusica(CMusica mMusica) {
		this.mMusica = mMusica;
	}
	public CCantor getmCantor() {
		return mCantor;
	}
	public void setmCantor(CCantor mCantor) {
		this.mCantor = mCantor;
	}
	
	
	
	
	
}
