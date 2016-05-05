<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<jsp:include flush="true" page="data.jsp"></jsp:include>
<html>
<head>
<title>Bệnh viện Nhân Đạo</title>
<link rel="shortcut icon" type="image/png" href="/home/imgs/title.ico" />
<link href="${pageContext.request.contextPath}/home/css/layout.css"
	rel="stylesheet" type="text/css" />

	<link href="${pageContext.request.contextPath}/home/css/slider/style.css"
	rel="stylesheet" type="text/css" />
<script language="JavaScript" src=""></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<div class="top-layout">
		<div class="top">
			<div class="header"></div>

			<div class="rtop">
				<div id="language">
					<a href="#">TIẾNG VIỆT</a>&nbsp|&nbsp <a href="#">ENGLISH</a>
				</div>

				<div id="search">
					<form name="frmSearch">
						<input type="text" name="txtSearch" size=15 /> <input
							type="button" name="btnSearch" value="Tìm kiếm" />
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
				<li><a href="/home/">TRANG CHỦ</a></li>
				<li><a href="/home/gioi-thieu/">GIỚI THIỆU</a>	</li>
				<li><a href="/home/tin-tuc/">TIN TỨC</a></li>
				<li><a href="#">DỊCH VỤ ĐIỀU TRỊ NỘI TRÚ</a></li>
				<li><a href="/home/dat-lich-kham/">ĐẶT LỊCH KHÁM</a></li>				
				<li><a href="#">DỊCH VỤ BẢO HIỂM</a></li>
				<li><a href="/home/ho-tro/">DỊCH VỤ HỖ TRỢ</a></li>
				<li><a href="/home/lien-he/">LIÊN HỆ</a></li>
			</ul>
		</div>
		<div class="f1">
			<br>
		</div>
		<div class="clr"></div>
	</div>