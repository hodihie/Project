package haui.ads.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haui.ConnectionPool;
import haui.library.Utilities;
import haui.objects.UserObject;

/**
 * Servlet implementation class UserDel
 */
@WebServlet("/adv/user/del")
public class UserDel extends HttpServlet {
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
		
		// tim id nguoi su dung de xoa
		int id = Utilities.getIntParam(request, "id");
		if (id > 0 && id != user.getUser_id()) {//neu user dang dang nhap thi ko the xoa
			// tim bo quan ly ket noi
			ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
			UserControl uc = new UserControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("c_pool", uc.getConnectionPool());
			}

			// tao doi tuong luu thong tin de xoa
			UserObject dUser = new UserObject();
			dUser.setUser_id(id);

			// thuc hien xoa
			boolean result = uc.delUser(dUser);
			uc.releaseConnection();

			// thong bao
			if (result) {
				response.sendRedirect("/adv/user/view");
			} else {
				response.sendRedirect("/adv/user/view?err=notdel");
			}
		} else {
			response.sendRedirect("/adv/user/view");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
