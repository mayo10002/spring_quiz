package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.bo.SellerBO;
import com.quiz.lesson04.model.Seller;

@Controller
public class Lesson04Quiz01Controller {
	// 판매자 추가 화면
	// 요청: http://localhost/lesson04/quiz01/1
	@RequestMapping(path = "/lesson04/quiz01/1", method = RequestMethod.GET)
	public String quiz01() {
		// /WEB-INF/jsp/ .jsp <= application.properties에서 설정해줘서 원래 주소에서 생략 가능한 부분
		// //WEB-INF/jsp/lesson04/add_user.jsp <=원래 써야 하는 주소
		return "lesson04/add_seller"; // view 경로

	}

	// 입력 form URL : http://localhost/lesson04/quiz01/1
	@Autowired
	private SellerBO sellerBO;

	@PostMapping("/lesson04/quiz01/add_seller")
	public String addSeller(@RequestParam("nickname") String nickname,
			@RequestParam(value = "profileImageUrl", required = false) String profileImageUrl,
			@RequestParam("temperature") double temperature) {

		// insert DB
		sellerBO.addSellerAsField(nickname, profileImageUrl, temperature);
		// jsp 경로와 연결
		return "lesson04/after_add_seller";
	}

	// 가장 최근에 입력된 seller 가져오기
	// 요청 URL: http://localhost/lesson04/quiz01/seller_info
	@GetMapping("/lesson04/quiz01/seller_info")
		public String getSellerView(Model model) {
			Seller seller = sellerBO.getLastSeller();
			model.addAttribute("result", seller);
			model.addAttribute("subject", "판매자 정보");
			return "lesson04/seller_info";
		}

}
