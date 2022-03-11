<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

	<section class="container col-8">
		<h3>예약 하기</h3>
		<div class="form-group">
			<label for="name"><b>이름</b></label><br>
			<input type="text" id="name" name="name" class="form-control col-12 mb-2">
		</div>
		<div class="form-group">
			<label for="date"><b>예약날짜</b></label><br>
			<input type="text" id="date" name="date" class="form-control col-12 mb-2">
		</div>
		<div class="form-group">
			<label for="day"><b>숙박일수</b></label><br>
			<input type="text" id="day" name="day" class="form-control col-12 mb-2">
		</div>
		<div class="form-group">
			<label for="headcount"><b>숙박인원</b></label><br>
			<input type="text" id="headcount" name="headcount" class="form-control col-12 mb-2">
		</div>
		<div class="form-group">
			<label for="phoneNumber"><b>전화번호</b></label><br>
			<input type="text" id="phoneNumber" name="phoneNumber" class="form-control col-12 mb-2">
		</div>
		<button id="reserveBtn" type="btn btn-warning">예약하기</button>
	</section>
	
<script>
	$(document).ready(function() {
		$('input[name=date]').datepicker({
			minDate:0 // 오늘부터 그 뒤 선택
			, dateFormat:'yy-MM-dd"
		});
		$('#reserveBtn').on('click',function(){
			let name= $('input[name=name]').val().trim();
			let date= $('input[name=name]').val().trim();
			let day= $('input[name=name]').val().trim();
			let = $('input[name=headcount]').val().trim();
			let phoneNumber= $('input[name=phoneNumber]').val().trim();
			
			if(name == ''){
				alert('이름을 입력하세요');
				return;
			}
			if(date == ''){
				alert('날짜를 입력하세요');
				return;
			}
			if(day == ''){
				alert('숙박일을 입력하세요');
				return;
			}
			if(isNaN(headcount)){
				alert('인원 수를 입력하세요');
				return;
			}
			if(phoneNumber == ''){
				alert('전화번호를 입력하세요');
				return;
			}
			$.ajax({
				type:"post"
				,url:"/lesson06/quiz03/add_booking"
				,data:{"name":name, "date":date, "day":day, "headcount":headcount, "phoneNumber":phoneNumber}
				,success:function(data){
					if(data.result == 'success'){
						alert("예약 되었습니다.");
						location.href="/lesson06/reservation_view";
					}else{
						alert(data.error_message);
					}
				}
				, error:function(e){
					
					alert("예약 실패. 관리자에게 문의해주세요.");
				}
			});
		});
	});
</script>
