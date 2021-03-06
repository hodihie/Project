package haui.ads.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Menu
 */
@WebServlet("/adv/menu")
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();
		String path = request.getRequestURI().substring(5);
		out.print("<div class=\"menu\">");
		String selected_menu = "";
		if (path.lastIndexOf("/") != -1) {
			out.print(
					"<a href=\"/adv/view\"><img src=\"/adv/imgs/icons/home_icon.png\" class=\"icon\"/><h3>Home</h3></a>");
			selected_menu = path.substring(0, path.lastIndexOf("/"));
		} else {
			out.print(
					"<a href=\"/adv/view\"><img src=\"/adv/imgs/icons/home_icon.png\" class=\"icon\"/><h3 class=\"selected_link\">Home</h3></a>");
		}
		if (selected_menu.equalsIgnoreCase("statistic")) {
			out.print(
					"<a href=\"/adv/statistic/view\"><img src=\"/adv/imgs/icons/statistic_icon.png\" class=\"icon\"/><h3 class=\"selected_link\">Thống kê</h3></a>");
		} else {
			out.print(
					"<a href=\"/adv/statistic/view\"><img src=\"/adv/imgs/icons/statistic_icon.png\" class=\"icon\"/><h3>Thống kê</h3></a>");
		}
		if (selected_menu.equalsIgnoreCase("doctor")) {
			out.print(
					"<a href=\"/adv/doctor/view\"><img src=\"/adv/imgs/icons/doctor_icon.png\" class=\"icon\"/><h3 class=\"selected_link\">Quản lý Bác sĩ</h3></a>");
		} else {
			out.print(
					"<a href=\"/adv/doctor/view\"><img src=\"/adv/imgs/icons/doctor_icon.png\" class=\"icon\"/><h3>Quản lý Bác sĩ</h3></a>");
		}
		if (selected_menu.equalsIgnoreCase("speciality")) {
			out.print(
					"<a href=\"/adv/speciality/view\"><img src=\"/adv/imgs/icons/speciality_icon.png\" class=\"icon\"/><h3 class=\"selected_link\">Quản lý Chuyên khoa</h3></a>");
		} else {
			out.print(
					"<a href=\"/adv/speciality/view\"><img src=\"/adv/imgs/icons/speciality_icon.png\" class=\"icon\"/><h3>Quản lý Chuyên khoa</h3></a>");
		}
		if (selected_menu.equalsIgnoreCase("patient")) {
			out.print(
					"<a href=\"/adv/patient/view\"><img src=\"/adv/imgs/icons/patient_icon.png\" class=\"icon\"/><h3 class=\"selected_link\">Quản lý Bệnh nhân</h3></a>");
		} else {
			out.print(
					"<a href=\"/adv/patient/view\"><img src=\"/adv/imgs/icons/patient_icon.png\" class=\"icon\"/><h3>Quản lý Bệnh nhân</h3></a>");
		}
		if (selected_menu.equalsIgnoreCase("apointment")) {
			out.print(
					"<a href=\"/adv/apointment/view\"><img src=\"/adv/imgs/icons/apointment_icon.png\" class=\"icon\"/><h3 class=\"selected_link\">Quản lý Lịch khám</h3></a>");
		} else {
			out.print(
					"<a href=\"/adv/apointment/view\"><img src=\"/adv/imgs/icons/apointment_icon.png\" class=\"icon\"/><h3>Quản lý Lịch khám</h3></a>");
		}

		if (selected_menu.equalsIgnoreCase("user")) {
			out.print(
					"<a href=\"/adv/user/view\"><img src=\"/adv/imgs/icons/user_icon.png\" class=\"icon\"><h3 class=\"selected_link\">Quản lý Người sử dụng</h3></a>");
		} else {
			out.print(
					"<a href=\"/adv/user/view\"><img src=\"/adv/imgs/icons/user_icon.png\" class=\"icon\"><h3>Quản lý Người sử dụng</h3></a>");
		}
		if (selected_menu.equalsIgnoreCase("section")) {
			out.print(
					"<a href=\"/adv/section/view\"><img src=\"/adv/imgs/icons/category_icon.png\" class=\"icon\"><h3 class=\"selected_link\" >Quản lý Chuyên mục</h3></a>");
		} else {
			out.print(
					"<a href=\"/adv/section/view\"><img src=\"/adv/imgs/icons/category_icon.png\" class=\"icon\"><h3>Quản lý Chuyên mục</h3></a>");
		}
		if (selected_menu.equalsIgnoreCase("category")) {
			out.print(
					"<a href=\"/adv/category/view\"><img src=\"/adv/imgs/icons/section_icon.png\" class=\"icon\"><h3 class=\"selected_link\">Quản lý Thể loại</h3></a>");
		} else {
			out.print(
					"<a href=\"/adv/category/view\"><img src=\"/adv/imgs/icons/section_icon.png\" class=\"icon\"><h3>Quản lý Thể loại</h3></a>");
		}
		if (selected_menu.equalsIgnoreCase("article")) {
			out.print(
					"<a href=\"/adv/article/view\"><img src=\"/adv/imgs/icons/article_icon.png\" class=\"icon\"><h3 class=\"selected_link\">Quản lý Tin bài</h3></a>");
		} else {
			out.print(
					"<a href=\"/adv/article/view\"><img src=\"/adv/imgs/icons/article_icon.png\" class=\"icon\"><h3>Quản lý Tin bài</h3></a>");
		}

		out.print("</div>");

		out.print("");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
