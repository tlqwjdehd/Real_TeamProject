<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="ud" class="com.sist.member.model.MemberModel"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>

</head>
<body>
	<div id="news_area">
  <div id="wrapper1">
   <form id="joinForm" action="infoUpdate_ok.jsp" name="updateForm" method=POST>
    <p>
    <label for="userid">아이디</label>
    ${sessionScope.id }
    <!-- <input type=text name=mem_id id="userid" readonly required> -->
    
    
    </p>
    <p>
    <label for="userpwd">비밀번호</label>
    <input type=password name=mem_pw id="userpwd" required>
    <input type=password name=pwd1 id="userpwd1" placeholder="재입력" required>
    </p>
    <p>
    <label for="username">이름</label>
    ${sessionScope.name }
    <!-- <input type=text name=mem_name id="username" required> -->
    </p>
    <p>
    <label for="usersex">성별</label>
    <input type=radio name=mem_sex value="남자" checked>남자
    <input type=radio name=mem_sex value="여자">여자
    </p>
    <p>
    <label for="userdate" id=mem_birth name="birth">생년월일</label>
     	<input type=date name="mem_birth" id="userdate" required>
    </p>
    <p>
    <label for="useremail">이메일</label>
    
     <input type=text name="mem_email" id="useremail" >
    </p>

    <p>
    <label>전화</label>
    <span class="cellStyle">
     <select id="userPhone" name="mem_phone1">
      <option>010</option>
      <option>011</option>
      <option>017</option>
     </select>
     -
     <input type=text id="userPhone1" name="mem_phone2">
     -
     <input type=text id="userPhone2" name="mem_phone3">
    </span>
    </p>
    <p class="btnSubmit">
     <input type=submit id="btnSub" value="수정">
     <input type=button id="btnCan" value="취소"
      onclick="javascript:history.back()">
    </p>
   </form>
  </div>
  </div>
</body>
</html>