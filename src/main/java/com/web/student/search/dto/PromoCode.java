package com.web.student.search.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="promo_code")
public class PromoCode {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(name="promo_code_name")
	private String promoCodeName;
	
	public PromoCode() {
		
	}
	
	
	public PromoCode(int id, String promoCodeName) {
		this.id = id;
		this.promoCodeName = promoCodeName;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPromoCodeName() {
		return promoCodeName;
	}
	public void setPromoCodeName(String promoCodeName) {
		this.promoCodeName = promoCodeName;
	}
	
}
