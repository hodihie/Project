package haui.ads.statistic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import haui.ConnectionPool;
import haui.library.DateUtils;
import haui.objects.UserObject;

/**
 * Servlet implementation class StatisticView
 */
@WebServlet("/adv/statistic/view")
public class StatisticView extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=UTF-8";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StatisticView() {
		super();
	}

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

		// tim bo quanly ket noi
		ConnectionPool cp = (ConnectionPool) getServletContext().getAttribute("c_pool");
		StatisticControl sc = new StatisticControl(cp);
		if (cp == null) {
			getServletContext().setAttribute("c_pool", sc.getConnectionPool());
		}

		String currentDate = DateUtils.getCurrentDateTime0000();
		int number = 7;

		// lay du lieu da duoc tao cau truc html
		String categories = sc.getCategory(currentDate, number);
		String series = sc.getSeries(currentDate, number);

		// tra ve ket noi
		sc.releaseConnection();

		// goi header
		RequestDispatcher h = request.getRequestDispatcher("/adv/header");
		if (h != null) {
			h.include(request, response);
		}

		out.print("<div class=\"view\">");

		out.print("<script type=\"text/javascript\" src=\"/adv/adjs/statistic/jquery.min.js\"></script>");
		out.print("<script src=\"/adv/adjs/statistic/highcharts.js\"></script>");
		out.print("<script src=\"/adv/adjs/statistics/exporting.js\"></script>");
		out.print("<script type=\"text/javascript\">");
		out.print("$(function () {");
		out.print("$('#container').highcharts({");
		out.print("chart: {");
		out.print("type: 'column'");
		out.print("},");
		out.print("title: {");
		out.print("text: 'Thống kê lịch khám 7 ngày gần đây'");
		out.print("},");
		out.print("subtitle: {");
		out.print("text: 'Theo từng ngày'");
		out.print("},");
		out.print("xAxis: {");
		out.print("categories: " + categories + ",");

		out.print("crosshair: true");
		out.print("},");
		out.print("yAxis: {");
		out.print("min: 0,");
		out.print("title: {");
		out.print("text: 'Số lượng'");
		out.print("}");
		out.print("},");
		out.print("tooltip: {");
		out.print("headerFormat: '<span style=\"font-size:10px\">{point.key}</span><table>',");
		out.print("pointFormat: '<tr><td style=\"color:{series.color};padding:0\">{series.name}: </td>' +");
		out.print("'<td style=\"padding:0\"><b>{point.y:.1f} </b></td></tr>',");
		out.print("footerFormat: '</table>',");
		out.print("shared: true,");
		out.print("useHTML: true");
		out.print("},");
		out.print("plotOptions: {");
		out.print("column: {");
		out.print("pointPadding: 0.2,");
		out.print("borderWidth: 0");
		out.print("}");
		out.print("},");
		out.print("series: " + series + "");

		out.print("});");
		out.print("});");
		out.print("</script>");
		out.print("<div id=\"container\" style=\"min-width: 310px; height: 400px; margin: 0 auto\"></div>");

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
		doGet(request, response);
	}

}
