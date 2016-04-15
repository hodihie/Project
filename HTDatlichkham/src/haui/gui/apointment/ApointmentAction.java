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
import haui.library.DateUtils;
import haui.library.StringUltils;
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
		System.out.println(duration);

		String json = null;
		String date = null;
		String currentDate = DateUtils.getCurrentDateTime();

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		ApointmentControl ac = new ApointmentControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}
		// tao doi tuong bo loc
		ArrayList<ApointmentObject> items = ac.getNextApointmentsByDocId(doctorid, currentDate);
		if (items.size() == 0) {
			date = DateUtils.roundTime15M(DateUtils.addMintue(currentDate, duration / 60));
		} else {
			for (ApointmentObject item : items) {
				if (StringUltils.isEmpty(date)) {
					date = item.getApointment_date();
				} else if (DateUtils.isEarlier(date, item.getApointment_date())) {
					// date = DateUtils.getEarlierDate(date,
					// item.getApointment_date());
				}
			}

			date = DateUtils.addMintue(date, duration / 60);

		}

		json = new Gson().toJson(DateUtils.getDateFormat(DateUtils.makeDate(date), "dd/MM/yyyy HH:mm"));
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

}
