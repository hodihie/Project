package haui.ads.patient;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haui.ConnectionPool;
import haui.ads.doctor.DoctorControl;
import haui.objects.PatientObject;
import haui.objects.DoctorObject;
import haui.objects.UserObject;

/**
 * Servlet implementation class PatientView
 */
@WebServlet("/adv/patient/view")
public class PatientView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PatientView() {
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
		PatientControl cc = new PatientControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", cc.getConnectionPool());
		}

		// tao doi tuong bo loc
		PatientObject similar = new PatientObject();

		// lay du lieu da duoc tao cau truc html
		String viewPatients = cc.viewPatients(similar, 1, (byte) 15);

		// tra ve ket noi
		cc.releaseConnection();

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
		out.print("<th>Tên</th>");
		out.print("<th>Giới tính</th>");
		out.print("<th>Ngày sinh</th>");
		out.print("<th>Địa chỉ</th>");
		out.print("<th>Điện thoại</th>");
		out.print("<th>Email</th>");	
		out.print("<th>Thực hiện</th>");
		out.print("<th>ID</th>");
		out.print("</tr>");

		out.print(viewPatients);

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
