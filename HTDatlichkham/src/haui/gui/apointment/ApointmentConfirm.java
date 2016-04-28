package haui.gui.apointment;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haui.ConnectionPool;
import haui.library.DateUtils;
import haui.library.StringUtils;
import haui.objects.RequestSMSObject;

/**
 * Servlet implementation class ApointmentConfirm
 */
@WebServlet("/home/dat-lich-kham/apointment/confirm")
public class ApointmentConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApointmentConfirm() {
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
		
		String mobile = request.getParameter("mobile");		
		
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		ApointmentControl ac = new ApointmentControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}
		
		if (!StringUtils.isEmpty(mobile)) {
			RequestSMSObject item = new RequestSMSObject();
			item.setReq_PhoneNumber(mobile);
			item.setReq_sendDate(DateUtils.getCurrentDate());
			
			ac.addRequestSMS(item);
		}

		String responseInfo = "Cảm ơn bạn đã đặt lịch khám tại bệnh viện Nhân Đạo.\n";
		responseInfo += "Bạn hãy trở lại trang web để hoàn tất việc đặt lịch khám!";		
		out.println(responseInfo);
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
