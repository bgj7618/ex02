<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="../resources/js/register.js"></script>
<title>글쓰기</title>
</head>
<body>
	<div id="wrap">
		<h1>게시글 작성</h1>
		<form role="form" action="register" method="post">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" name="title" placeholder="제목 입력"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><textarea cols="20" rows="10" name="content" placeholder="내용 입력"></textarea></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" name="writer" placeholder="작성자 입력"></td>
				</tr>
				<tr>
					<td><input type="submit" value="글쓰기"></td>
					<td><input type="submit" value="글목록"></td>
				</tr>
			</table>
			<div>
				<input type="file" name="uploadFile" multiple>
			</div>
			<div class="uploadResult">
				<ul>
				
				</ul>
			</div>
		</form>
	</div>
</body>
</html>