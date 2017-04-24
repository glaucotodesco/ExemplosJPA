package exemplo05;

import java.io.Serializable;

import javax.persistence.*;

import exemplo05.Pessoa;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)

@Entity
public class Cliente extends Pessoa implements Serializable {

	
	private double saldo;
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}   
	public double getSaldo() {
		return this.saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
   
}
