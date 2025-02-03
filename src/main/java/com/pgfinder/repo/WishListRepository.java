package com.pgfinder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pgfinder.entity.Tenant;
import com.pgfinder.entity.WishList;

import jakarta.transaction.Transactional;

@Repository
public interface WishListRepository extends JpaRepository<WishList, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM WishList w WHERE w.tenant = :tenant")
    void deleteAllByTenantId(@Param("tenant") Tenant tenant);

    @Query("SELECT w FROM WishList w WHERE w.tenant = :tenant")
    List<WishList> findByTenant(@Param("tenant") Tenant tenant);

}
