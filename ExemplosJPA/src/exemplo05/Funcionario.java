package exemplo05;

import java.io.Serializable;

import javax.persistence.*;

import exemplo05.Pessoa;

/**
 * Entity implementation class for Entity: Funcionario
 *
 */
@Entity
@DiscriminatorValue(value="FuncXXXXXXXX")
public class Funcionario extends Pessoa implements Serializable {

	
	private double salario;
	private static final long serialVersionUID = 1L;

	public Funcionario() {
		super();
	}   
	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
   
}
