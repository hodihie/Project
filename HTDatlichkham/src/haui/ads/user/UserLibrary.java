/**
 * 
 */
package haui.ads.user;

import java.util.ArrayList;

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

	public static String viewUsers(ArrayList<UserObject> items, UserObject user) {
		String tmp = "";
		int i = 0;
		for (UserObject item : items) {
			tmp += (++i % 2 == 0) ? "<tr class=\"even\">" : "<tr>";
			tmp += "<td class=NO>" + (i) + "</td>";
			tmp += "<td class=NAME>" + item.getUser_name() + "</td>";
			tmp += "<td>" + item.getUser_fullname() + "</td>";
			tmp += "<td>" + item.getUser_address() + "</td>";
			tmp += "<td>" + item.getUser_email() + "</td>";
			tmp += "<td>" + item.getUser_homephone() + "</td>";
			tmp += "<td class=ED><a href=\"/adv/user/ae?id=" + item.getUser_id() + "  \">Sửa</a></td>";

			// ko hien thi xoa voi ng dang dang nhap vao he thong
			if (user.getUser_id() != item.getUser_id()) {
				tmp += "<td class=ED><a href=\"/adv/user/del?id=" + item.getUser_id()
						+ "\"  onclick=\"if(!confirm('Bạn có muốn xóa bản ghi này không?')) return false;\" >Xóa</a></td>";
			} else {
				tmp += "<td class=ED>---</td>";
			}

			tmp += "<td class=ID>" + item.getUser_id() + "</td>";
			tmp += "</tr>";
		}
		return tmp;
	}
}
