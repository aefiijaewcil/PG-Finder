package com.pgfinder.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.pgfinder.entity.Owner;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Integer> {

}
