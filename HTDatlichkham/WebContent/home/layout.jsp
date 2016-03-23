<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Bệnh viện Nhân Đạo</title>
<link href="${pageContext.request.contextPath}/home/css/layout.css"
	rel="stylesheet" type="text/css" />
<script language="JavaScript" src=""></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<div class="main">
		<div class="top">
			<div class="header"></div>

			<div class="rtop">
				<div id="language">
					<a href="#">TIẾNG VIỆT</a>&nbsp|&nbsp <a href="#">ENGLISH</a>
				</div>

				<div id="search">
					<form name="frmSearch">
						<input type="text" name="txtSearch" size=15 /> <input
							type="button" name="btnSearch" value="Tìm kiếm"
							style="color: #efefef;" />
					</form>
				</div>

				<div class="clr"></div>
			</div>
		</div>
	</div>
	<div class="topmenu">
		<div class="f1">
			<br>
		</div>
		<div class="f2" style="margin: 0 15px">
			<ul>
				<li><a href="layout.jsp">TRANG CHỦ</a></li>
				<li><a href="">GIỚI THIỆU</a>
					<ul>


					</ul></li>
				<li><a href="#">ĐẶT LỊCH KHÁM</a></li>
				<li><a href="">DỊCH VỤ ĐIỀU TRỊ NỘI TRÚ</a></li>
				<li><a href="">DỊCH VỤ BẢO HIỂM</a></li>
				<li><a href="">DỊCH VỤ HỖ TRỢ</a></li>
				<li><a href="">LIÊN HỆ</a></li>
			</ul>
		</div>
		<div class="f1">
			<br>
		</div>
		<div class="clr"></div>
	</div>
	<div class="main">
		<div class="intros">
			<div class="slider-wrapper theme-default">
				<div id="slider" class="nivoSlider">
					<a href="#"><img
						src="${pageContext.request.contextPath}/home/pictures/intros/slide1.jpg"
						alt="" title="Bệnh viện FV" /></a> <a href="#"><img
						src="${pageContext.request.contextPath}/home/pictures/intros/slide2.jpg"
						alt="" title="Bệnh nhân là tất cả đối với bệnh viện" /></a> <a
						href="#"><img
						src="${pageContext.request.contextPath}/home/pictures/intros/slide3.jpg"
						alt="" title="Phòng thuốc FV" data-transition="slideInLeft" /></a> <a
						href="#"><img
						src="${pageContext.request.contextPath}/home/pictures/intros/slide4.jpg"
						alt="" title="Sảnh chờ tại trung tâm phầu thuật" /></a> <a href="#"><img
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

		<div class="menu">
			<a href="#">TRUYỀN THÔNG</a> <a href="#">KHÁM PHÁ FV</a> <a href="#">GÓC
				TRI ÂN</a> <a href="#">SỐNG KHỎE CÙNG FV</a>
		</div>

		<div class="content">
			<div class="view">
				<a href="#"><h3>BỆNH VIỆN FV ĐẨY MẠNH QUẢNG BÁ THƯƠNG HIỆU
						TẠI THỊ TRƯỜNG CAMPUCHIA</h3></a> <a href="#"><h3>THAM GIA GIẢI
						QUẦN VỢT FV MỞ RỘNG 2015</h3></a> <a href="#"><h3>VTV9 THỰC HIỆN
						PHÓNG SỰ VỀ QUY TRÌNH PHẪU THUẬT LASIK TẠI BỆNH VIỆN FV</h3></a> <a
					href="#"><h2>Xem tất cả tin tức</h2></a>
			</div>

			<div class="lview"></div>
		</div>

		<div class="bottom_menu"></div>

		<div class="footer"></div>
	</div>

</body>
</html>