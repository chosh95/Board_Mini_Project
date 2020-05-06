<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value="${pageContext.request.contextPath}/"/>
<!--게시판 상단 네비게이션-->
<nav class="navbar navbar-expand-md bg-info navbar-light shadow-lg">
	<a class="navbar-brand" href="${root}main">ChoBoard</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navMenu">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class="collapse navbar-collapse" id="navMenu">
		<ul class="navbar-nav">
			<li class="nav-item"><a href="${root}board/main" class="nav-link">자유게시판</a>
			</li>
			<li class="nav-item"><a href="${root}board/main" class="nav-link">정보게시판</a>
			</li>
			<li class="nav-item"><a href="${root}board/main" class="nav-link">맛집게시판</a>
			</li>
			<li class="nav-item"><a href="${root}board/main" class="nav-link">비밀게시판</a>
			</li>
		</ul>

		<ul class="navbar-nav ml-auto">
			<li class="nav-item"><a href="${root}user/login" class="nav-link">로그인</a>
			</li>
			<li class="nav-item"><a href="${root}user/signIn"
				class="nav-link">회원가입</a></li>
			<li class="nav-item"><a href="${root}user/update"
				class="nav-link">회원수정</a></li>
			<li class="nav-item"><a href="${root}user/logout" class="nav-link">로그아웃</a>
			</li>
		</ul>
	</div>
</nav>