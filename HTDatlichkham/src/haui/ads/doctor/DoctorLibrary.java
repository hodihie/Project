/**
 * 
 */
package haui.ads.doctor;

import java.util.ArrayList;

import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class DoctorLibrary {

	public static String viewDoctors(ArrayList<DoctorObject> items) {
		String tmp = "";
		int i = 0;
		String gender;
		for (DoctorObject item : items) {
			gender = item.getDoctor_gender() == (short) 1 ? "Nam" : "Nữ";

			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += "<td class=NO>" + (i) + "</td>";
			tmp += "<td><img height=\"35\" width=\"30\" src=\"" + item.getDoctor_img() + "\"/></td>";
			tmp += "<td class=NAME>" + item.getDoctor_name() + "</td>";
			tmp += "<td>" + item.getDoctor_speciality_id() + "</td>";
			tmp += "<td>" + item.getDoctor_age() + "</td>";
			tmp += "<td>" + gender + "</td>";
			tmp += "<td>" + item.getDoctor_workroom() + "</td>";
			tmp += "<td class=ED><a href=\"/adv/doctor/ae?id=" + item.getDoctor_id() + "  \">Sửa</a></td>";

			tmp += "<td class=ED><a href=\"/adv/doctor/del?id=" + item.getDoctor_id()
					+ "\"  onclick=\"if(!confirm('Bạn có muốn xóa bản ghi này không?')) return false;\" >Xóa</a></td>";

			tmp += "<td class=ID>" + item.getDoctor_id() + "</td>";
			tmp += "</tr>";
		}
		return tmp;
	}
}
