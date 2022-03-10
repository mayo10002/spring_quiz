package com.quiz.lesson06;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
		return "lesson06/booking_main";
	}
	//예약목록 페이지
	//url : http://localhost/lesson06/reservation_view
	@RequestMapping("/lesson06/reservation_view")
	public String reserveView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		
		model.addAttribute("bookingList", bookingList);
		return "lesson06/get_booking";
	}
}
