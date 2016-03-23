<%@page import="haui.library.Utilities"%>
<%@page import="haui.gui.article.ArticleControl"%>
<%@page import="java.util.ArrayList"%>
<%@page language="Java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@page import="haui.*"%>
<%@page import="haui.gui.speciality.*, haui.objects.*"%>
<%@page import="haui.gui.doctor.*"%>
<%@page import="haui.gui.article.*"%>

<%
	// 	//lay ve duong dan tuong doi
	// 	String uri = request.getRequestURI().substring(6);
	// 	//tim vi tri phan cap trang con
	// 	int at = uri.indexOf("/");//lay vi tri dau tien	

	//tim bo quan ly ket noi
	ConnectionPool cp = (ConnectionPool) application.getAttribute("c_pool");

	SpecialityControl sc = new SpecialityControl(cp);
	if (cp == null) {
		application.setAttribute("c_pool", sc.getConnectionPool());
	}

	//tao doi tuong bo loc
	SpecialityObject similarSpeciality = new SpecialityObject();

	//lay danh sach chuyen khoa
	String viewSpecialities = sc.viewSpecialityObjects(similarSpeciality);
	//truyen sang vi tri hien thi tai makecondition.jsp thong qua session
	session.setAttribute("viewSpecialities", viewSpecialities);
	//tra ve ket noi
	sc.releaseConnection();

	//tao doi tuong ArticleControl
	ArticleControl ac = new ArticleControl(cp);
	if (cp == null) {
		application.setAttribute("c_pool", ac.getConnectionPool());
	}

	ArticleObject article = new ArticleObject();
	
	//lay cau truc hien thi toan bo tin tuc
	String allNews=ac.viewAllNews(article);
	session.setAttribute("allNews", allNews);
	
	//lay cau truc hien thi tin moi nhat
	String newest = ac.viewNewest(article);
	session.setAttribute("newest", newest);

	//lay cau truc hien thi tin xem nhieu
	String mostVisited = ac.viewMostVisited(article);
	session.setAttribute("mostVisited", mostVisited);

	//lay cau truc hien thi cho tin noi bat
	article.setArticle_focus(true);
	String focus = ac.viewFocus(article);
	//truyen sang vi tri hien thi tai focus.jsp
	session.setAttribute("focus", focus);

	//lay cau truc hien thi chi tiet bai viet
	int art_id = Utilities.getIntParam(request, "art_id");
	if (art_id != -1) {
		String article_details = ac.viewFocusDetails(art_id);
		session.setAttribute("article_details", article_details);
	}else{
		session.setAttribute("article_details", null);
	}

	ac.releaseConneciton();

	//lay cau truc hien thi danh sach bac si
	DoctorObject doctor = new DoctorObject();
	DoctorControl dc = new DoctorControl(cp);
	if (cp == null) {
		application.setAttribute("c_pool", dc.getConnectionPool());
	}

	String viewDoctors = dc.viewDoctorObjects(doctor);
	session.setAttribute("viewDoctors", viewDoctors);
	dc.releaseConnection();
%>