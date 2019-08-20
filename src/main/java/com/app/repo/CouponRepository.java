package com.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.model.Coupon;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

@Query(value="from com.app.model.Coupon c where c.cid=:cid and c.code=:code")
public Coupon findByIdAndCode(int cid, String code);
@Query(value="from com.app.model.Coupon c where c.code=:code")
public Coupon findByCode(String code);

}
