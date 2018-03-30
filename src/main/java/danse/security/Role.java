/**
 * 
 */
package danse.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ROLES")
public class Role{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	// propriétés
	private String name;

	// constructeurs
	public Role() {
	}

	public Role(String name) {
		this.name = name;
	}

	// identité
	@Override
	public String toString() {
		return String.format("Role[%s]", name);
	}

	// getters et setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
