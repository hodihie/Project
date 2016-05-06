/**
 * 
 */
package haui.ads.user;

import java.util.ArrayList;

import haui.library.Utilities;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class UserLibrary {
	/**
	 * 
	 */
	public UserLibrary() {

	}

	public static String viewUsers(ArrayList<UserObject> items, UserObject user, int total, int page,
			byte totalperpage) {
		String tmp = "";
		int i = 0;
		for (UserObject item : items) {
			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += "<td class=NO>" + (i) + "</td>";
			tmp += "<td class=NAME>" + item.getUser_name() + "</td>";
			tmp += "<td>" + Utilities.checkValue(item.getUser_fullname()) + "</td>";
			tmp += "<td>" + Utilities.checkValue(item.getUser_address()) + "</td>";
			tmp += "<td>" + Utilities.checkValue(item.getUser_email()) + "</td>";
			tmp += "<td>" + Utilities.checkValue(item.getUser_homephone()) + "</td>";
			tmp += "<td class=ED><a href=\"/adv/user/ae?id=" + item.getUser_id()
					+ "  \"><img src=\"/adv/imgs/icons/edit.png\" class=\"icon\"/></a></td>";

			// ko hien thi xoa voi ng dang dang nhap vao he thong
			if (user.getUser_id() != item.getUser_id()) {
				tmp += "<td class=ED><a href=\"/adv/user/del?id=" + item.getUser_id()
						+ "\"  onclick=\"if(!confirm('Bạn có muốn xóa bản ghi này không?')) return false;\" ><img src=\"/adv/imgs/icons/delete.png\" class=\"icon\"></a></td>";
			} else {
				tmp += "<td class=ED><img src=\"/adv/imgs/icons/cancel.png\" class=\"icon\"></td>";
			}

			tmp += "<td class=ID>" + item.getUser_id() + "</td>";
			tmp += "</tr>";
		}
		tmp += "</table>";

		tmp += "<div class=\"note\">";
		tmp += "<img src=\"/adv/imgs/icons/edit.png\" class=\"icon\"/>Sửa\t";
		tmp += "<img src=\"/adv/imgs/icons/delete.png\" class=\"icon\"/>Xóa\t";
		tmp += "<img src=\"/adv/imgs/icons/cancel.png\" class=\"icon\"/>Hủy\t";
		tmp += "</div>";
		tmp += "<div id=\"pagelink\">Trang" + Utilities.getPaging(total, "/adv/user/view?", page, totalperpage)
				+ "&nbsp;&nbsp;&nbsp;&nbsp;";
		tmp += "(Tổng số: " + total + " người sử dụng.)</div>";
		return tmp;
	}
}
