package com.pgfinder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgfinder.entity.Tenant;

@Repository
public interface TenantRepository extends JpaRepository<Tenant, Integer> {

}
