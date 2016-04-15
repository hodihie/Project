/**
 * 
 */
package haui.library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Dinh Hieu
 *
 */
public class DateUtils {

	public static String DD_MM_YYYY = "dd/MM/yyyy";
	public static String YYYY_MM_DD_HH_MM = "yyyyMMddHHmm";
	public static String YYYY_MM_DD_HH_MM_SS = "yyyyMMddHHmmss";

	/**
	 * 
	 */
	public DateUtils() {

	}

	// lay ngay he thong
	public static String getDate() {
		String format = DD_MM_YYYY;
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		return sdf.format(date);
	}

	public static String getCurrentDateTime() {

		return getDateFormat(new Date(), YYYY_MM_DD_HH_MM);
	}

	public static String getCurrentDateTimess() {

		return getDateFormat(new Date(), YYYY_MM_DD_HH_MM_SS);
	}

	public static Date StringToMakeDate(String s, String format) {
		if (StringUltils.isEmpty(s) || StringUltils.isEmpty(format)) {
			return null;
		}

		DateFormat newDf = new SimpleDateFormat(format);
		try {
			Date retDate = newDf.parse(s);

			return retDate;

		} catch (ParseException e) {
			return null;
		}

	}

	public static Date makeDate(String s) {
		if (StringUltils.isEmpty(s)) {
			return null;
		}

		return StringToMakeDate(s, YYYY_MM_DD_HH_MM);

	}

	public static Date makeDateSS(String s) {
		if (StringUltils.isEmpty(s)) {
			return null;
		}

		return StringToMakeDate(s, YYYY_MM_DD_HH_MM_SS);

	}

	public static String getDateFormat(Date date, String newFormat) {

		if (date == null || StringUltils.isEmpty(newFormat)) {
			return null;
		}

		DateFormat newDf = new SimpleDateFormat(newFormat);
		String rtnDate;

		try {
			rtnDate = newDf.format(date);
		} catch (Exception e) {
			rtnDate = null;
		}
		return rtnDate;
	}

	public static String getCurrentYYYYMMDDHHMM() {

		return getDateFormat(new Date(), YYYY_MM_DD_HH_MM);
	}

	public static String changeDateFormat(String sDate, String oldFormat, String newFormat) {
		if (StringUltils.isEmpty(sDate)) {
			return null;
		}
		return getDateFormat(StringToMakeDate(sDate, oldFormat), newFormat);
	}

	public static boolean isEarlier(String sDate1, String sDate2) {
		Date date1 = makeDate(sDate1);
		Date date2 = makeDate(sDate2);
		return date1.before(date2);
	}

	public static String addMintue(String sYYYYMMDDHHMM, int minute) {

		if (StringUltils.isEmpty(sYYYYMMDDHHMM)) {
			return null;
		}

		if (sYYYYMMDDHHMM.length() != 12) {
			return null;
		}

		String resultStr = "";

		Date date;

		Calendar cal = Calendar.getInstance();

		DateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM);

		date = makeDate(sYYYYMMDDHHMM);

		cal.setTime(date);

		cal.add(Calendar.MINUTE, minute);

		resultStr = df.format(cal.getTime());

		return resultStr;
	}

	public static String roundTime15M(String sYYYYMMDDHHMM) {
		String resultStr = "";

		if (StringUltils.isEmpty(sYYYYMMDDHHMM)) {
			return null;
		}

		if (sYYYYMMDDHHMM.length() != 12) {
			return null;
		}

		Date date;

		Calendar cal = Calendar.getInstance();

		DateFormat df = new SimpleDateFormat(YYYY_MM_DD_HH_MM);

		date = makeDate(sYYYYMMDDHHMM);

		cal.setTime(date);

		int unroundedMinutes = cal.get(Calendar.MINUTE);
		int mod = unroundedMinutes % 15;
		cal.add(Calendar.MINUTE, mod < 8 ? -mod : (15 - mod));

		resultStr = df.format(cal.getTime());

		return resultStr;
	}

}
