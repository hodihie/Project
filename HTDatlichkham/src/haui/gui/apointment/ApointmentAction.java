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
		
		//kiem tra trung lich hen
		int doctorid = Integer.parseInt(request.getParameter("doctorid"));
		String date = request.getParameter("date");
		String time = request.getParameter("time");

		String json = null;
		String st = "";

		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		ApointmentControl ac = new ApointmentControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}
		// tao doi tuong bo loc
		ApointmentObject similar = new ApointmentObject();
		ArrayList<ApointmentObject> items = ac.getApointmentObjects(similar);
		for (ApointmentObject item : items) {
			if (item.getApointment_doctor_id() == doctorid && item.getApointment_date().equalsIgnoreCase(date)
					&& item.getApointment_time().equalsIgnoreCase(time)) {
				st = "error";
			}
		}

		json = new Gson().toJson(st);
		response.setContentType("application/json");
		response.getWriter().write(json);	
		
		
	}

}
