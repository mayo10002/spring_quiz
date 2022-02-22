package com.quiz.lesson03;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.bo.RealEstateBO;
import com.quiz.lesson03.model.RealEstate;

@RequestMapping("/lesson/quiz01")
@RestController
public class Lesson03Quiz01RestController {
	// http://localhost/lesson03/quiz01/1?id=20
	private RealEstateBO realEstateBO;

	@RequestMapping("/1")
	public RealEstate quiz01(@RequestParam(value = "id") int id) {
		return realEstateBO.getRealEstateById(id);
	}
	
	
}
