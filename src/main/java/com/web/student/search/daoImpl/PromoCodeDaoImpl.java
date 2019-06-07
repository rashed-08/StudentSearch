package com.web.student.search.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.student.search.dao.PromoCodeDao;
import com.web.student.search.dto.PromoCode;
import com.web.student.search.repository.PromoCodeRepository;

@Repository
public class PromoCodeDaoImpl implements PromoCodeDao {

	@Autowired
	private PromoCodeRepository promoCodeRepository;
	
	@Override
	public List<PromoCode> getAllPromoCode() {
		List<PromoCode> getAllPromoCode = (List<PromoCode>) promoCodeRepository.findAll();
		return getAllPromoCode;
	}

	@Override
	public void createPromoCode(PromoCode promoCode) {
		promoCodeRepository.save(promoCode);
	}

	@Override
	public PromoCode getPromoCode(String promoCode) {
		PromoCode getPromoCode = promoCodeRepository.findByPromoCodeName(promoCode);
		return getPromoCode;
	}

}
