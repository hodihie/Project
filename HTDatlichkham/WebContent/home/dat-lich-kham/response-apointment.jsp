<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>

<%
	String customerCode = (String) session.getAttribute("customerCode");
	String room = (String) session.getAttribute("room");
	String datetime=(String)session.getAttribute("datetime");
	if (customerCode != null && room != null) {
		if (!customerCode.equalsIgnoreCase("") && !room.equalsIgnoreCase("")) {
%>
<jsp:include flush="true" page="/home/header.jsp"></jsp:include>
<div class="main">
	<jsp:include flush="true" page="/home/header-picture.jsp"></jsp:include>
	<jsp:include flush="true" page="/home/dat-lich-kham/library.jsp"></jsp:include>
	<p style="text-align: justify; font-size: 15px; font-weight: bold;border: 1px solid #A6A6A6;padding: 10px;">
		Cám ơn bạn đã đặt hẹn khám bệnh tại bênh viện Nhân Đạo. <br /> Mời bạn đến bệnh
		viên Nhân đạo tại địa chỉ:&nbsp<label style="color: #00AACC"> <%=room%>,
			số 32, Đường 32, Quận Bắc Từ Liêm, Hà Nội
		</label> để khám bệnh theo lịch hẹn. <br /> Mã số khám bệnh của bạn là:&nbsp<label
			style="color: #00AACC"> <%=customerCode%></label><br /> 
			Thời gian hẹn là:&nbsp<label style="color: #00AACC"><%=datetime %></label><br/>
			Bạn vui lòng
		ghi nhớ mã sô bệnh nhân khi đi khám bệnh để bác sĩ xác nhận!
	</p>

	<jsp:include flush="true" page="/home/footer.jsp"></jsp:include>
</div>
<%
	session.removeAttribute("customerCode");
			session.removeAttribute("room");

		} else {
%>
<script>
	window.location = "/home/";
</script>
<%
	}
	} else {
%>
<script>
	window.location = "/home/";
</script>
<%
	}
%>






