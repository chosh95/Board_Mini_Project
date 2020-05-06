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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <c:import url="/WEB-INF/views/include/top_menu.jsp"/>

        <div class="container" style="margin-top:100px">
            <div class="row">
                <div class="col-sm-2"></div>
                <div class="col-sm-9">
                    <div class="card shadow">
                        <div class="card-body">
                            <form action="modify_user.html" method="post">
                            <div class="form-group">
                                <label for="user_name">이름</label>
                                <input type="text" id="user_name" name="user_name" class="form-control" value="홍길동" disabled="disabled"/>
                            </div>
                            <div class="form-group">
                                <label for="user_id">아이디</label>
                                <input type="text" id="user_id" name="user_id" class="form-control" value="abc" disabled="disabled"/>
                            </div>
                            <div class="form-group">
                                <label for="user_email">이메일</label>
                                <input type="text" id="user_email" name="user_email" class="form-control"/>
                            </div>
                            <div class="form-group">
                                <label for="user_nickname">닉네임</label>
                                <div class="input-group">
                                    <input type="text" id="user_nickname" name="user_nickname" class="form-control"/>
                                    <div class="input-group-append">
                                        <button type="button" class="btn btn-dark">중복확인</button>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="user_pw">비밀번호</label>
                                <input type="password" id="user_pw" name="user_pw" class="form-control" value="1234"/>
                            </div>
                            <div class="form-group">
                                <label for="user_pw2">비밀번호 확인</label>
                                <input type="password" id="user_pw2" name="user_pw2" class="form-control" value="1234"/>
                            </div>
                            <div class="form-group">
                                <div class="text-right">
                                    <button type="submit" class="btn btn-primary">정보수정</button>
                                </div>
                            </div>
                            
                            </form>
                        </div>
                    </div>
                </div>
                <div class="col-sm-3"></div>
            </div>
        </div>

        <c:import url="/WEB-INF/views/include/footer.jsp"/>
    </body>
</html>