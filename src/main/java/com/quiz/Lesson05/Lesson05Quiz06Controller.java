package com.quiz.Lesson05;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.model.Store;

@Controller
public class Lesson05Quiz06Controller {
	@Autowired
	private StoreBO storeBO;
	
	@RequestMapping("/store_info")
	public String quiz05(Model model) {
		//selectDB
		List<Store> storeList = storeBO.getStoreList();
		//addModel
		model.addAttribute("storeList", storeList);
		
		return "lesson05/quiz06store";
	}
}
