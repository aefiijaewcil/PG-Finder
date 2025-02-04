package com.pgfinder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgfinder.entity.Booking;
import com.pgfinder.entity.Tenant;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByTenant(Tenant tenant);

}
