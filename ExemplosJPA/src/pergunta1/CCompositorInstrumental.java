package pergunta1;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="CompositorInstrumental")
public class CCompositorInstrumental extends CCompositor{
	
	private String cTipo;

	public String getcTipo() {
		return cTipo;
	}

	public void setcTipo(String cTipo) {
		this.cTipo = cTipo;
	}
	
	

}
