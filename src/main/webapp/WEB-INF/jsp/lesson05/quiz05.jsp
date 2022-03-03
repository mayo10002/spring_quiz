<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>날씨 문제</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/quiz05style.css" type="text/css">

<!-- <style>
nav{width:250px; height:800px; }
section{height:800px;}
footer{height:100px;}

.nav-font{color:white; font-weight:bold;}
</style> -->
</head>
<body>
	<div class="container bg-warning">
		<div class="d-flex bg-info">
			<nav class="bg-primary col-3">
				<img src="/image/logo.png" alt="기상청 로고" width="100">
				<br>
				<ul class="nav flex-column">
					<li class="nav-item"><a href="#" class="nav-link nav-font">날씨</a></li>
					<li class="nav-item"><a href="#" class="nav-link nav-font">날씨입력</a></li>
					<li class="nav-item"><a href="#" class="nav-link nav-font">테마날씨</a></li>
					<li class="nav-item"><a href="#" class="nav-link nav-font">관측 기후</a></li>
				</ul>
			</nav>
			<section class="bg-white col-9 container">
				<h3>과거 날씨</h3>
				<table class="table text-center">
					<thead>
						<tr>
							<th>날짜</th>
							<th>날씨</th>
							<th>기온</th>
							<th>강수량</th>
							<th>미세먼지</th>
							<th>풍속</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
			</section>
		</div>
			
		<footer class=" d-flex">
			<div class="col-3"></div>
			<div class="col-9">(07062) 서울특별시 동작구 여의대방로16길 61<br>
			Copyright@2022 KMA. All Rights RESERVED. </div>
		</footer>
	</div>
</body>
</html>