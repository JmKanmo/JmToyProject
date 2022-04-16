package com.jmshop.jmshop_admin.controller.rest;

import com.jmshop.jmshop_admin.domain.Coupon;
import com.jmshop.jmshop_admin.service.CouponService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/register", produces = "application/json")
public class CouponController {
    private CouponService couponService;

    public CouponController(CouponService couponService) {
        this.couponService = couponService;
    }

    @PostMapping(path = "/coupon", consumes = "application/json")
    public ResponseEntity<Long> registerCoupon(@RequestBody Coupon coupon) {
        return ResponseEntity.status(HttpStatus.OK).body(couponService.saveCoupon(coupon));
    }
}