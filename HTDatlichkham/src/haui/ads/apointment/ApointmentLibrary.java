/**
 * 
 */
package haui.ads.apointment;

import java.util.ArrayList;

import haui.ads.patient.PatientControl;
import haui.ads.doctor.DoctorControl;
import haui.ads.doctor.DoctorModel;
import haui.library.DateUtils;
import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;

/**
 * @author Dinh Hieu
 *
 */
public class ApointmentLibrary {

	/**
	 * 
	 */
	public ApointmentLibrary() {
		// TODO Auto-generated constructor stub
	}

	public static String viewApointments(ArrayList<ApointmentObject> items, DoctorControl dc, PatientControl pc) {
		String tmp = "";
		int i = 0;		
		for (ApointmentObject item : items) {
			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += "<td class=NO>" + (i) + "</td>";
			tmp += "<td>" + pc.getPatientObject(item.getApointment_patient_id()).getPatient_fullname() + "</td>";
			tmp += "<td class=NAME>" + dc.getDoctorObject(item.getApointment_doctor_id()).getDoctor_name() + "</td>";			
			tmp += "<td>" + DateUtils.changeDateFormat(item.getApointment_created_date(), DateUtils.YYYY_MM_DD_HH_MM, DateUtils.DISPLAY_DATETIME) + "</td>";			
			tmp += "<td>" + DateUtils.changeDateFormat(item.getApointment_date(), DateUtils.YYYY_MM_DD_HH_MM, DateUtils.DISPLAY_DATETIME) + "</td>";			
			tmp += "<td>" + item.getApointment_symptom() + "</td>";

			tmp += "<td class=ED><a href=\"/adv/apointment/del?id=" + item.getApointment_id()
					+ "\"  onclick=\"if(!confirm('Bạn có muốn xóa bản ghi này không?')) return false;\" ><img src=\"/adv/imgs/icons/delete.png\" class=\"icon\"></a></td>";

			tmp += "<td class=ID>" + item.getApointment_id() + "</td>";
			tmp += "</tr>";
		}
		return tmp;

	}
}
