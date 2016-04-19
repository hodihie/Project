package haui.gui.apointment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import haui.ConnectionPool;
import haui.gui.doctor.DoctorControl;
import haui.library.ApointmentConstants;
import haui.library.DateUtils;
import haui.library.Utilities;
import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;

/**
 * Servlet implementation class Apointment
 */
@WebServlet("/home/dat-lich-kham/apointment")
public class ApointmentAction extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ApointmentAction() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		int specialityId = Integer.parseInt(request.getParameter("SpecialityId"));

		ArrayList<DoctorObject> list = new ArrayList<>();
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		DoctorControl dc = new DoctorControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", dc.getConnectionPool());
		}
		DoctorObject similar = new DoctorObject();

		list = dc.getDoctorObjects(similar, specialityId);

		String doctors = null;

		doctors = new Gson().toJson(list);
		response.setContentType("application/json");
		response.getWriter().write(doctors);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		// kiem tra trung lich hen
		short doctorid = Utilities.getShortParam(request, "doctorid");
		int duration = Utilities.getIntParam(request, "duration");

		String startTime = DateUtils.getStartTime();
		String endTime = DateUtils.getEndTime();

		String json = null;
		// TODO: for test
		String date = DateUtils.addMintue("201604171610", duration / 60);

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		ApointmentControl ac = new ApointmentControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}
		// tao doi tuong bo loc
		ArrayList<ApointmentObject> items = ac.getNextApointmentsByDocId(doctorid, date);
		ArrayList<String> dateList = new ArrayList<>();

		date = DateUtils.roundTime15M(date);

		int count = 0;
		while (count < 5) {

			// kiem tra dieu kien thoi gian lam viec
			if (DateUtils.isEalier(date, startTime)) {
				date = startTime;
			} else if (date.equals(endTime) || DateUtils.isAfter(date, endTime)) {
				date = DateUtils.addDay(startTime, 1);
				startTime = DateUtils.addDay(startTime, 1);
				endTime = DateUtils.addDay(endTime, 1);
			}

			// neu chua co lich kham vao thoi diem nay thi them vao danh sach
			// tra ve
			if (isApointment(date, items)) {
				dateList.add(DateUtils.changeDateFormat(date, DateUtils.YYYY_MM_DD_HH_MM, DateUtils.DISPLAY_DATETIME));
				count++;
			}
			date = DateUtils.addMintue(date, ApointmentConstants.APOINTMENT_LENGTH);
		}

		json = new Gson().toJson(dateList);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

	// kiem tra neu ngay hen co thoa man hay khong
	private static boolean isApointment(String date, ArrayList<ApointmentObject> items) {
		if (items.size() == 0) {
			return true;
		}
		int j = 0;
		while (j < items.size()) {
			if (date.equals(items.get(j).getApointment_date())) {
				return false;
			}
			j++;
		}
		return true;
	}

}
