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
		// TODO: for test
		String date = DateUtils.roundTime15M(DateUtils.addMintue("201604170700", duration / 60));

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		ApointmentControl ac = new ApointmentControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}
		// tao doi tuong bo loc
		ArrayList<ApointmentObject> items = ac.getNextApointmentsByDocId(doctorid, date);
		ArrayList<String> dateList = new ArrayList<String>();
		int apointmentListLength = items.size();
		if (apointmentListLength == 0) {
			dateList.add(date);
		} else {
			String temp = DateUtils.addMintue(items.get(0).getApointment_date(), ApointmentConstants.APOINTMENT_LENGTH);

			String flag = null;
			int flag2 = 0;
			int j = 0;
			int number = 0;
			while (number < 5) {
				j = flag2;
				while (j < apointmentListLength) {
					flag = "0";
					if (temp.equals(items.get(j).getApointment_date())) {
						flag = "1";
						flag2 = j;
						break;
					}
					j++;
				}
				if ("0".equals(flag)) {
					dateList.add(DateUtils.getDateFormat(DateUtils.makeDate(temp), "dd/MM/yyyy HH:mm"));
					number++;
				}
				temp = DateUtils.addMintue(temp, ApointmentConstants.APOINTMENT_LENGTH);
			}
		}

		json = new Gson().toJson(dateList);
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

}
