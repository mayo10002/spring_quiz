<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${subject}</title>
</head>
<body>
	<div class="container">
		<h1>${subject}</h1>
		<img src= "${result.profileImageUrl}" width="200">
		<div class="display-2">${result.nickname}</div>
		<span class="text-warning">${result.temperature}</span>
	</div>
</body>
</html>