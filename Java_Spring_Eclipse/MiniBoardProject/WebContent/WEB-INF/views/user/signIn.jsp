<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var='root' value="${pageContext.request.contextPath}/"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>ChoBoard</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    </head>
    <script>
	function checkUserIdExist(){
		
		var user_id = $("#user_id").val()
		
		if(user_id.length == 0 ){
			alert('아이디를 입력해주세요')
			return
		}
		$.ajax({
			url : '${root}user/checkUserIdExist/' + user_id,
			type : 'get',
			dataType : 'text',
			success : function(result){
				if(result.trim()=='true'){
					alert('사용할 수 있는 아이디입니다.')
					$("#userIdExist").val('true')
				}
				else{
					alert('사용할 수 없는 아이디입니다.')
					$("#userIdExist").val('false')
				}
			}
		})
	}
	
	function resetUserIdExist(){
		$("#userIdExist").val('false')
	}
	
	</script>
    <body>
        <c:import url="/WEB-INF/views/include/top_menu.jsp"/>

        <div class="container" style="margin-top:100px">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-9">
                    <div class="card shadow">
                        <div class="card-body">
                        	<form:form action="${root }user/signIn_pro" method="post" modelAttribute="signInUserBean">
                        		<form:hidden path="userIdExist"/>
                                <div class="form-group">
                                	<form:label path="user_name">이름</form:label>
                                	<form:input path="user_name" class="form-control"/>
                                	<form:errors path="user_name" style='color:red'/>
                                </div>
                                <div class="form-group">
                                	<form:label path="user_id">아이디</form:label>
                                    <div class="input-group">
                                        <form:input path="user_id" class="form-control" onkeypress="resetUserIdExist()"/>
                                        <div class="input-group-append">
                                        	<button type="button" class="btn btn-dark" onclick="checkUserIdExist()">중복확인</button>
                                        </div>
                                    </div>
                                    <form:errors path="user_id" style='color:red'/>
                                </div>
                                <div class="form-group">
                                	<form:label path="user_email">이메일</form:label>
                                	<form:input path="user_email" class="form-control"/>
                                	<form:errors path="user_email" style='color:red'/>
                                </div>
                                <div class="form-group">
                                	<form:label path="user_nickname">닉네임</form:label>
                                    <div class="input-group">
                                        <form:input path="user_nickname" class="form-control"/>
                                        <div class="input-group-append">
                                            <button type = "button" class="btn btn-dark">중복확인</button>
                                        </div>
                                    </div>
                                    <form:errors path="user_nickname" style='color:red'/>
                                </div>
                                <div class="form-group">
                                    <form:label path="user_pw">비밀번호</form:label>
                                    <form:password path="user_pw" class="form-control"/>
                                    <form:errors path="user_pw" style='color:red'/>
                                </div>
                                <div class="form-group">
                                    <form:label path="user_pw2">비밀번호 확인</form:label>
                                    <form:password path="user_pw2" class="form-control"/>
                                    <form:errors path="user_pw2" style='color:red'/>
                                </div>
                                <div class="form-group">
                                    <div class="text-md-right">
                                    	<form:button class="btn btn-primary">회원가입</form:button>
                                    	<a href="${root }user/signIn_cancel" class="btn btn-danger">취소</a>
                                    </div>
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>

        <c:import url="/WEB-INF/views/include/footer.jsp"/>
    </body>
</html>