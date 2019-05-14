package dev.topcollegue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.topcollegue.entite.MeCollegue;

public interface ParticipantRepository extends JpaRepository<MeCollegue, String>{

	Boolean findByEmail(String participantEmail);

	//TODO
	//set getParticipantByCollegueEmail
	
}
