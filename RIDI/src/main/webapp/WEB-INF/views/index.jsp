<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp"%>
	<h1 style='text-align:center; padding: 300px 0px;'>RIDI Main Page!!!</h1>
	<form action="MemberModify.do" method="POST">
		<div>ID<input type="text" name="id" value="${loggedMember.id}" disabled></div>
		<div>이름<input type="text" name="name" value="${loggedMember.name}" disabled></div>
		<div>비밀번호<input type="text" name="wishPassword"></div>
		<div>주민등록번호<input type="text" name="RRN" value="${loggedMember.RRN}" disabled></div>
		<div>이메일<input type="text" name="email" value="${loggedMember.email}"></div>
		<div>성별<input type="text" name="gender" value="${loggedMember.gender}" disabled></div>
		<div>zipcode<input type="text" name="zipcode" value="${loggedMember.zipcode}"></div>
		<div>address<input type="text" name="address" value="${loggedMember.address}"></div>
		<div>HP<input type="text" name="hp" value="${loggedMember.hp}"></div>
		<div>가입일<input type="text" name="creation_Date" value="${loggedMember.creation_Date}" disabled></div>
		<input type="submit" value="정보수정">
	</form>
<%@ include file="include/footer.jsp"%>