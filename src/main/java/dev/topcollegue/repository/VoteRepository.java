package dev.topcollegue.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.topcollegue.entite.Vote;
import dev.topcollegue.entite.Vote.VoteValue;

public interface VoteRepository extends JpaRepository<Vote, Integer>{

	Set<VoteValue> findVoteValueByParticipantCol(String email);

	Set<VoteValue> findVoteValueByParticipantEmail(String email);
	

}
