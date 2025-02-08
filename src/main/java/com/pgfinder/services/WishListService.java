package com.pgfinder.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.dtos.UserDTO;
import com.pgfinder.entities.Tenant;
import com.pgfinder.entities.WishList;
import com.pgfinder.repositories.WishListRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private TenantService tenantService;

    public void addPropertyToWishList(int tenantId, int propertyId) {
        UserDTO tenantDTO = tenantService.getTenantById(tenantId);
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(tenantDTO, tenant);

        WishList wishList = new WishList();
        wishList.setPropertyId(propertyId);
        wishList.setTenant(tenant);

        wishListRepository.save(wishList);
    }

    public void removePropertyFromWishList(int wishlistId) {
        wishListRepository.deleteById(wishlistId);
    }

    public void removeAllPropertiesFromWishList(int tenantId) {
        UserDTO tenantDTO = tenantService.getTenantById(tenantId);
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(tenantDTO, tenant);

        wishListRepository.deleteAllByTenantId(tenant);
    }

    public List<WishList> getTenantWishlist(int tenantId) {
        UserDTO tenantDTO = tenantService.getTenantById(tenantId);
        Tenant tenant = new Tenant();
        BeanUtils.copyProperties(tenantDTO, tenant);

        return wishListRepository.findByTenant(tenant);
    }

}
