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
		String date = DateUtils.roundTime15M(DateUtils.addMintue("201604170700", duration / 60));

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		ApointmentControl ac = new ApointmentControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}
		// tao doi tuong bo loc
		ArrayList<ApointmentObject> items = ac.getNextApointmentsByDocId(doctorid, date);
		ArrayList<String> dateList = new ArrayList<String>();
		int apointmentListLeng = items.size();
		if (apointmentListLeng == 0) {
			dateList.add(date);
		} else {
			String temp = DateUtils.addMintue(items.get(0).getApointment_date(), 15);

			String flag = null;
			int j;
			int number = 0;
			while (number < 5) {
				j = 0;
				while (j < apointmentListLeng) {
					flag = "0";
					if (temp.equals(items.get(j).getApointment_date())) {
						flag = "1";
						break;
					}
					j++;
				}
				if ("0".equals(flag)) {
					dateList.add(temp);
					number++;
				}
				temp = DateUtils.addMintue(temp, 15);

			}
		}

		json = new Gson().toJson(DateUtils.getDateFormat(DateUtils.makeDate(dateList.get(0)), "dd/MM/yyyy HH:mm"));
		response.setContentType("application/json");
		response.getWriter().write(json);

	}

}
