/**
 * 
 */
package haui.ads.patient;

import java.util.ArrayList;

import haui.objects.ApointmentObject;
import haui.objects.PatientObject;
import haui.objects.DoctorObject;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class PatientLibrary {

	public static String viewPatients(ArrayList<PatientObject> items) {
		String tmp = "";
		int i = 0;
		String gender;
		for (PatientObject item : items) {
			gender = item.getPatient_gender() == (short) 1 ? "Nam" : "Nữ";

			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += "<td class=NO>" + (i) + "</td>";
			tmp += "<td class=NAME>" + item.getPatient_fullname() + "</td>";
			tmp += "<td>" + gender + "</td>";
			tmp += "<td>" + item.getPatient_birthday() + "</td>";
			tmp += "<td>" + item.getPatient_address() + "</td>";
			tmp += "<td>" + item.getPatient_phone() + "</td>";			

			tmp += "<td class=ED><a href=\"/adv/patient/del?id=" + item.getPatient_id()
					+ "\"  onclick=\"if(!confirm('Bạn có muốn xóa bản ghi này không?')) return false;\" ><img src=\"/adv/imgs/icons/delete.png\" class=\"icon\"></a></td>";

			tmp += "<td class=ID>" + item.getPatient_id() + "</td>";
			tmp += "</tr>";
		}
		return tmp;
	}
}
