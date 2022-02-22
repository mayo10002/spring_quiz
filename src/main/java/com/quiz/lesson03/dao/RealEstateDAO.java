package com.quiz.lesson03.dao;

import org.springframework.stereotype.Repository;

import com.quiz.lesson03.model.RealEstate;



@Repository
public interface RealEstateDAO {
	public RealEstate selectRealEstateById(int id);
	
	public int insertRealEstate(RealEstate realEstate);
	}
