package com.esprit.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.models.Candidat;
import com.esprit.repositories.CandidateService;

@RestController
@RequestMapping("/api/candidates")
public class CandidatRest {
	@Autowired
	private CandidateService service; 
	@RequestMapping("/hello")
	public String sayHello() {
		return "this is my first SP Microservice";
	}
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Candidat> create(@RequestBody Candidat candidat){
		return new ResponseEntity<Candidat>(service.add(candidat),HttpStatus.OK);
	}
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Candidat> edit(@RequestBody Candidat candidat){
		return new ResponseEntity<Candidat>(service.update(candidat),HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Boolean> edit(@PathVariable("id") int id){
		return new ResponseEntity<Boolean>(service.delete(id),HttpStatus.OK);
	}
}
