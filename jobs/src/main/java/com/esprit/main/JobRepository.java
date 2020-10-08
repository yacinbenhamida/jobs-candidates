package com.esprit.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esprit.models.Job;

public interface JobRepository extends  JpaRepository<Job, Integer>{
	@Query("select j from Job j where j.service like CONCAT('%',:nom,'%') or j.id = :id")
	public Job jobByNameOrId(@Param("nom") String nom,@Param("id") int id);
}
