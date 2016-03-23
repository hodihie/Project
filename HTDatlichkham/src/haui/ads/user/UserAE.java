package haui.ads.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haui.ConnectionPool;
import haui.library.Utilities;
import haui.objects.UserObject;

/**
 * Servlet implementation class UserAE
 */
@WebServlet("/adv/user/ae")
public class UserAE extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// tim thong tin dang nhap
		UserObject user = (UserObject) request.getSession().getAttribute("userLogined");

		if (user != null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/adv/user/login");
		}
	}

	private void view(HttpServletRequest request, HttpServletResponse response, UserObject user)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		// tim id nguoi su dung de sua neu co
		int id = Utilities.getIntParam(request, "id");
		String username = "", useremail = "";
		String fullname = "", address = "";

		String readonly = "";
		String lblSave = "Thêm tài khoản";
		boolean isExist = false;// kiem tra co ton tai khong

		// kiem tra id de sua
		if (id > 0) {

			// tim bo quan ly ket noi
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
			UserControl uc = new UserControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("c_pool", uc.getConnectionPool());
			}

			// lay ra doi tuong se sua
			UserObject eUser = uc.getUserObject(id);

			// tra ve ket noi
			uc.releaseConnection();

			// kiem tra doi tuong de sua
			if (eUser != null) {
				username = eUser.getUser_name();
				useremail = eUser.getUser_email();
				fullname = eUser.getUser_fullname();
				address = eUser.getUser_address();

				readonly = "readonly";
				lblSave = "Cập nhật";
				isExist = true;
			}
		}

		// goi header
		RequestDispatcher h = request.getRequestDispatcher("/adv/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"view\">");

		out.print("<form name=\"frmUser\" action=\"\" method=\"\">");
		out.print("<table cellspacing=0>");
		out.print("<tr><th colspan=2>Thông tin tài khoản</th></tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Tên tài khoản</td>");
		out.print("<td><input type=\"text\" name=\"txtUserName\" value=\"" + username + "\" " + readonly + " /></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Mật khẩu</td>");
		out.print("<td><input type=\"password\" name=\"txtUserPass\"/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Hộp thư</td>");
		out.print("<td><input type=\"text\" name=\"txtUserEmail\" value=\"" + useremail + "\" /></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Quyền thực thi</td>");
		out.print("<td>");
		out.print("<script language=\"JavaScript\">");
		out.print("generatePermis();");
		out.print("</script>");
		out.print("</td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Vai trò</td>");
		out.print("<td>");
		out.print("<table cellspacing=0>");
		out.print("<script language=\"JavaScript\">");
		out.print("generateRoles();");
		out.print("</script>");
		out.print("</table>");
		out.print("						");
		out.print("</td>");
		out.print("</tr>");

		out.print("<tr><th colspan=2>Thông tin chi tiết</th><tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Tên đầy đủ</td>");
		out.print("<td><input type=\"text\" name=\"txtFullName\"  value=\"" + fullname + "\"/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Bí danh</td>");
		out.print("<td><input type=\"text\" name=\"txtAlias\"/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Địa chỉ</td>");
		out.print("<td><input type=\"text\" name=\"txtAddress\" size=60 value=\"" + address + "\" /></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Phone</td>");
		out.print("<td><input type=\"text\" name=\"txtPhone\"/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Mobile</td>");
		out.print("<td><input type=\"text\" name=\"txtMobile\"/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Ngày sinh</td>");
		out.print("<td><input type=\"date\" name=\"txtBirthday\"/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Giới tính</td>");
		out.print("<td><select name=\"slcGender\">");
		out.print("<option value=\"0\">Nam</option>");
		out.print("<option value=\"1\">Nữ</option>");
		out.print("<option value=\"2\" selected>---</option>");
		out.print("</select></td>");
		out.print("</tr>");
		out.print("<!--Còn nhi\u1EC1u thông tin n\u1EEFa-->");

		out.print("<tr>");
		out.print("<td class=\"id\">Ghi chú</td>");
		out.print("<td>");
		out.print("<textarea name=\"txtNotes\" rows=10 cols=80></textarea>");
		out.print("</td>");
		out.print("</tr>");

		out.print("<tr><th colspan=2>Thông tin cơ quanlàm việc</th></tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Tên cơ quan, đơn vị</td>");
		out.print("<td><input type=\"text\" name=\"txtDepart\" size=60/></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Lĩnh vực</td>");
		out.print("<td><select name=\"slcJabAre\">");
		out.print("<option value=\"0\">---Chọn lĩnh vực---</option>");
		out.print("<option value=\"1\">Giáo dục & đào tạo</option>");
		out.print("<option value=\"2\">Công nghệ & Viễn thông</option>");
		out.print("<option value=\"3\">Khoa học, xã hội</option>");
		out.print("<option value=\"100\">Lĩnh vực khác...</option>");
		out.print("</select></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td colspan=2 align=\"center\">");
		out.print("<input type=\"button\" value=\"" + lblSave + "\" onClick=\"saveUser(this.form)\"/>");
		out.print("<input type=\"button\" value=\"Nhập lại\" onclick=\"setFirstTime(this.form)\"/>");
		out.print("<input type=\"button\" value=\"Trở về\" onClick=\"location.back()\"/><!--window.location.back()-->");
		out.print("<input type=\"button\" value=\"Thoát\" onClick=\"window.close();\"/>");
		out.print("</td>");
		out.print("</tr>					");
		out.print("</table>");

		if (isExist) {
			// truyen id sang doPost de cap nhat
			// theo co che bien form an
			out.println("<input type=\"hidden\" name=\"idForPost\" value=\"" + id + "\" />");
		}

		out.print("</form>");

		out.print("</div>");

		// goi footer
		RequestDispatcher f = request.getRequestDispatcher("/adv/footer");
		if (f != null) {
			f.include(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// khai bao tap ky tu can lay
		request.setCharacterEncoding("UTF-8");

		// lay du lieu tren giao dien
		int id = Utilities.getIntParam(request, "idForPost");
		String username = request.getParameter("txtUserName");
		String userpass = request.getParameter("txtUserPass");
		String useremail = request.getParameter("txtUserEmail");

		// kiem tra 3 thong tin bat buọc
		if (username != null && userpass != null && useremail != null) {
			// cat bo cac khoan trongvo nghia
			username = username.trim();
			userpass = userpass.trim();
			useremail = useremail.trim();

			// kiem tra su ton tai cua gia tri
			if (!username.equalsIgnoreCase("") && !userpass.equalsIgnoreCase("") && !useremail.equalsIgnoreCase("")) {
				// lay tiep du lieu
				String fullname = request.getParameter("txtFullName");
				String alias = request.getParameter("txtAlias");
				String address = request.getParameter("txtAddress");
				String phone = request.getParameter("txtPhone");

				// tao doi tuong de luu tru thong tin
				UserObject nUser = new UserObject();
				nUser.setUser_name(username);
				nUser.setUser_pass(userpass);
				nUser.setUser_email(useremail);
				nUser.setUser_fullname(Utilities.encode(fullname));
				nUser.setUser_address(Utilities.encode(address));
				nUser.setUser_homephone(phone);

				// tim bo quan ly ket noi
				ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
				UserControl uc = new UserControl(cp);

				if (cp == null) {
					getServletContext().setAttribute("c_pool", uc.getConnectionPool());
				}

				// thuc hien
				boolean result;
				if (id > 0) {
					// cap nhat
					nUser.setUser_id(id);
					result = uc.editUser(nUser);
				} else {
					result = uc.addUser(nUser);
				}

				// tra ve ket noi
				uc.releaseConnection();

				// kiem tra ket qua thuc hien
				if (result) {
					response.sendRedirect("/adv/user/view");
				} else {
					response.sendRedirect("/adv/user/ae?err?notok");
				}
			} else {
				response.sendRedirect("/adv/user/ae?err=value");
			}

		} else {
			response.sendRedirect("/adv/user/ae?err=param");
		}
	}

}
