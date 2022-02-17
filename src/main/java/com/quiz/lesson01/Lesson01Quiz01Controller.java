package com.quiz.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.stereotype.Controller;

@RequestMapping("/quiz/lesson01/quiz01")
@Controller
public class Lesson01Quiz01Controller {
	@RequestMapping("/0")
	public String helloworld() {
		return "HelloWorld!";
	}
	
	// http://localhost:8080/lesson01/quiz01/1
	@ResponseBody
	@RequestMapping("/1")
	public String TestProject() {
		return "<h2>테스트 프로젝트 완성</h2>해당 프로젝트를 통해서 문제 풀이를 진행합니다.";
		
	}
	@ResponseBody
	@RequestMapping("/2")
	public Map<String, Object> quiz1_3() {
		
		Map <String, Object> map = new HashMap<>();
		map.put("국어", 80);
		map.put("영어", 90);
		map.put("수학", 85);
		
		return map;
	}
}

