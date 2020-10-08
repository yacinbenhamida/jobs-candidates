package com.esprit.microservices;

import java.util.List;

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

import com.esprit.models.Job;

import com.esprit.services.JobService;

@RestController
@RequestMapping("/api/jobs")
public class JobRest {
	@Autowired
	private JobService service; 
	@PostMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Job> create(@RequestBody Job job){
		return new ResponseEntity<Job>(service.add(job),HttpStatus.OK);
	}
	@GetMapping("/{id}/{name}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Job> displayByName(@PathVariable("id") int id,@PathVariable("name") String name){
		return new ResponseEntity<Job>(service.displayByNameOrId(name, id),HttpStatus.OK);
	}
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<Job>> getAllJobs(){
		return new ResponseEntity<List<Job>>(service.getAll(),HttpStatus.OK);
	}
	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<String> editJobState(@PathVariable("id") int id){
		return new ResponseEntity<String>(service.editJobState(id),HttpStatus.OK);
	}
}
