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

@Controller
public class Lesson06Quiz01Controller {
	@Autowired
	private WebpageBO webpageBO;
	
	// 즐겨찾기 추가하는 화면
	// url: http://localhost/lesson06/quiz01/add_favorite_view
	@RequestMapping("/lesson06/quiz01/add_favorite_view")
	public String addFavoriteView() {
		return "lesson06/add_new_favorite";
	}
	
	// 즐겨찾기 목록 화면
	// url: http://localhost/lesson06/quiz01/favorite_view
	@RequestMapping("/lesson06/quiz01/favorite_view")
	public String favoriteView(Model model) {
		List<Webpage> webpageList = webpageBO.getWebpageList();
		
		//add model
		model.addAttribute("webpageList", webpageList);
		return "lesson06/get_webpage";
	}
	
	// 즐겨찾기 추가 수행 - AJAX가 요청하는 API
	@ResponseBody
	@PostMapping("/lesson06/quiz01/add_favorite")
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
	
	//quiz02
	@ResponseBody
	@PostMapping("/lesson06/quiz02/check_duplication_url")
	public Map<String, Boolean> checkDuplicationUrl(
			@RequestParam("url")String url){
		Map<String, Boolean> result= new HashMap<>();
		Webpage webpage = webpageBO.getWebpageByUrl(url);
		
		if(webpage == null) { // 중복 아님
			result.put("result", false);
		}else {
			// 중복일 때 
			result.put("result", true);
		}
		return result;
	}
	
	//quiz02-2
	@ResponseBody
	@PostMapping("/lesson06/quiz02/delete_favorite")
	public Map<String, String> deleteFavorite(
			@RequestParam("id")int id){
		Map<String, String> result = new HashMap<>();
		result.put("result", "success");
		
		// TODO delete DB
		int row = webpageBO.deleteWebpageById(id);
		if(row > 0 ) {
			result.put("result", "success");
		}else {
			result.put("result","error");
			result.put("errorMessage", "삭제하는 데 실패했습니다.");
		}
		return result;
	}
	
}
