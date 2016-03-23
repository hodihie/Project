package haui.ads.article;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haui.ConnectionPool;
import haui.objects.UserObject;

/**
 * Servlet implementation class ArticleView
 */
@WebServlet("/adv/article/view")
public class ArticleView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// tim thong tin dan nhap
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

		// tim bo quan ly ket noi
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		ArticleControl ac = new ArticleControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", ac.getConnectionPool());
		}

		// lay du lieu da duoc tao cau truc html
		String viewArticle = ac.viewArticles(null, 1, (byte) 15);//lay 15 ban ghi trang 1

		// tra ve ket noi
		ac.releaseConneciton();

		// goi header
		RequestDispatcher h = request.getRequestDispatcher("/adv/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"view\">");
		out.print("<table cellspacing=0>");
		
		out.print("<tr>");
		out.print("<td colspan=10>");
		out.print("<a href=\"/adv/article/ae\">Thêm mới</a>");		
		out.print("</td>");
		out.print("</tr>");
		
		out.print("<tr>");
		out.print("<th>STT</th>");
		out.print("<th>Ngày tạo</th>");
		out.print("<th>Tiêu đề</th>");
		out.print("<th>Tên thể loại</th>");
		out.print("<th>Tên chuyên mục</th>");
		out.print("<th>Tác giả</th>");
		out.print("<th>Số lượt xem</th>");
		out.print("<th colspan=2>Thực hiện</th>");
		out.print("<th>ID</th>");
		out.print("</tr>");

		out.print(viewArticle);

		out.print("</table>");
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
