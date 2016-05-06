package haui.gui.apointment;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import haui.ConnectionPool;
import haui.library.ApointmentConstants;
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
		String currDate = DateUtils.getCurrentDateTime();
		String otp = generateOTP(6);		
		StringBuilder responseInfo = new StringBuilder("Khong thanh cong.\n");

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		ApointmentControl ac = new ApointmentControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}

		if (!StringUtils.isEmpty(mobile)) {
			RequestSMSObject item = new RequestSMSObject();
			item.setReq_PhoneNumber(mobile);
			item.setReq_sendDate(currDate);
			item.setReq_otp(otp);
			item.setReq_otpExpire(DateUtils.addMintue(currDate, ApointmentConstants.OTP_TIMEOUT));

			if (ac.addRequestSMS(item)) {
				responseInfo = new StringBuilder();
				responseInfo.append("Cam on ban da dat lich kham tai benh vien Nhan Dao.\n");
				responseInfo.append("Ma xac nhan cua ban la ");
				responseInfo.append(otp);
				responseInfo.append("\n");
				responseInfo.append(
						"Mã xac nhan co tac dung trong vong 5 phut ke tu khi nhan duoc tin nhan nay!");
			}
		}

		out.println("0|" + responseInfo.toString());
	}

	// generate OTP
	public static String generateOTP(int size) {

		StringBuilder generatedToken = new StringBuilder();
		try {
			// tạo 1 SecureRandom với thuật toán chỉ rõ là SHA1PRNG
			SecureRandom number = SecureRandom.getInstance("SHA1PRNG");
			// Generate 6 integers 0..6
			for (int i = 0; i < size; i++) {
				generatedToken.append(number.nextInt(9));
			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return generatedToken.toString();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		String phone = request.getParameter("phone");
		String currentDate = DateUtils.getCurrentDateTime();		
		String otp = request.getParameter("otp");;

		RequestSMSObject item = new RequestSMSObject();
		item.setReq_PhoneNumber(phone);
		item.setReq_otp(otp);
		item.setReq_otpExpire(currentDate);

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		ApointmentControl ac = new ApointmentControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}

		String message = "";
		if (ac.verifyOTP(item)) {
			message = "success";
		} else {
			message = "fail";
		}

		message = new Gson().toJson(message);
		response.setContentType("application/json");
		response.getWriter().write(message);
	}

}
