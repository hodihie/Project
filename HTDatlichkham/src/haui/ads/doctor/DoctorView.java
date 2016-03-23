package haui.ads.doctor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haui.ConnectionPool;
import haui.ads.apointment.ApointmentControl;
import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;
import haui.objects.UserObject;

/**
 * Servlet implementation class DoctorView
 */
@WebServlet("/adv/doctor/view")
public class DoctorView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DoctorView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// tim thong tin dang nhap
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");
		if (user != null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/adv/user/login");
		}
	}

	private void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		// tim bo quanly ket noi
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		DoctorControl dc = new DoctorControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", dc.getConnectionPool());
		}

		// tao doi tuong bo loc
		DoctorObject similar = new DoctorObject();

		// lay du lieu da duoc tao cau truc html
		String viewDoctors = dc.viewDoctors(similar, 1, (byte) 15);

		// tra ve ket noi
		dc.releaseConnection();

		// goi header
		RequestDispatcher h = request.getRequestDispatcher("/adv/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"view\">");
		out.print("<table cellspacing=0>");

		out.print("<tr>");
		out.print("<td colspan=9>");
		out.print("</td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<th>STT</th>");
		out.print("<th>Ảnh</th>");
		out.print("<th>Tên bác sĩ</th>");
		out.print("<th>Tên chuyên khoa</th>");
		out.print("<th>Tuổi</th>");
		out.print("<th>Giới tính</th>");
		out.print("<th>Phòng làm việc</th>");		
		out.print("<th colspan=2>Thực hiện</th>");
		out.print("<th>ID</th>");
		out.print("</tr>");

		out.print(viewDoctors);

		out.print("</table>");
		out.print("</div>");

		// goi footer
		RequestDispatcher f = request.getRequestDispatcher("/adv/footer");
		if (f != null) {
			f.include(request, response);
		}

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
