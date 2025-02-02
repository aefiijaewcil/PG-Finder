package com.pgfinder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgfinder.entity.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {
	
	

}
