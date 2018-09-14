package exemplo03;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

//Conversão automática do tipo pelo JPA, não é necessário usar @Convert nas entidades.
//@Converter(autoApply=true)						 
@Converter ////Será necessário usar nas entidades	
public class PeriodoConverter implements AttributeConverter<Periodo, String> {

	@Override
	public String convertToDatabaseColumn(Periodo periodo) 
	{
		switch (periodo) 
		{
			case DIURNO: 		return "D"; 
			case VESPERTINO: 	return "V"; 
			case NOTURNO:	    return "N"; 
			default: throw new IllegalArgumentException("Unknown" + periodo);
		}
	}

	@Override
	public Periodo convertToEntityAttribute(String periodo) {

		switch (periodo)
		{
			case "D": return Periodo.DIURNO;
			case "V": return Periodo.VESPERTINO;
			case "N": return Periodo.NOTURNO;
			default: throw new IllegalArgumentException("Unknown" + periodo);
		}
	}

}
