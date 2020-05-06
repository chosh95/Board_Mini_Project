<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var='root' value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ChoBoard</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
</head>
<body>

	<c:import url="/WEB-INF/views/include/top_menu.jsp"/>
	
	<!-- 게시판 Contents -->
	<div class="container" style="margin-top: 50px">
		<div class="row">
			<div class="col-lg-11" style="margin-top: 20px">
				<div class="card shadow">
					<div class="card-body">
						<h4 class="card-title">자유게시판</h4>
						<table class="table table-hover" id='board_list'>
							<thead>
								<tr>
									<th class="text-center w-25">글번호</th>
									<th>제목</th>
									<th class="text-center w-25">작성자</th>
									<th class="text-center w-25">작성날짜</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-center">5</td>
									<th><a href='${root }board/read'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
								<tr>
									<td class="text-center">5</td>
									<th><a href='board_read.html'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
								<tr>
									<td class="text-center">5</td>
									<th><a href='board_read.html'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
								<tr>
									<td class="text-center">5</td>
									<th><a href='board_read.html'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
								<tr>
									<td class="text-center">5</td>
									<th><a href='board_read.html'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
							</tbody>
						</table>
						<a href="board_main.html" class="btn btn-info">더보기</a>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-11" style="margin-top: 20px">
				<div class="card shadow">
					<div class="card-body">
						<h4 class="card-title">자유게시판</h4>
						<table class="table table-hover" id='board_list'>
							<thead>
								<tr>
									<th class="text-center w-25">글번호</th>
									<th>제목</th>
									<th class="text-center w-25">작성자</th>
									<th class="text-center w-25">작성날짜</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td class="text-center">5</td>
									<th><a href='board_read.html'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
								<tr>
									<td class="text-center">5</td>
									<th><a href='board_read.html'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
								<tr>
									<td class="text-center">5</td>
									<th><a href='board_read.html'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
								<tr>
									<td class="text-center">5</td>
									<th><a href='board_read.html'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
								<tr>
									<td class="text-center">5</td>
									<th><a href='board_read.html'>제목입니다</a></th>
									<td class="text-center">작성자</td>
									<td class="text-center">2018-12-12</td>
								</tr>
							</tbody>
						</table>
						<a href="board_main.html" class="btn btn-info">더보기</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<c:import url="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>