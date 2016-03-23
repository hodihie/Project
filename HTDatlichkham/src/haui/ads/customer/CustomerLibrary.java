/**
 * 
 */
package haui.ads.customer;

import java.util.ArrayList;

import haui.objects.ApointmentObject;
import haui.objects.CustomerObject;
import haui.objects.DoctorObject;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class CustomerLibrary {

	public static String viewCustomers(ArrayList<CustomerObject> items) {
		String tmp = "";
		int i = 0;
		String gender;
		for (CustomerObject item : items) {
			gender = item.getCustomer_gender() == (short) 1 ? "Nam" : "Nữ";

			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += "<td class=NO>" + (i) + "</td>";
			tmp += "<td class=NAME>" + item.getCustomer_fullname() + "</td>";
			tmp += "<td>" + gender + "</td>";
			tmp += "<td>" + item.getCustomer_birthday() + "</td>";
			tmp += "<td>" + item.getCustomer_address() + "</td>";
			tmp += "<td>" + item.getCustomer_phone() + "</td>";
			tmp += "<td>" + item.getCustomer_email() + "</td>";

			tmp += "<td class=ED><a href=\"/adv/customer/del?id=" + item.getCustomer_id()
					+ "\"  onclick=\"if(!confirm('Bạn có muốn xóa bản ghi này không?')) return false;\" >Xóa</a></td>";

			tmp += "<td class=ID>" + item.getCustomer_id() + "</td>";
			tmp += "</tr>";
		}
		return tmp;
	}
}
