package com.app.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Coupon;
import com.app.service.ICouponService;

@RestController
@RequestMapping("coupon")
@RefreshScope
public class CouponRestController {
	@Autowired
	private ICouponService service;

	@PostMapping("addCoupon")
	public String createCoupon(@RequestBody Coupon cup) {
		return "Coupon created successfully : " + service.addCoupon(cup);

	}

	@GetMapping("getCoupon/{cid}/{code}")
	public Coupon findCoupon(@PathVariable int cid, @PathVariable String code) {

		Coupon c = service.getCoupon(cid, code);
		return c;
	}
	@GetMapping("getCoupon/{code}")
	public Coupon getCouponByCode(@PathVariable String code) {

		Coupon c = service.getCoupon(code);
		return c;
	}
	@GetMapping("all")
	public List<Coupon> getAllCoupons() {
		List<Coupon> list = service.getAllCoupons();
		return list;
	}
}
