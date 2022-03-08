<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script> 
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가</h1>
		<div class="form-group">
			<label for="">제목</label>
			<input type="text" id="name" class="form-control">
		</div>
		<div class="form-group">
			<label for="">주소</label>
			<input type="text" id="url" class="form-control">
			<button type="button" id="urlCheckBtn" class="btn btn-info">중복확인</button>
		</div>
		<small id="statusArea"></small>
		<button type="button" id="addUrlBtn" class="btn btn-success">추가</button>
	</div>
	
<script>
	$(document).ready(function(){
		$('#urlCheckBtn').on('click', function(e){
			$('#statusArea').empty();
			
			let url = $('#url').val().trim();
			if(url == ''){
				$('#statusArea').append('<span class="text-danger">주소가 비어있습니다.</span>')
				return;
			}
			$.ajax({
				type:"GET"
				, url:"/lesson06/quiz02/is_duplication"
				, data:{"url":url}
				, success:function(data){
					
				}
			});
		});
	});
</script>
</body>
</html>