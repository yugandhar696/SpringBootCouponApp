package com.app.service;

import java.util.List;

import com.app.model.Coupon;

public interface ICouponService {
	public String addCoupon(Coupon c) ;
	public Coupon getCoupon(int cid, String code) ;
	public Coupon getCoupon(String code) ;
	public List<Coupon> getAllCoupons() ;
}
