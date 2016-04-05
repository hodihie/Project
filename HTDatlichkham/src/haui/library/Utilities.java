/**
 * 
 */
package haui.library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletRequest;

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

}
