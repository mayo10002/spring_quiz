package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	
	// 즐겨찾기 추가하는 화면
	// url: http://localhost/lesson06/quiz01/add_favorite_view
	@RequestMapping("/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/add_new_favorite";
	}
	
	// 즐겨찾기 목록 화면
	// url: http://localhost/lesson06/quiz01/favorite_view
	@RequestMapping("/favorite_view")
	public String favoriteView(Model model) {
		List<Webpage> webpageList = webpageBO.getWebpageList();
		
		//add model
		model.addAttribute("webpageList", webpageList);
		return "lesson06/get_webpage";
	}
	
	// 즐겨찾기 추가 수행 - AJAX가 요청하는 API
	@ResponseBody
	@PostMapping("/add_favorite")
	public Map<String, String> addFavorite(
			@RequestParam("name") String name,
			@RequestParam("url")String url) {
		
		//insert DB
		webpageBO.addNewWebpageAsField(name, url);
		
		// 응답값 구성(Map -> JSON)
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		//return 응답값
		return result;
	}
}
