<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<section class="bg-primary d-flex justify-content-center align-items-center">
	<h2>예약 목록 보기</h2>
	<table class="table text-center">
		<thead>
			<tr>
				<th>이름</th>
				<th>예약날짜</th>
				<th>숙박일수</th>
				<th>숙박인원</th>
				<th>전화번호</th>
				<th>예약상태</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bookingList}" var="list">
				<tr>
					<td>${list.name}</td>
					<td><fmt:formatDate value="${list.date}" pattern="yyyy년 M월 d일"/>
					<td>${list.day}</td>
					<td>${list.headcount}</td>
					<td>${list.phoneNumber}</td>
					<td>
						<c:choose>
							<c:when test= "${list.state eq '대기중'}">
								<span class="text-info">${list.state}</span>
							</c:when>
							<c:when test= "${list.state eq '확정'}">
								<span class="text-success">${list.state}</span>
							</c:when>
							<c:otherwise>
								${list.state}
							</c:otherwise>
						</c:choose>
					
					</td>
					<td>
						<button type="button" class="delBtn btn btn-danger" data-list-id="${list.id}">삭제</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</section>
<script>
	$(document).ready(function(){
		$('.delBtn').on('click',function(e){
		
			
			var listId = $(this).data('list-id');
			
			$.ajax({
				type:'DELETE'
				, url:'/lesson06/quiz03/delete_booking'
				,data:{"id": list_id}
				
			
			//response
			, success: functnio(data){
				if(data.result_code == 1) {
					alert("삭제되었습니다.");
					location.reload();
				
				} else{
					alert(data.error_message);
				}
			},
			error:function(e){
				alert("삭제에 실패했습니다.");
			}
			});
		});
	});
</script>