package com.web.student.search.daoService;

import java.util.List;

import com.web.student.search.dto.PromoCode;

public interface PromoCodeDaoService {

	public void createPromoCode(PromoCode promoCode);
	public List<PromoCode> getAllPromoCode();
	public PromoCode getPromoCode(String promoCode);
}
