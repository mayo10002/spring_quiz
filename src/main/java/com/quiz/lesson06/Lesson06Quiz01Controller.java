package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.WebpageBO;
import com.quiz.lesson06.model.Webpage;

@RequestMapping("/lesson06/quiz01")
@Controller
public class Lesson06Quiz01Controller {
	@Autowired
	private WebpageBO webpageBO;
	// url: https://localhost/lesson06/quiz01/favorite_view
	@RequestMapping("/favorite_view")
	public String favoriteView(Model model) {
		List<Webpage> webpageList = webpageBO.getWebpageList();
		
		//add model
		model.addAttribute("webpageList", webpageList);
		return "lesson06/get_webpage";
		
	}
	@RequestMapping("/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/add_new_favorite";
	}
	
	@ResponseBody
	@PostMapping("/add_favorite")
	public String addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url")String url) {
		
		
		//insert DB
		webpageBO.addNewWebpageAsField(name, url);
		
		return "redirect:lesson06/favorite_view";
		
		
	}
}
