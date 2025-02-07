package com.pgfinder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pgfinder.entities.Property;

import jakarta.transaction.Transactional;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Integer> {

    // List<Property> findByOwner(Owner owner);

    @Transactional
    @Modifying
    @Query("Delete FROM Property p WHERE p.owner.id = :ownerId")
    void deleteByOwnerId(@Param("ownerId") int ownerId);

    @Query("SELECT p FROM Property p WHERE p.owner.id = :ownerId")
    List<Property> findByOwnerId(@Param("ownerId") int ownerId);

}
