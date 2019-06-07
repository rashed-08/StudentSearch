package com.web.student.search.daoServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.student.search.daoImpl.PromoCodeDaoImpl;
import com.web.student.search.daoService.PromoCodeDaoService;
import com.web.student.search.dto.PromoCode;

@Service
public class PromoCodeDaoServiceImpl implements PromoCodeDaoService {

	@Autowired
	private PromoCodeDaoImpl promoCodeDao;

	@Override
	public void createPromoCode(PromoCode promoCode) {
		promoCodeDao.createPromoCode(promoCode);
	}

	@Override
	public List<PromoCode> getAllPromoCode() {
		List<PromoCode> getAllPromoCode = promoCodeDao.getAllPromoCode();
		return getAllPromoCode;
	}

	@Override
	public PromoCode getPromoCode(String promoCode) {
		PromoCode getPromoCode = promoCodeDao.getPromoCode(promoCode);
		return getPromoCode;
	}

}
