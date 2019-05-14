package dev.topcollegue.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import dev.topcollegue.entite.MeCollegue;
import dev.topcollegue.entite.Participant;
import dev.topcollegue.exception.EmptyRepositoryException;
import dev.topcollegue.exception.EntityNotFoundException;
import dev.topcollegue.repository.ParticipantRepository;

@Service
public class ParticipantService {

	@Autowired
	private RestTemplate restTemplate;
	

	
	@Autowired
	private ParticipantRepository repo;
	
	
	public ParticipantService() {
		super();
	}

	//modify restTemplate before building it
	public ParticipantService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	private String apiCollegueUrl = "https://hayot-collegues-api.herokuapp.com";
	
	
	public List<String> postNewParticipant(Participant participant) throws Exception {
		
		Map<String, String> infosAuthentication = new HashMap<>();
			infosAuthentication.put("email", participant.getParticipantEmail());
			infosAuthentication.put("password", participant.getParticipantPassword());
		
		
		//if(repo.findByEmail(participant.getParticipantEmail()) == false){
			
			ResponseEntity<?> response = restTemplate.postForEntity(apiCollegueUrl + "/auth", infosAuthentication, ResponseEntity.class);
			List<String> cookieValue = response.getHeaders().get(HttpHeaders.SET_COOKIE);
			
			if(response.ok() != null){
				HttpHeaders header = new HttpHeaders();
					header.put("Cookie", cookieValue);
					HttpEntity<String> entity = new HttpEntity<String>(header);
					ResponseEntity<MeCollegue>  result = restTemplate.exchange(apiCollegueUrl + "/me", HttpMethod.GET, entity, MeCollegue.class);
			
					if(result.getBody() != null) {
						if(participant.getParticipantPhotoUrl() != null) {
							result.getBody().setPhotoUrl(participant.getParticipantPhotoUrl());
							repo.save(result.getBody());
							return header.get(HttpHeaders.COOKIE);
						}else{
							repo.save(result.getBody());
							return header.get(HttpHeaders.COOKIE);
						}
					}else{
						throw new EntityNotFoundException("You might be a registered colleague before particpate.");
					}
			
			}else{
				throw new EntityNotFoundException("Oo, seems that your identifier or password is wrong...");
			}
		//}else{throw new ParticipantDataExceeption("You're already registered to participate. You can't register twice.");}
		
	}
	
	
	public List<MeCollegue> listParticipants() throws Exception {
		
		List<MeCollegue> result = new ArrayList<>();
		for(MeCollegue meCol:repo.findAll()) {
			result.add(meCol);
		}
		
		if(result.isEmpty()) {
			throw new EmptyRepositoryException("There's no registered colleague for this application");
		}else{
			return result;
		}
		
	}
	
}
