<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배탈의 민족</title>
<!-- bootstrap CDN link -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="/css/quiz06style.css" type="text/css">

</head>
<body>
	<div class="container">
		<header class="bg-info header-font d-flex justify-content">
			배탈의 민족
		</header>
		<section>
			<div class="display-4">우리동네 가게</div>
			<c:forEach items="${storeList}" var="store">
				<a href="#" class="box-text">
					<div class="store-box">
						<span class="store-name">${store.name}</span><br>
						<span class="store-info">
							전화 번호: ${store.phoneNumber}<br>
							주소: ${store.address}
						</span>
					</div>
				</a>
			</c:forEach>
		</section>
		<footer>
			<hr>
			<span class="footer-font1">(주)우와한형제</span><br>
			<span class="footer-font2">고객센터:1500-1500</span>
		</footer>
	</div>
</body>
</html>