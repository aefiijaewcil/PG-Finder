package com.pgfinder.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pgfinder.entities.WishList;
import com.pgfinder.services.WishListService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/wishlists")
public class WishListController {

    @Autowired
    private WishListService wishListService;

    @GetMapping("/all")
    public List<WishList> getAllWishList(@RequestParam int tenantId) {
        return wishListService.getTenantWishlist(tenantId);
    }

    @PostMapping("/add")
    public void addPropertyToWishList(@RequestParam int tenantId, @RequestParam int propertyId) {
        wishListService.addPropertyToWishList(tenantId, propertyId);
    }

    @DeleteMapping("/removeproperty")
    public void removePropertyFromWishList(@RequestParam int wishListId) {
        wishListService.removePropertyFromWishList(wishListId);
    }

    @DeleteMapping("/removeallproperties")
    public void removeAllPropertiesFromWishList(@RequestParam int tenantId) {
        wishListService.removeAllPropertiesFromWishList(tenantId);
    }

}
