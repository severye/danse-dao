package danse.security;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
public class User {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	// propriétés
	private String identity;
	private String login;
	private String password;

	// constructeur
	public User() {
	}

	public User(String identity, String login, String password) {
		this.identity = identity;
		this.login = login;
		this.password = password;
	}

	// identité
	@Override
	public String toString() {
		return String.format("User[%s,%s,%s]", identity, login, password);
	}

	// getters et setters
	
	public String getIdentity() {
		return identity;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
