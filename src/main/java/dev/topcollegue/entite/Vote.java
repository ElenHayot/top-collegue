package dev.topcollegue.entite;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import dev.topcollegue.repository.ParticipantRepository;

@Entity
public class Vote {
	
	public enum VoteValue {
		LIKE, DISLIKE, NEUTRAL;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name="DATE_VOTE")
	private LocalDateTime dateVote;
	@Column
	@Enumerated(EnumType.STRING)
	private VoteValue voteValue;
	
	@ManyToOne
	@JoinColumn(name="PARTICIPANT_COLLEGUE")
	private MeCollegue participantCol;
	
	private String participantEmail;
	
	@ManyToOne
	@JoinColumn(name="AUTHOR")
	private MeCollegue authorCol;
	
	private String authorEmail;
	
	//public Integer getScore() {
		//TODO
		//source of an infinite loop ??
		//return voteValue == VoteValue.LIKE ? 100 : -50;
	//}
	

	public Vote() {
		super();
	}


	public Vote(String authorEmail, String participantEmail, VoteValue voteValue) {
		super();
		this.dateVote = LocalDateTime.now();
		
		this.authorEmail = authorEmail;
		this.participantEmail = participantEmail;
		this.voteValue = voteValue;
	}


	public LocalDateTime getDateVote() {
		return dateVote;
	}


	public void setDateVote(LocalDateTime dateVote) {
		this.dateVote = dateVote;
	}


	public VoteValue getVoteValue() {
		return voteValue;
	}


	public void setVoteValue(VoteValue voteValue) {
		this.voteValue = voteValue;
	}


	public String getParticipantEmail() {
		return participantEmail;
	}


	public void setParticipantEmail(String participantEmail) {
		this.participantEmail = participantEmail;
	}


	public String getAuthorEmail() {
		return authorEmail;
	}


	public void setAuthorEmail(String authorEmail) {
		this.authorEmail = authorEmail;
	}


	public MeCollegue getParticipantCol() {
		return participantCol;
	}


	public void setParticipantCol(MeCollegue participantCol) {
		this.participantCol = participantCol;
	}


	public MeCollegue getAuthorCol() {
		return authorCol;
	}


	public void setAuthorCol(MeCollegue authorCol) {
		this.authorCol = authorCol;
	}


	
}
