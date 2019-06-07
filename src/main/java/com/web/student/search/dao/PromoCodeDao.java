package com.web.student.search.dao;

import java.util.List;

import com.web.student.search.dto.PromoCode;

public interface PromoCodeDao {

	public void createPromoCode(PromoCode promoCode);
	public List<PromoCode> getAllPromoCode();
	public PromoCode getPromoCode(String promoCode);
}
