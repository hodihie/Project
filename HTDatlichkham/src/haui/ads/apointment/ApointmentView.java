package haui.ads.apointment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haui.ConnectionPool;
import haui.ads.customer.CustomerControl;
import haui.ads.doctor.Doctor;
import haui.ads.doctor.DoctorControl;
import haui.ads.user.UserControl;
import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;
import haui.objects.UserObject;

/**
 * Servlet implementation class ApointmentView
 */
@WebServlet("/adv/apointment/view")
public class ApointmentView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApointmentView() {
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
		ApointmentControl ac = new ApointmentControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}
		
		//tao doi tuong bo loc
		ApointmentObject similar=new ApointmentObject();
		DoctorControl dc= new DoctorControl(cp);
		CustomerControl cc= new CustomerControl(cp);
		
		// lay du lieu da duoc tao cau truc html
		String viewApointments = ac.viewApointments(similar, 1, (byte) 15, dc,cc);

		// tra ve ket noi
		ac.releaseConnection();

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
		out.print("<th>Tên bệnh nhân</th>");
		out.print("<th>Tên bác sĩ</th>");		
		out.print("<th>Ngày đặt hẹn</th>");
		out.print("<th>Ngày hẹn</th>");
		out.print("<th>Giờ hẹn</th>");
		out.print("<th>Triệu chứng</th>");		
		out.print("<th>Thực hiện</th>");
		out.print("<th>ID</th>");
		out.print("</tr>");

		out.print(viewApointments);

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

		doGet(request, response);
	}

}
