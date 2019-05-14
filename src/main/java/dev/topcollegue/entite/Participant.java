package dev.topcollegue.entite;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer participantId;
	
	@Column(name="EMAIL")
	String participantEmail;
	
	@Column(name="PASSWORD")
	String participantPassword;
	
	@Column(name="PHOTOSURL")
	String participantPhotoUrl;
	
	
	public Participant() {
		super();
	}


	public Participant(String participantEmail, String participantPassword) {
		super();
		this.participantEmail = participantEmail;
		this.participantPassword = participantPassword;
	}


	public Participant(String participantEmail, String participantPassword, String participantPhotoUrl) {
		super();
		this.participantEmail = participantEmail;
		this.participantPassword = participantPassword;
		this.participantPhotoUrl = participantPhotoUrl;
	}


	public Integer getParticipantId() {
		return participantId;
	}


	public void setParticipantId(Integer participantId) {
		this.participantId = participantId;
	}


	public String getParticipantEmail() {
		return participantEmail;
	}


	public void setParticipantEmail(String participantEmail) {
		this.participantEmail = participantEmail;
	}


	public String getParticipantPassword() {
		return participantPassword;
	}


	public void setParticipantPassword(String participantPassword) {
		this.participantPassword = participantPassword;
	}


	public String getParticipantPhotoUrl() {
		return participantPhotoUrl;
	}


	public void setParticipantPhotoUrl(String participantPhotoUrl) {
		this.participantPhotoUrl = participantPhotoUrl;
	}
	
}
