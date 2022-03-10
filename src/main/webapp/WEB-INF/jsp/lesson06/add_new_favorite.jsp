<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기 추가하기</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script> 
   <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h1>즐겨찾기 추가하기</h1>
		<div class="form-group">
			<label for="name">제목</label><br>
			<input type="text" id="name" class="form-control col-12 mb-2" placeholder="제목을 입력하세요.">
		</div>
		<div class="form-group">
			<label for="">주소</label>
			<div class="form-inline">
				<input type="text" id="url" class="form-control">
				<button type="button" id="checkDuplicationBtn" class="btn btn-info">중복확인</button>
			</div>
		</div>
		<small id="duplicationText" class="text-danger d-none">중복된 url입니다.</small>
		<small id="availableUrlText" class="text-success d-none">저장 가능한 url입니다.</small>
			<button type="button" id="addBtn" class="btn btn-success btn-block">추가</button>
		
	</div>
</body>

<script>
	$(document).ready(function(){
		$('#addBtn').on('click',function(e){
			//alert("추가 버튼 클릭");
			
			//validation
			let name = $('#name').val().trim();
			if(name.length < 1){
				alert("제목을 입력하세요");
				return;
			}
			
			
			let url = $('#url').val().trim();
			if(url == ''){
				alert("주소를 입력하세요");
				return;
			}
			if(url.startsWith("http") == false && url.startsWith("https") == false){
				alert("주소 형식이 잘못되었습니다.");
				return;
			}
			
			$.ajax({
				
				//request
				type:"post"
				, url:"/lesson06/quiz01/add_favorite"
				, data: {"name":name, "url":url}
				
				//response
				, success: function(data){ // url에서 리턴된 json String을 object로 변환해준다.(jquery ajax 함수가)
					if(data.result == "success"){
						location.href="/lesson06/quiz01/favorite_view";
					}
					//alert(data.result);
					
				}
				, complete: function(data){
					alert("완료");
				}
				, error: function(e){
					alert("에러, " + e); // 통신 실패 시 [Object object]
				}
				
				
				
			});
			
		})
		$('#checkDuplicationBtn').on('click', function(e){
			
			let url = $('#url').val().trim();
			if(url == ''){
				alert("검사할 URL을 입력해주세요");
				return;
			}
			
			$.ajax({
				type:"post"
				, url:"/lesson06/quiz02/check_duplication_url"
				, data:{"url":url}
				, success:function(data){
					if (data.result){
						//중복일 때
						$('#duplicationText').removeClass('d-none');
						$('#availableUrlText').addClass('d-none');
					}else{
						//중복 아닐 때 -> 사용 가능
						$('#availableUrlText').removeClass('d-none');
						$('#duplicationText').addClass('d-none');
					}
					
				}
				, error:function(e){
					alert("중복 확인에 실패했습니다. 관리자에게 문의해주세요.");
				}
			});
		});
	})
</script>
</html>