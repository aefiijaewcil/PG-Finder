package com.pgfinder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgfinder.entities.Tenant;
import com.pgfinder.entities.WishList;
import com.pgfinder.repositories.WishListRepository;

@Service
public class WishListService {

    @Autowired
    private WishListRepository wishListRepository;

    @Autowired
    private TenantService tenantService;

    public void addPropertyToWishList(int tenantId, int propertyId) {
        Tenant tenant = tenantService.getTenantById(tenantId);

        WishList wishList = new WishList();
        wishList.setPropertyId(propertyId);
        wishList.setTenant(tenant);

        wishListRepository.save(wishList);
    }

    public void removePropertyFromWishList(int wishlistId) {
        wishListRepository.deleteById(wishlistId);
    }

    public void removeAllPropertiesFromWishList(int tenantId) {
        Tenant tenant = tenantService.getTenantById(tenantId);

        wishListRepository.deleteAllByTenantId(tenant);
    }

    public List<WishList> getTenantWishlist(int tenantId) {
        Tenant tenant = tenantService.getTenantById(tenantId);
        return wishListRepository.findByTenant(tenant);
    }

}
