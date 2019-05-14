package dev.topcollegue.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.topcollegue.entite.Participant;
import dev.topcollegue.exception.EmptyRepositoryException;
import dev.topcollegue.exception.ParticipantDataExceeption;
import dev.topcollegue.service.ParticipantService;

@RestController
public class ParticipantsController {
	
	@Autowired
	ParticipantService service;

	
	@PostMapping
	public ResponseEntity<?> saveParticipant(@RequestBody Participant participant, HttpServletResponse response) throws Exception {
		
		try{
			List<String> cookie = service.postNewParticipant(participant);
			for(String c:cookie){
			response.setHeader(HttpHeaders.SET_COOKIE, c);
			}
			return ResponseEntity.ok().build();
			
		}catch(EntityNotFoundException | ParticipantDataExceeption e) {
			return ResponseEntity.status(404).body(e.getMessage());
		}
		
		
	}
	
	@GetMapping(value = "/list")
	public ResponseEntity<?> listOfParticipants() throws Exception {

		try{
			return ResponseEntity.ok(service.listParticipants());
		}catch(EmptyRepositoryException e){
			return ResponseEntity.status(404).body(e.getMessage());
		}
	}
	
}
