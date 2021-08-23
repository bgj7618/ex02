<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Custom fonts for this template -->
    <link href="../resources/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this template -->
    <link href="../resources/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="../resources/css/dataTables.bootstrap4.min.css" rel="stylesheet">
    
    
     
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get">
		<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
			<tr>
				<td>번호</td><td>제목</td><td>작성자</td><td>작성일</td><td>수정일</td>
			</tr>
			<!-- model.addAttribute("list", service.getList()); 여기서 "list"가 아래의 items list이다 -->
			<c:forEach items="${list}" var="board">	<!-- list의 0번째 것을 board에 저장하여 뿌리고 순차적실행. -->
				<tr>
					<td>${board.bno}</td>
					<td><a href="get?bno=${board.bno}">${board.title}</a>[${board.replycnt}]</td>
					<td>${board.writer}</td>
					<td>${board.regdate}</td>
					<td>${board.updateDate}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5"><input type="submit" value="글쓰기" formaction="register"></td>
			</tr>
		</table>
	</form>
	
	<div class="pull-right">
		<ul class="pagination">
			<c:if test="${pageMaker.prev }">
				<li class="pagenate_button previous"><a href="list?pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}">Previous</a></li>
			</c:if>
			<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
				<li class="pagenate_button"><a href="list?pageNum=${num}&amount=${pageMaker.cri.amount}">${num}</a></li>
			</c:forEach>
			<c:if test="${pageMaker.next}">
				<li class="pagenate_button next"><a href="list?pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}">Next</a></li>
			</c:if>
		</ul>
	</div>
	
	<div>
		<form action="list" method="get">
			<input type="text" name="pageNum" value="${pageMaker.cri.pageNum }">
			<input type="text" name="amount" value="${pageMaker.cri.amount }">
			<select name="type">
				<option value="">--</option>			
				<option value="TC">제목 or 내용</option>			
				<option value="TW">제목 or 작성자</option>			
				<option value="CW">내용 or 작성자</option>			
				<option value="TCW">제목 or 내용 or 작성자</option>			
			</select>
			<input type="text" name="keyword">
			
			<input type="submit" value="검색">
		</form>
	</div>











    <!-- Bootstrap core JavaScript-->
    <script src="../resources/js/jquery.min.js"></script>
    <script src="../resources/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="../resources/js/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="../resources/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="../resources/js/jquery.dataTables.min.js"></script>
    <script src="../resources/js/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="../resources/js/datatables-demo.js"></script>
</body>
</html>