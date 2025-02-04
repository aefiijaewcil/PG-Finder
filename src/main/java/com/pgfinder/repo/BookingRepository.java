package com.pgfinder.repo;

import java.beans.Transient;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pgfinder.entity.Booking;
import com.pgfinder.entity.Tenant;

import jakarta.transaction.Transactional;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByTenant(Tenant tenant);

    @Transactional
    void deleteByTenant(Tenant tenant);

    // @Transactional
    // @Modifying
    // @Query("delete from Booking b where b.tenant.id = :tenantId")
    // void deleteByTenantId(@Param("tenantId") int tenantId);

}
