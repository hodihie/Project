/**
 * 
 */
package haui.ads.apointment;

import java.util.ArrayList;

import haui.ads.customer.CustomerControl;
import haui.ads.doctor.DoctorControl;
import haui.ads.doctor.DoctorModel;
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

	public static String viewApointments(ArrayList<ApointmentObject> items, DoctorControl dc, CustomerControl cc) {
		String tmp = "";
		int i = 0;		
		for (ApointmentObject item : items) {
			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += "<td class=NO>" + (i) + "</td>";
			tmp += "<td>" + cc.getCustomerObject(item.getApointment_customer_id()).getCustomer_fullname() + "</td>";
			tmp += "<td class=NAME>" + dc.getDoctorObject(item.getApointment_doctor_id()).getDoctor_name() + "</td>";			
			tmp += "<td>" + item.getApointment_created_date() + "</td>";			
			tmp += "<td>" + item.getApointment_date() + "</td>";			
			tmp += "<td>" + item.getApointment_symptom() + "</td>";

			tmp += "<td class=ED><a href=\"/adv/apointment/del?id=" + item.getApointment_id()
					+ "\"  onclick=\"if(!confirm('Bạn có muốn xóa bản ghi này không?')) return false;\" >Xóa</a></td>";

			tmp += "<td class=ID>" + item.getApointment_id() + "</td>";
			tmp += "</tr>";
		}
		return tmp;

	}
}
