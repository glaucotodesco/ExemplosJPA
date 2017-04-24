package exemplo09;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: Socio
 *
 */
@Entity
public class A implements Serializable {

	   
	@Id
	private int id;
	private String x1;
	
	
	@ElementCollection
	@CollectionTable(name="Tbl_B",joinColumns=@JoinColumn(name="id"))
	@Column(name="z1")
	private Collection<String> y1 = new ArrayList <String>();
	
	
	private static final long serialVersionUID = 1L;

	public A() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getX1() {
		return x1;
	}

	public void setX1(String x1) {
		this.x1 = x1;
	}

	public Collection<String> getY1() {
		return y1;
	}

	public void setY1(Collection<String> y1) {
		this.y1 = y1;
	}   

	
   
}



