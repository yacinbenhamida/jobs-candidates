package com.esprit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.main.JobRepository;
import com.esprit.models.Job;
@Service
public class JobService {
	@Autowired
	private JobRepository jobRepository;
	
	public Job add(Job job) {
		return jobRepository.save(job);
	}
	public Job displayByNameOrId(String name,int id) {
		return jobRepository.jobByNameOrId(name, id);
	}
	public List<Job> getAll(){
		return jobRepository.findAll();
	}
	public String editJobState(int id) {
		Job j = jobRepository.findById(id).get();
		if(j != null) {
			j.setEtat(!j.isEtat());
			jobRepository.save(j);
			if(j.isEtat()) return "poste disponible";
			else return "poste occupé";
		}
		return null;
	}
}
