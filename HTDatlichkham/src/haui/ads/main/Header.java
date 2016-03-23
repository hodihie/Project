package haui.ads.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haui.objects.UserObject;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

/**
 * Servlet implementation class Header
 */
@WebServlet("/adv/header")
public class Header extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Header() {
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		PrintWriter out= response.getWriter();
		
		UserObject user= (UserObject) request.getSession().getAttribute("userLogined");
		
		out.print("<html>");
	    out.print("<head>");
	    out.print("<title>Hệ quản trị nội dung </title>");
	    out.print(
	        "<link rel=\"stylesheet\" href=\"/adv/adcss/layout.css\" type=\"text/css\"/>");
	    out.print("<script language=\"JavaScript\" src=\"/adv/adjs/user.js\"></script>");	   
	    out.print("<script language=\"JavaScript\" src=\"/adv/adjs/article.js\"></script>");
	    out.print("</head>");

	    out.print("<body>");
	    out.print("<div id=\"main\">");
	    out.print("<div class=\"logo\"></div>");

	    out.print("<div class=\"acc\">");
	    out.print("<h3>Quyền quản trị</h3>");
	    out.print("Tên đăng nhập: " + user.getUser_name() + " (" +
	              user.getUser_fullname() + ")&nbsp;&nbsp;|&nbsp;&nbsp;");
	    out.print("<a href=\"#\">Xem thông tin</a>&nbsp;&nbsp;|&nbsp;&nbsp;");
	    out.print("<a href=\"#\">Thoát</a>");
	    out.print("</div>");

	    out.print("<div class=\"clr\"></div>");
	    
	    //goi menu
	    RequestDispatcher m = request.getRequestDispatcher("/adv/menu");
	    if(m!=null){
	    	m.include(request, response);
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
