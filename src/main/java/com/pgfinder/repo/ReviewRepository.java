package com.pgfinder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pgfinder.entity.Property;
import com.pgfinder.entity.Review;

import jakarta.transaction.Transactional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findByProperty(Property property);

    @Transactional
    @Modifying
    @Query("DELETE FROM Review r WHERE r.property.id = :propertyId")
    void deleteByPropertyId(@Param("propertyId") int propertyId);
}
