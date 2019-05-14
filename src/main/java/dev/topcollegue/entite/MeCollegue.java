package dev.topcollegue.entite;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
public class MeCollegue {

	@Id
	@Column
	private String matricule;
	@Column
	private String name;
	@Column
	private String firstname;
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> role;
	@Column
	private String photoUrl;
	@Column
	private String email;
	
	public MeCollegue() {
		super();
	}

	
	public MeCollegue(String matricule, String name, String firstname, List<String> role, String email) {
		super();
		this.matricule = matricule;
		this.name = name;
		this.firstname = firstname;
		this.role = role;
		this.email = email;
	}

	public MeCollegue(String matricule, String name, String firstname, List<String> role, String email,
			String photoUrl) {
		super();
		this.matricule = matricule;
		this.name = name;
		this.firstname = firstname;
		this.role = role;
		this.email = email;
		this.photoUrl = photoUrl;
	}

	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public List<String> getRole() {
		return role;
	}
	public void setRole(List<String> role) {
		this.role = role;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
