package haui.gui.apointment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import haui.ConnectionPool;
import haui.gui.doctor.DoctorControl;
import haui.gui.patient.PatientControl;
import haui.library.DateUtils;
import haui.library.Utilities;
import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;
import haui.objects.PatientObject;

/**
 * Servlet implementation class MakeApointment
 */
@WebServlet("/home/dat-lich-kham/make-apointment")
public class MakeApointmentAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MakeApointmentAction() {
		super();		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		request.setCharacterEncoding("UTF-8");
		// String stSpecialityId = request.getParameter("slcSpeciality");
		int doctorId = Utilities.getIntParam(request, "slcDoctor");
		String date = request.getParameter("txtDate");
		String symptom = request.getParameter("txtSymptom");
		String name = request.getParameter("txtName");
		String stGender = request.getParameter("rdGender");
		String birthday = request.getParameter("txtBirthday");
		String address = request.getParameter("txtAddress");
		String phone = Utilities.getMobilePhone(request, "txtPhone");	

		if (doctorId > 0 && !date.equalsIgnoreCase("") && !symptom.equalsIgnoreCase("") && !name.equalsIgnoreCase("")
				&& !stGender.equalsIgnoreCase("") && !birthday.equalsIgnoreCase("") && !address.equalsIgnoreCase("")
				&& !phone.equalsIgnoreCase("")) {
			
			String createdDate = DateUtils.getCurrentDateTime();

			short gender = Short.parseShort(stGender);

			PatientObject nPatient = new PatientObject();
			nPatient.setPatient_fullname(Utilities.encode(name));
			nPatient.setPatient_gender(gender);
			nPatient.setPatient_birthday(birthday);
			nPatient.setPatient_address(Utilities.encode(address));
			nPatient.setPatient_phone(phone);			

			// tim bo quan ly ket noi
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
			PatientControl cc = new PatientControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("c_pool", cc.getConnectionPool());
			}

			// thuc hien
			int cusId;
			cusId = cc.addPatient(nPatient);

			// tra ve ket noi
			cc.releaseConnection();

			// kiem tra ket qua thuc hien
			if (cusId > 0) {
				ApointmentObject nApointment = new ApointmentObject();
				nApointment.setApointment_doctor_id(doctorId);
				nApointment.setApointment_date(DateUtils.changeDateFormat(date, DateUtils.DISPLAY_DATETIME, DateUtils.YYYY_MM_DD_HH_MM));
				nApointment.setApointment_patient_id(cusId);				
				nApointment.setApointment_symptom(Utilities.encode(symptom));
				nApointment.setApointment_created_date(createdDate);

				ApointmentControl ac = new ApointmentControl(cp);
				if (cp == null) {
					getServletContext().setAttribute("c_pool", ac.getConnectionPool());
				}

				// thuc hien
				boolean apt_result;
				apt_result = ac.addApointment(nApointment);

				// tra ve ket noi
				ac.releaseConnection();
				if (apt_result) {
					DoctorControl dc = new DoctorControl(cp);
					if (cp == null) {
						getServletContext().setAttribute("c_pool", dc.getConnectionPool());
					}
					DoctorObject doctor = dc.getDoctorObject(doctorId);

					HttpSession session = request.getSession();
					session.setAttribute("patientCode", "BN" + cusId);
					session.setAttribute("room", doctor.getDoctor_workroom());
					String datetime = date;
					session.setAttribute("datetime", datetime);
					response.sendRedirect("/home/dat-lich-kham/xac-nhan/");
				}

			}

		}

	}

}
