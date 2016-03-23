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
import haui.ads.user.UserControl;
import haui.library.Utilities;
import haui.objects.ArticleObject;
import haui.objects.UserObject;

/**
 * Servlet implementation class ArticleAE
 */
@WebServlet("/adv/article/ae")
public class ArticleAE extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// tim thong tin dang nhap
		UserObject user = (UserObject) request.getSession().getAttribute(
				"userLogined");

		if (user != null) {
			view(request, response, user);
		} else {
			response.sendRedirect("/adv/user/login");
		}
	}

	private void view(HttpServletRequest request, HttpServletResponse response,
			UserObject user) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out = response.getWriter();

		// tim id bai viet de sua neu co
		int id = Utilities.getIntParam(request, "id");
		String articletitle = "", articlesummary = "";
		String articlecontent = "", articletag = "";
		short articlesection, articlecategory;

		String readonly = "";
		String lblSave = "Thêm bài viết";
		boolean isExist = false;// kiem tra co ton tai khong

		// kiem tra id de sua
		if (id > 0) {

			// tim bo quan ly ket noi
			ConnectionPool cp = (ConnectionPool) getServletContext()
					.getAttribute("c_pool");
			ArticleControl ac = new ArticleControl(cp);
			if (cp == null) {
				getServletContext().setAttribute("c_pool",
						ac.getConnectionPool());
			}

			// lay ra doi tuong se sua
			ArticleObject eArticle = ac.getArticleObject(id);

			// tra ve ket noi
			ac.releaseConneciton();

			// kiem tra doi tuong de sua
			if (eArticle != null) {

				articletitle = eArticle.getArticle_title();
				articlesummary = eArticle.getArticle_summary();
				articlecontent = eArticle.getArticle_content();
				articlesection = eArticle.getSection_id();
				articlecategory = eArticle.getCategory_id();
				articletag = eArticle.getArticle_tag();

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
		// load js
		out.print("<script type=\"text/javascript\" src=\"/adv/adjs/ckfinder/ckfinder.js\"></script>");
		out.print("<script type=\"text/javascript\" src=\"/adv/adjs/ckeditor/ckeditor.js\"></script>");
		
		out.print("<div class=\"view\">");
		out.print("<form name=\"frmArticle\" action=\"\" method=\"\">");
		out.print("<table cellspacing=0>");
		out.print("<tr><th colspan=2>Thông tin bài viết</th></tr>");
		out.print("					");
		out.print("<tr>");
		out.print("<td class=\"lc\">Tiêu đề</td>");
		out.print("<td><input type=\"text\" name=\"txtArticleTitle\" value=\""
				+ articletitle + "\"/></td>");
		out.print("</tr>");
		out.print("					");
		out.print("<tr>");
		out.print("<td class=\"lc\">Tóm tắt</td>");
		out.print("<td>");
		out.print("<textarea name=\"txtArticleSummary\" rows=6 cols=80>"
				+ articlesummary + "</textarea>");
		out.print("</td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Nội dung</td>");
		out.print("<td><textarea id=\"txtArticleContent\"  name=\"txtArticleContent\" rows=30 cols=80>"
				+ articlecontent + "</textarea></td>");
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td class=\"lc\">Hình ảnh</td>");
		out.print("<td><input type=\"file\" name=\"txtArticleImage\"/></td>");
		out.print("</tr>");
		out.print("					");
		out.print("<tr>");
		out.print("<td class=\"lc\">Chuyên mục</td>");
		out.print("<td><select name=\"slcArticleSection\">");
		out.print("<option value=\"0\">abc</option>");
		out.print("<option value=\"1\">def</option>");
		out.print("<option value=\"2\" selected>---</option>");
		out.print("</select></td>");
		out.print("</tr>");
		out.print("					");
		out.print("<tr>");
		out.print("<td class=\"lc\">Thể loại</td>");
		out.print("<td><select name=\"slcArticleCategory\">");
		out.print("<option value=\"0\">123</option>");
		out.print("<option value=\"1\">456</option>");
		out.print("<option value=\"2\" selected>---</option>");
		out.print("</select></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td class=\"lc\">Liên kết</td>");
		out.print("<td><input type=\"text\" name=\"txtArticleUrlLink\"/></td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td class=\"lc\">Từ khóa</td>");
		out.print("<td><input type=\"text\" name=\"txtArticleTag\"/></td>");
		out.print("</tr>");
		// Còn nhiều thông tin nữa
		out.print("					");
		out.print("<tr>");
		out.print("<td class=\"lc\">Ghi chú</td>");
		out.print("<td>");
		out.print("<textarea name=\"txtArticleNotes\" rows=10 cols=80></textarea>");
		out.print("</td>");
		out.print("</tr>				");
		out.print("<tr>");
		out.print("<td colspan=2 align=\"center\">");
		out.print("<input type=\"button\" value=\"" + lblSave
				+ "\" onClick=\"saveArticle(this.form)\"/>");

		out.print("<input type=\"button\" value=\"Nhập lại\" onclick=\"setFirstTime(this.form)\"/>");
		out.print("<input type=\"button\" value=\"Trở về\" onClick=\"window.history.back();\"/>");
		out.print("<input type=\"button\" value=\"Thoát\" onClick=\"window.close();\"/>");
		out.print("</td>");
		out.print("</tr>					");
		out.print("</table>");

		// truyen id snag doPost de cap nhat
		out.print("<input type=\"hidden\" name=\"idForPost\" value=\"" + id
				+ "\"/>");

		// replace textarea with ckeditor
		out.print("<script>");
		out.print("if (typeof CKEDITOR !== 'undefined') {");
		out.print("CKEDITOR.addCss('img {max-width:100%; height: auto;}');");
		out.print("var editor = CKEDITOR.replace('txtArticleContent', {");
		out.print("extraPlugins : 'uploadimage,image2',");
		out.print("removePlugins : 'image',");
		out.print("height : 350			");
		out.print("});			");
		out.print("CKFinder.setupCKEditor(editor,'/adv/adjs/ckfinder/');");
		out.print("}");
		out.print("</script>");
		
		out.print("</form>");

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
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// khai boa tap ky tu can lay
		request.setCharacterEncoding("UTF-8");

		// lay du lieu tren giao dien
		int id = Utilities.getIntParam(request, "idForPost");
		String articletitle = request.getParameter("txtArticleTitle");
		short articlesectionid = Short.parseShort(request
				.getParameter("slcArticleSection"));
		short articlecategoryid = Short.parseShort(request
				.getParameter("slcArticleCategory"));

		// kiem tra 3 thong tin bat buọc
		if (articletitle != null && articlesectionid > -1
				&& articlecategoryid > -1) {
			// cat bo cac khoang trong vo nghia
			articletitle = articletitle.trim();

			// kiem tra su ton tai cua gia tri
			if (!articletitle.equalsIgnoreCase("")) {

				// lay tiep du lieu
				String createddate = Utilities.getDate();
				String articlesummary = request
						.getParameter("txtArticleSummary");
				String articlecontent = request
						.getParameter("txtArticleContent");
				// String fullname = request.getParameter("txtFullName");
				// String alias = request.getParameter("txtAlias");
				// String address = request.getParameter("txtAddress");
				// String phone = request.getParameter("txtPhone");

				// tao doi tuong de luu tru thong tin
				ArticleObject nArticle = new ArticleObject();
				nArticle.setArticle_title(articletitle);
				nArticle.setArticle_summary(articlesummary);
				nArticle.setArticle_content(articlecontent);
				nArticle.setArticle_created_date(createddate);

				// tim bo quan ly ket noi
				ConnectionPool cp = (ConnectionPool) getServletContext()
						.getAttribute("c_pool");
				ArticleControl ac = new ArticleControl(cp);

				if (cp == null) {
					getServletContext().setAttribute("c_pool",
							ac.getConnectionPool());
				}

				// thuc hien
				boolean result;
				if (id > 0) {
					// cap nhat
					nArticle.setArticle_id(id);
					result = ac.editArticle(nArticle);
				} else {
					result = ac.addArticle(nArticle);
				}

				// tra ve ket noi
				ac.releaseConneciton();

				// kiem tra ket qua thuc hien
				if (result) {
					response.sendRedirect("/adv/article/view");
				} else {
					response.sendRedirect("/adv/article/ae?err?notok");
				}
			} else {
				response.sendRedirect("/adv/article/ae?err=value");
			}

		} else {
			response.sendRedirect("/adv/article/ae?err=param");
		}
	}

}
