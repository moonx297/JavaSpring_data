<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<head>
<title>JSONTest</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>  
<script>
  $(function() {
      $("#checkJson").click(function() {		//그러면 이 기능을 실행해라. 박지성의 정보를 보여줘라.
      	var member = { id:"park", 
  			    name:"박지성",
  			    pwd:"1234", 
  			    email:"park@test.com" };
  	$.ajax({
        type:"post",
        url:"${contextPath}/test/info",
        contentType: "application/json",
        data :JSON.stringify(member),
     success:function (data,textStatus){
     },
     error:function(data,textStatus){
        alert("에러가 발생했습니다.");
     },
     complete:function(data,textStatus){
     }
  });  //end ajax	

   });
});
</script>
</head>
<body>
  <input type="button" id="checkJson" value="회원 정보 보내기"/><br><br>	<!-- 버튼을 누르면 checkJson을 눌러라 -->
  <div id="output"></div>
</body>
</html>