/**
 * 
 */
package haui.library;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpSession;

import net.htmlparser.jericho.CharacterReference;

/**
 * @author Dinh Hieu
 *
 */
public class Utilities {
	// ma hoa chuoi unicode thanh chuoi html
	public static String encode(String strUNI) {
		return CharacterReference.encode(strUNI);
	}

	// giai ma chuoi html ve unicode
	public static String decode(String strHTML) {
		return CharacterReference.decode(strHTML);
	}

	// ************************************************
	public static byte getByteParam(ServletRequest request, String name) {
		byte value = -1;
		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Byte.parseByte(strValue);
		}

		return value;
	}

	public static short getShortParam(ServletRequest request, String name) {
		short value = -1;
		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Short.parseShort(strValue);
		}
		return value;
	}

	public static int getIntParam(ServletRequest request, String name) {
		int value = -1;
		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Integer.parseInt(strValue);
		}

		return value;
	}

	public static long getLongParam(ServletRequest request, String name) {
		long value = -1;
		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Long.parseLong(strValue);
		}

		return value;
	}

	public static double getDoubleParam(ServletRequest request, String name) {
		double value = -1;
		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			value = Double.parseDouble(strValue);
		}

		return value;
	}

	// get mobile phone
	public static String getMobilePhone(ServletRequest request, String name) {
		StringBuilder mobile = new StringBuilder();
		String strValue = request.getParameter(name);
		if (strValue != null && !strValue.equalsIgnoreCase("")) {
			strValue = strValue.substring(1);
			mobile.append("84");
			mobile.append(strValue);
		}

		return mobile.toString();
	}

	// check value
	public static String checkValue(String value) {
		if (value != null && !value.equalsIgnoreCase("")) {
			return value;
		} else {
			return "---";
		}
	}

	public static String checkValue(String value, boolean decode) {
		if (value != null && !value.equalsIgnoreCase("")) {
			if (decode) {
				return Utilities.decode(value);
			} else {
				return value;
			}
		} else {
			return "---";
		}
	}

	// paging
	public static int getPages(int total, int totalperpage) {
		int pages = total / totalperpage;
		if (total % totalperpage != 0) {
			pages++;
		}
		return pages;
	}

	// Lay tham so phan trang page
	public static int getPage(javax.servlet.ServletRequest request) {
		String strPage = request.getParameter("p");

		int page = 1;
		if (strPage != null && !strPage.equalsIgnoreCase("")) {
			page = Integer.parseInt(strPage);
		}
		return page;
	}

	// get total page
	public static byte getTotalperpage(javax.servlet.http.HttpServletRequest request, String name, String pageAt) {
		// ngam dinh so dong 1 trang la 15
		return Utilities.getTotalperpage(request, name, pageAt, (byte) 15);
	}

	public static byte getTotalperpage(javax.servlet.http.HttpServletRequest request, String name, String pageAt,
			byte default_total) {
		byte totalperpage = Utilities.getSELECTParamValue(request, "slcViewNumber");
		// System.out.println(totalperpage);
		if (totalperpage == 0) {
			totalperpage = Utilities.getSessionByteValue(request.getSession(), name);
			if (totalperpage == 0) {
				totalperpage = default_total;
			}
		} else {

			request.getSession().setAttribute(pageAt, null);
			request.getSession().setAttribute(name, totalperpage);
		}
		return totalperpage;
	}

	public static byte getSessionByteValue(HttpSession session, String name) {
		byte value = 0;
		Object obj = session.getAttribute(name);
		if (obj != null) {
			value = new Byte(obj.toString()).byteValue();
		}
		return value;
	}

	// Lay gia tri tham so (su dung cho SELECT), ngam dinh la 0
	public static byte getSELECTParamValue(ServletRequest request, String param) {
		return Utilities.getParamByteValue(request, param);
	}

	public static byte getParamByteValue(ServletRequest request, String param) {
		String strParam = request.getParameter(param);
		byte value = 0;
		if (strParam != null && !strParam.equalsIgnoreCase("")) {
			value = Byte.parseByte(strParam);
		}
		return value;
	}

	// get paging
	public static String getPaging(int total, String url, int page, int totalperpage) {
		int pages = Utilities.getPages(total, totalperpage);
		if (page > pages) {
			page = 1;
		}
		int count = 0;
		String tmp = "";
		for (int j = page - 1; j > 0; j--) {
			if (++count > 5) {
				break;
			}
			tmp = "<a href=\"" + url + "p=" + j + "\" class=\"plinks\"><span>" + j + "</span></a>" + tmp;
		}

		if (page > 6) {
			tmp = "..." + tmp;
			tmp = "<a href=\"" + url + "p=1\" class=\"plinks\"><span>" + 1 + "</span></a>" + tmp;
		}

		tmp += "&nbsp;&nbsp;<b>[" + page + "]</b>&nbsp;&nbsp;";
		count = 0;
		for (int j = page + 1; j <= pages; j++) {
			if (++count > 5) {
				break;
			}
			tmp += "<a href=\"" + url + "p=" + j + "\" class=\"plinks\"><span>" + j + "</span></a>";
		}

		if (pages > 5 + page) {
			tmp = tmp + "...";
			tmp += "<a href=\"" + url + "p=" + pages + "\" class=\"plinks\"><span>" + pages + "</span></a>";
		}

		return tmp;
	}

	// view option
	public static String viewOptions(int[] options, byte selected_index) {
		String tmp = "";
		for (int i = 0; i < options.length; i++) {
			if (options[i] == selected_index) {
				tmp += "<option value=" + options[i] + " selected>" + options[i] + "</option>";
			} else {
				tmp += "<option value=" + options[i] + ">" + options[i] + "</option>";
			}
		}
		return tmp;
	}

	public static int getCount(ResultSet rstotal) {
		if (rstotal != null) {
			try {
				if (rstotal.next()) {
					return rstotal.getInt("total");
				}
				rstotal.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return 0;
	}

}
