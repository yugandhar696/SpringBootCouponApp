package com.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.Coupon;
import com.app.repo.CouponRepository;
import com.app.service.ICouponService;

@Service
public class CouponService implements ICouponService{
	@Autowired
	private CouponRepository repo;
	@Transactional
	public String addCoupon(Coupon c) {

		String code = repo.save(c).getCode();

		return  code;
	}
	@Transactional(readOnly = true)
	public Coupon getCoupon(int cid, String code) {

		Coupon cup = repo.findByIdAndCode(cid, code);
		return cup;

	}
	@Transactional(readOnly = true)
	public List<Coupon> getAllCoupons() {

		List<Coupon> list = repo.findAll();
		return list;
	}
	@Override
	@Transactional(readOnly = true)
	public Coupon getCoupon(String code) {
		return repo.findByCode(code);
	}
}
