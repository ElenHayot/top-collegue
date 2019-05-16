package dev.topcollegue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.topcollegue.entite.MeCollegue;

public interface ParticipantRepository extends JpaRepository<MeCollegue, String>{

	MeCollegue findByEmail(String participantEmail);

	MeCollegue findByMatricule(String matricule);

	//TODO
	//set getParticipantByCollegueEmail
	
}
