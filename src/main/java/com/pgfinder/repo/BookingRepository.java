package com.pgfinder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pgfinder.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
