package com.quiz.lesson04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.quiz.lesson04.bo.RealtorBO;
import com.quiz.lesson04.model.Realtor;

@Controller
public class Lesson04Quiz02Controller {

	@Autowired
	private RealtorBO realtorBO;
	// 입력 form URL : http://localhost/lesson04/quiz02/1

	@RequestMapping(path = "/lesson04/quiz02/1", method = RequestMethod.GET)
	public String quiz02_1() {
		return "lesson04/quiz02/add_realtor";
	}

	/// 요청 url: http://localhost/lesson04/quiz02/add_realtor
	@PostMapping("lesson04/quiz02/add_realtor")
	public String addRealtor(@ModelAttribute Realtor realtor, Model model) {
		// DB insert
		realtorBO.addRealtor(realtor);
		// 모델에 담아두기
		realtor = realtorBO.getRealtorById(realtor.getId());
		model.addAttribute("subject", "공인중개사 정보");
		model.addAttribute("result", realtor);

		return "lesson04/quiz02/after_add_realtor";
	}
}
