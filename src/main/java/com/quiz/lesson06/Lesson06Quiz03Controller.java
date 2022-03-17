package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.bo.BookingBO;
import com.quiz.lesson06.model.Booking;

@Controller
public class Lesson06Quiz03Controller {
	@Autowired
	private BookingBO bookingBO;
	//대문화면 불러오기
	//url : http://localhost/lesson06/pansion_main
	@RequestMapping("/lesson06/pansion_main")
	public String bookingMain() {
		return "lesson06/quiz03/main_template";
	}
	
	//예약하기 - ajax호출
	@ResponseBody
	@PostMapping("/add_booking")
	public Map<String, Object> addBooking(
			@RequestParam("name") String name,
			@RequestParam("date") String date,
			@RequestParam("day") int day,
			@RequestParam("headcount") int headcount,
			@RequestParam("phoneNumber") String phoneNumber
			){
		Map<String, Object> result = new HashMap<>();
		//DB insert
		int count =bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		if(count > 0) {
			result.put("result", "success");
		}else {
			result.put("result", "error");
			result.put("error_message","예약에 실패했습니다.");
		}
		 
		return result;
	}
	//예약목록 페이지
	//url : http://localhost/lesson06/reservation_view
	@RequestMapping("/lesson06/reservation_view")
	public String reserveView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		return "lesson06/quiz03/list_content";
	}
	
	///예약 삭제하기
	@ResponseBody
	@DeleteMapping("/lesson06/delete_booking")
	public Map<String, Object>deleteBooking(
			@RequestParam("id") int id){
		Map<String, Object> result = new HashMap<>();
		
		//TODO delete DB
		
		int count = bookingBO.deleteBookingById(id);
		if(count > 0) {
			result.put("result", "success");
			result.put("result_code",1);
		}else {
			result.put("result", "error");
			result.put("result_code",500);
			result.put("error_message","삭제가 실패했습니다.");
			
		}
		return result;
	}
	
	//예약 조회기능 - ajax
	@ResponseBody
	@PostMapping("/lesson06/quiz04/search_reservation")
	public Map<String, Object> searchReservation(
			@RequestParam("name") String name,
			@RequestParam("phoneNumber") String phoneNumber){
		Map<String,Object> result = new HashMap<>();
		
		//select DB
		Booking booking = bookingBO.getBookingByNameAndPhoneNumber(name, phoneNumber);
		if (booking != null) {
			// result 맵 : {"result": "success", "booking":{"id":13,"name":"예약자"...}}
			
			result.put("result","success");
			result.put("booking", booking);
		}else {
			result.put("result","error");
			result.put("errorMessage", "예약 정보가 없습니다.");
		}
		
		return result;
	}
}
