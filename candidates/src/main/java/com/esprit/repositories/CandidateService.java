package com.esprit.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.models.Candidat;
import com.example.demo.CandidatRepository;

@Service
public class CandidateService {
	@Autowired
	private CandidatRepository candidatRepository;
	
	public Candidat add(Candidat candidat) {
		return candidatRepository.save(candidat);
	}
	public Candidat update(Candidat candidat) {
		if(this.candidatRepository.findById(candidat.getId()).isPresent()) {
			return candidatRepository.save(candidat);	
		}
		return null;
	}
	public boolean delete(int id) {
		if (candidatRepository.findById(id).isPresent()){
			 candidatRepository.deleteById(id); 
			 return true;
		}
		return false;
	}
}
