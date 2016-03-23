<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="haui.objects.*"%>
<%@page import="haui.gui.doctor.*"%>
<%@page import="haui.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/home/css/doctor-infor.css"
	rel="stylesheet" type="text/css" />
<title></title>
</head>
<body>



	<div class="doctor-display">
		
			<%
				ConnectionPool cp = (ConnectionPool) application.getAttribute("c_pool");
				DoctorControl dc = new DoctorControl(cp);
				if (cp == null) {
					application.setAttribute("c_pool", dc.getConnectionPool());
				}
				DoctorObject similarDoctor = new DoctorObject();

				int doctorId = -1;
				if (request.getParameter("doctorId") != null) {
					doctorId = Integer.parseInt(request.getParameter("doctorId"));

				}
			
				String viewDoctor = "";
				viewDoctor = dc.viewDoctorObject(doctorId);
				out.print(viewDoctor);
				dc.releaseConnection();
			%>
		
		
		<div class="clr"></div>
		<div style="height: 25px;"></div>
	</div>
</body>
</html>