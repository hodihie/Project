<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="intros">
	<div class="slider-wrapper theme-default">
		<div id="slider" class="nivoSlider">
			<a href="#"><img
				src="${pageContext.request.contextPath}/home/pictures/intros/slide4.jpg"
				alt="" title="Sảnh chờ tại trung tâm phầu thuật" /></a> <a href="#"><img
				src="${pageContext.request.contextPath}/home/pictures/intros/slide1.jpg"
				alt="" title="Bệnh viện Nhân Đạo " /></a> <a href="#"><img
				src="${pageContext.request.contextPath}/home/pictures/intros/slide2.jpg"
				alt="" title="Bệnh nhân là tất cả đối với bệnh viện" /></a> <a href="#"><img
				src="${pageContext.request.contextPath}/home/pictures/intros/slide3.jpg"
				alt="" title="Phòng thuốc Nhân Đạo" data-transition="slideInLeft" /></a> <a
				href="#"><img
				src="${pageContext.request.contextPath}/home/pictures/intros/slide5.jpg"
				alt="" title="Quán cà phê de Paris tại sảnh Indochine" /></a>
		</div>
	</div>
	<!--End .slider-wrapper-->
	<script language="javascript" type="text/javascript"
		src="${pageContext.request.contextPath}/home/js/jquery-1.7.1.min.js"></script>
	<script language="javascript" type="text/javascript"
		src="${pageContext.request.contextPath}/home/js/jquery.nivo.slider.pack.js"></script>
	<script type="text/javascript">
		$(window).load(function() {
			$('#slider').nivoSlider();
		});
	</script>
</div>
