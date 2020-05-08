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
    <body>
        <c:import url="/WEB-INF/views/include/top_menu.jsp"/>

        <!--로그인-->
        <div class="container" style="margin-top:100px">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-9">
                    <div class="card shadow">
                        <div class="card-body">
                        	<c:if test="${fail==true}">
                            <div class="alert alert-danger">
                                <h4>로그인 실패</h4>
                                <p>아이디 또는 비밀번호를 확인해주세요</p>
                            </div>
                            </c:if>
                            <form:form action="${root }user/login_pro" method="post" modelAttribute="tempLoginUserBean">
                                <div class="form-group">
                                    <form:label path="user_id">아이디</form:label>
                                    <form:input path="user_id" class="form-control"/>
                                    <form:errors path="user_id" style="color:red"/>
                                </div>
                                <div class="form-group">
                                    <form:label path="user_pw">비밀번호</form:label>
                                    <form:password path="user_pw" class="form-control"/>
                                    <form:errors path="user_pw" style="color:red"/>
                                </div>
                                <div class="form-group text-right">
                                    <form:button class="btn btn-primary">로그인</form:button>
                                    <a href="${root }user/signIn" class="btn btn-danger">회원가입</a>
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