/**
 * 
 */
package haui.ads.speciality;

import java.util.ArrayList;

import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;
import haui.objects.SpecialityObject;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class SpecialityLibrary {

	public static String viewSpecialites(ArrayList<SpecialityObject> items) {
		String tmp = "";
		int i = 0;		
		for (SpecialityObject item : items) {
			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += "<td class=NO>" + (i) + "</td>";
			tmp += "<td class=NAME>" + item.getSpeciality_name() + "</td>";
			tmp += "<td>" + item.getSpeciality_place() + "</td>";
			tmp += "<td>" + item.getSpeciality_phone() + "</td>";

			tmp += "<td class=ED><a href=\"/adv/speciality/ae?id=" + item.getSpeciality_id() + "  \">Sửa</a></td>";

			tmp += "<td class=ED><a href=\"/adv/speciality/del?id=" + item.getSpeciality_id()
					+ "\"  onclick=\"if(!confirm('Bạn có muốn xóa bản ghi này không?')) return false;\" >Xóa</a></td>";

			tmp += "<td class=ID>" + item.getSpeciality_id() + "</td>";
			tmp += "</tr>";
		}
		return tmp;
	}
}
