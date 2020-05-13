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
			<c:forEach var='sub_list' items="${list }" varStatus="idx">
			<div class="col-lg-11" style="margin-top: 20px">
				<div class="card shadow">
					<div class="card-body">
						<h4 class="card-title">${board_list[idx.index].board_info_name }</h4>
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
								<c:forEach var='obj' items="${sub_list }">
									<tr>
										<td class="text-center">${obj.content_idx }</td>
										<th><a href='${root }board/main?board_info_idx=${board_list[idx.index].board_info_idx}&content_idx=${obj.content_idx}&page=1'>${obj.content_subject }</a></th>
										<td class="text-center">${obj.content_writer_name }</td>
										<td class="text-center">${obj.content_date }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<a href="${root }board/main?board_info_idx=${board_list[idx.index].board_info_idx}" class="btn btn-info">더보기</a>
					</div>
				</div>
			</div>
			</c:forEach>
		</div>
	</div>
	
	<c:import url="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>