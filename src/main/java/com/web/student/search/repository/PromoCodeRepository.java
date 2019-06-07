package com.web.student.search.repository;

import org.springframework.data.repository.CrudRepository;

import com.web.student.search.dto.PromoCode;

public interface PromoCodeRepository extends CrudRepository<PromoCode, Integer> {
	
	public PromoCode findByPromoCodeName(String promoCodeName);

}
