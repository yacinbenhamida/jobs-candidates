package com.example.demo;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.models.Candidat;

public interface CandidatRepository extends JpaRepository<Candidat, Integer>{
	@Query("select c from Candidat c where c.prenom like :nom")
	public Page<Candidat> candidateByName(@Param("nom") String nom, Pageable pageable);
}
