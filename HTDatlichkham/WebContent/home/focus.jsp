<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>

<div class="menu">
	<a href="#">ĐỘI NGŨ BÁC SĨ</a> <a href="#">PHÒNG KHÁM</a> <a href="#">VIỆN
		PHÍ</a>
</div>
<div class="focus" >
	<%
		String focus = (String) session.getAttribute("focus");
		if (focus != null) {
			out.print(focus);
		}
	%>

	<div class="advers-focus">
		<a href="#"><img
			src="${pageContext.request.contextPath}/home/pictures/advers/advers1.gif" /></a>
	</div>
</div>
<div class="clr"></div>
<div class="mostview" >
	<%
		String mostVisited = (String) session.getAttribute("mostVisited");
		if (mostVisited != null) {
			out.print(mostVisited);
		}
	%>
</div>
<div class="newest">
	<%
		String newest = (String) session.getAttribute("newest");
		if (newest != null) {
			out.print(newest);
		}
	%>
</div>
<div class="clr"></div>

<div>
	<link rel="stylesheet" type="text/css"
		href="${pageContext.request.contextPath}/home/css/carouselengine/initcarousel-1.css">
	<script
		src="${pageContext.request.contextPath}/home/js/carouselengine/amazingcarousel.js"></script>
	<script
		src="${pageContext.request.contextPath}/home/js/carouselengine/initcarousel-1.js"></script>

	<%
		String viewDoctors = (String) session.getAttribute("viewDoctors");
		if (viewDoctors != null) {
			out.print(viewDoctors);
		}
	%>

</div>


<div class="advers">
	<a href="#"><img
		src="${pageContext.request.contextPath}/home/pictures/advers/advers2.gif" /></a>
</div>