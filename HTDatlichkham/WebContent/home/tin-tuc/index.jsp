<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<jsp:include flush="true" page="/home/header.jsp"></jsp:include>
<script language="javascript" type="text/javascript"
	src="${pageContext.request.contextPath}/home/js/jquery-1.7.1.min.js"></script>

<div class="main">
	<div id="option"><jsp:include flush='true'
			page='/home/header-picture.jsp'></jsp:include></div>
	<div id=title></div>

	<div class="news-path">
		<p>
			<a href="${pageContext.request.contextPath}/home/">Trang chủ</a>
			&nbsp;&nbsp; >> &nbsp;&nbsp; <a href="/home/tin-tuc/">Tin tức</a>
		</p>
	</div>
	<div class="view-news">
		<%
			String article_details = (String) session.getAttribute("article_details");
			if (article_details != null) {
				out.print(article_details);
		%>
		<script>
			$(document).ready(function() {
				$('#option').hide();
				$('#title').html("");
				$('.news-path').show();
			});
		</script>
		<%
			} else {
				String allNews = (String) session.getAttribute("allNews");
				if (allNews != null) {
					out.print(allNews);
		%>
		<script>
			$(document).ready(function() {
				$('#option').show();
				$('#title').html("<h2>Tin tức</h2>");
				$('.news-path').hide();
			});
		</script>
		<%
			}
			}
		%>
	</div>

	<jsp:include flush="true" page="/home/footer.jsp"></jsp:include>
</div>


