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

	/**
	 * 
	 */
	public DateUtils() {

	}

	// lay ngay he thong
	public static String getDate() {
		String format = "dd/MM/yyyy";
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = new Date();
		return sdf.format(date);
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

		return StringToMakeDate(s, "YYYYMMddHHmm");

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

		return getDateFormat(new Date(), "YYYYMMddHHmm");
	}

	public static String changeDateFormat(String sDate, String oldFormat, String newFormat) {
		if (StringUltils.isEmpty(sDate)) {
			return null;
		}
		return getDateFormat(StringToMakeDate(sDate, oldFormat), newFormat);
	}

	public static String getEarlierDate(String sDate1, String sDate2) {
		Date date1 = makeDate(sDate1);
		Date date2 = makeDate(sDate2);
		return date1.before(date2) ? sDate1 : sDate2;
	}

	public static String addMintue(String sYYYYMMDDHHSS, int minute) {

		if (StringUltils.isEmpty(sYYYYMMDDHHSS)) {
			return null;
		}

		if (sYYYYMMDDHHSS.length() != 12) {
			return null;
		}

		String resultStr = "";

		Date date;

		Calendar cal = Calendar.getInstance();

		DateFormat df = new SimpleDateFormat(sYYYYMMDDHHSS);

		date = makeDate(sYYYYMMDDHHSS);

		cal.setTime(date);

		cal.add(Calendar.MINUTE, minute);

		resultStr = df.format(cal.getTime());

		return resultStr;
	}

}
