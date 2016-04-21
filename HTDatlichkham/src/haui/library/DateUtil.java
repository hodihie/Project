/*********************************************************************
 * 日付の取得及び日付の変換を行う部品を提供します。
 * 画面及びＷｅｂＵｔｉｌｉｔｙよりの呼び出しが可能です。
 * @@
 * DateUtil.java
 * Webシステム　共通部品
 *
 * クラス一覧
 *     No  クラス名                概要
 *     01  DateUtil　　　　　      日付の取得及び日付の変換を行う部品を提供します。
 *
 * 履歴
 *     No  日付        Ver         更新者            内容
 *     01  2005/10/11　V1.0L1.00　 富士通)棚橋 弘智  初版         
 *     02  2007/12/21　V1.0L1.01　 富士通)祖山 弘行  NF083-02 アクセシビリティ対応
 *     03  2014/04/24  V1.0L1.02   富士通）塩川 航   NF466 運用商品一覧画面変更対応
 *     04  2015/07/22　V2.0L1.00　 富士通)柳田 高    次期シス更改対応
 *
 * Copyright(C) FUJITSU LIMITED 2005 
 *
 * @author  富士通）棚橋 弘智
 *********************************************************************/
package haui.library;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日付の取得及び日付の変換を行う部品のの集合クラスです。
 * 
 * @@ DateUtil
 * @note
 * @version V1.0L1.00 2005/10/11
 * @author 富士通）棚橋 弘智
 * @@ 履歴 No 日付 Ver 更新者 内容 01 2005/10/11　V1.0L1.00　 富士通)棚橋 弘智 初版
 * 
 */
public final class DateUtil {

	/**
	 * 日付のフォーマット（yyyyMMdd）です。
	 */
	public static final String YYYYMMDD = "yyyyMMdd";

	/**
	 * 日付のフォーマット（yyyy.M.d）です。
	 */
	public static final String YYYYMMDD_PERIOD = "yyyy.M.d";

	/**
	 * 日付のフォーマット（yyyy年MM月）です。
	 */
	public static final String JAPANESE_YEAR_MONTH = "yyyy年MM月";

	/**
	 * 日付のフォーマット（M月d日）です。
	 */
	public static final String JAPANESE_SHORT_DATE = "M月d日";

	/**
	 * 日付のフォーマット（yyyy年M月d日）です。
	 */
	public static final String JAPANESE_DATE = "yyyy年M月d日";

	/**
	 * 日付のフォーマット（yyyy年MM月dd日）です。
	 */
	public static final String JAPANESE_DATE_N_ZERO = "yyyy年MM月dd日";

	/**
	 * 日付のフォーマット（yyyy年M月d日（E））です。
	 */
	public static final String JAPANESE_WEEK_DATE = "yyyy年M月d日（E）";

	// TODO NF083-02 アクセシビリティ対応 start 祖山
	/**
	 * 日付のフォーマット（yyyy年M月d日　E曜日）です。
	 */
	public static final String JAPANESE_WEEK_DAY_DATE = "yyyy年M月d日　E曜日";

	// TODO NF083-02 アクセシビリティ対応 end 祖山

	/**
	 * 日付のフォーマット（yyyyMMddHHmmss）です。
	 */
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyyMMddHHmmss";

	/**
	 * 日付のフォーマット（yyyyMMddHHmmssSSS）です。
	 */
	public static final String YYYY_MM_DD_HH_MM_SS_SSS = "yyyyMMddHHmmssSSS";

	/**
	 * 日付のフォーマット（yyyyMMddHHmm）です。
	 */
	public static final String YYYY_MM_DD_HH_MM = "yyyyMMddHHmm";

	/**
	 * 日付のフォーマット（HHmmss）です。
	 */
	public static final String HH_MM_SS = "HHmmss";

	/**
	 * 日付のフォーマット（yyyyMM）です。
	 */
	public static final String YYYY_MM = "yyyyMM";

	/**
	 * 日付のフォーマット（yyyyMM）です。
	 */
	public static final String MONTH = "M月";

	/**
	 * 日付のフォーマット（MM）です。
	 */
	public static final String MM = "MM";

	// 20140424 NF466 運用商品一覧画面変更対応 insert start
	/**
	 * 日付のフォーマット（yyyy年M月）です。
	 */
	public static final String JAPANESE_YEAR_MONTH_SUPPRES = "yyyy年M月";

	// 20140424 NF466 運用商品一覧画面変更対応 insert end

	/**
	 * デフォルトコンストラクタ です。
	 */
	private DateUtil() {
	}

	/**
	 * yyyyMMddからyyyy.MM.ddに変換します。
	 * 
	 * @@ convertToDateString
	 * @note ゼロサプレスあり
	 * @param yyyymmdd
	 *            年月日
	 * @return yyyy.MM.dd形式の日付文字列
	 * @@
	 */
	public static String convertToDateString(String yyyymmdd) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(yyyymmdd)) {
			return null;
		}

		// 引数が8桁で無い場合はnullを返します。
		if (yyyymmdd.length() != 8) {
			return null;
		}

		return getDateFormat(
				StringToMakeDate(yyyymmdd, YYYYMMDD),
				YYYYMMDD_PERIOD);

	}

	/**
	 * yyyyMMからyyyy年MM月に変換します。
	 * 
	 * @@ convertToDateStringYYYYMM
	 * @note ゼロサプレスなし
	 * @param yyyymm
	 *            yyyyMM型の文字列
	 * @return yyyy年MM月形式の日付文字列
	 * @@
	 */
	public static String convertToDateStringYYYYMM(String yyyymm) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(yyyymm)) {
			return null;
		}

		// 引数が6桁で無い場合はnullを返します。
		if (yyyymm.length() != 6) {
			return null;
		}

		return getDateFormat(
				StringToMakeDate(yyyymm, YYYY_MM),
				JAPANESE_YEAR_MONTH);
	}

	/**
	 * yyyyMMddからyyyy年MM月dd日に変換します。
	 * 
	 * @@ convertToDateString
	 * @note ゼロサプレスなし
	 * @param yyyymmdd
	 *            年月日
	 * @return yyyy年MM月dd日形式の日付文字列
	 * @@
	 */
	public static String convertToDateStringYYYYMMDD(String yyyymmdd) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(yyyymmdd)) {
			return null;
		}

		// 引数が8桁で無い場合はnullを返します。
		if (yyyymmdd.length() != 8) {
			return null;
		}

		return getDateFormat(
				StringToMakeDate(yyyymmdd, YYYYMMDD),
				JAPANESE_DATE_N_ZERO);

	}

	/**
	 * yyyyMMからM月に変換します。
	 * 
	 * @@ convertToDateStringMM
	 * @note ゼロサプレスあり
	 * @param yyyymm
	 *            yyyyMM型の文字列
	 * @return M月形式の日付文字列
	 * @@
	 */
	public static String convertToDateStringMM(String yyyymm) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(yyyymm)) {
			return null;
		}

		// 引数が6桁で無い場合はnullを返します。
		if (yyyymm.length() != 6) {
			return null;
		}

		return getDateFormat(StringToMakeDate(yyyymm, YYYY_MM), MONTH);
	}

	/**
	 * Date型をYYYYMMDD形式の日付文字列に変換します。
	 * 
	 * @@ dateFormat
	 * @note ゼロサプレスなし
	 * @param d
	 *            変換する日付データ
	 * @return yyyyMMdd形式の日付文字列
	 * @@
	 */
	public static String dateFormat(Date d) {

		return getDateFormat(d, YYYYMMDD);

	}

	/**
	 * Date型をM月D日形式の日付文字列に変換します。
	 * 
	 * @@ dateToMMDD
	 * @note ゼロサプレスあり
	 * @param d
	 *            変換する日付データ
	 * @return M月D日形式の日付文字列
	 * @@
	 */
	public static String dateToMMDD(Date d) {

		return getDateFormat(d, JAPANESE_SHORT_DATE);

	}

	/**
	 * Date型をYYYY年M月D日形式の日付文字列に変換します。
	 * 
	 * @@ dateToYYYYMMDD
	 * @note ゼロサプレスあり
	 * @param d
	 *            変換する日付
	 * @return YYYY年M月D日形式の日付文字列
	 * @@
	 */
	public static String dateToYYYYMMDD(Date d) {

		return getDateFormat(d, JAPANESE_DATE);

	}

	/**
	 * 現在時刻をyyyyMMddHHmmssで取得します。
	 * 
	 * @@ getCurrentDateTime
	 * @note ゼロサプレスなし
	 * @return yyyyMMddHHmmss形式の日付文字列
	 * @@
	 */
	public static String getCurrentDateTime() {

		return getDateFormat(new Date(), YYYY_MM_DD_HH_MM_SS);
	}

	/**
	 * 現在時刻をyyyyMMddHHmmssSSSで取得します。
	 * 
	 * @@ getCurrentDateTimeSSS
	 * @note ゼロサプレスなし
	 * @return yyyyMMddHHmmssSSS形式の日付文字列
	 * @@
	 */
	public static String getCurrentDateTimeSSS() {

		return getDateFormat(new Date(), YYYY_MM_DD_HH_MM_SS_SSS);
	}

	/**
	 * 現在時刻をHHmmssで取得します。
	 * 
	 * @@ getCurrentDateTimeSSS
	 * @note ゼロサプレスなし
	 * @return HHmmss形式の日付文字列
	 * @@
	 */
	public static String getCurrentTime() {

		return getDateFormat(new Date(), HH_MM_SS);
	}

	/**
	 * 現在時刻をYYYYMMDDHHMMで取得します。
	 * 
	 * @@ getCurrentYYYYMMDD
	 * @note ゼロサプレスあり
	 * @return YYYYMMDDHHMM形式の日付文字列
	 * @@
	 */
	public static String getCurrentYYYYMMDDHHMM() {

		return getDateFormat(new Date(), YYYY_MM_DD_HH_MM);
	}

	/**
	 * 現在時刻をyyyy年M月d日で取得します。
	 * 
	 * @@ getCurrentYYYYMMDD
	 * @note ゼロサプレスあり
	 * @param workSpace  ワークスペース
	 * @return yyyy年M月d日形式の日付文字列
	 * @@
	 */
	public static String getCurrentYYYYMMDD(COM_p_WorkSpace workSpace) {
		//現在日をyyyy年M月d日形式の文字列で返却する。
		//現在日は以下の優先順位で取得し、存在しない場合に次の優先順位のものを返却する。
		//1.ワークスペースの現在日
		String currentDate;
		if (workSpace != null) {
			currentDate = workSpace.getCurrentDate();
			if (!StringUtils.isEmpty(currentDate)) {
				return getDateFormat(
						StringToMakeDate(currentDate, YYYYMMDD),
						JAPANESE_DATE);
			}
		}
		//2.プロパティファイルの基準日
		//・DateManagement.propertiesから「REFERENCEDATE」
		//をキーとして取得してください。詳細はプロパティファイル設定値一覧.xlsxを参照
		currentDate = Utility.getPropertyValue(
				"DateManagement",
				"REFERENCEDATE");

		if (!StringUtils.isEmpty(currentDate)) {
			return getDateFormat(
					StringToMakeDate(currentDate, YYYYMMDD),
					JAPANESE_DATE);
		}
		////3.システム日付
		return getDateFormat(new Date(), JAPANESE_DATE);
	}

	/**
	 * 現在時刻をyyyy年M月d日（E）で取得します。
	 * 
	 * @@ getCurrentYYYYMMDDW
	 * @note ゼロサプレスあり
	 * @param workSpace  ワークスペース
	 * @return yyyy年M月d日（E）形式の日付文字列
	 * @@
	 */
	public static String getCurrentYYYYMMDDW(COM_p_WorkSpace workSpace) {
		//現在日をyyyy年M月d日（E）形式の文字列で返却する。
		//現在日は以下の優先順位で取得し、存在しない場合に次の優先順位のものを返却する。
		//1.ワークスペースの基準日
		String currentDate;
		if (workSpace != null) {
			currentDate = workSpace.getCurrentDate();
			if (!StringUtils.isEmpty(currentDate)) {
				return getDateFormat(
						StringToMakeDate(currentDate, YYYYMMDD),
						JAPANESE_WEEK_DATE);
			}
		}
		//2.プロパティファイルの基準日
		//・DateManagement.propertiesから「REFERENCEDATE」
		//をキーとして取得してください。詳細はプロパティファイル設定値一覧.xlsxを参照
		currentDate = Utility.getPropertyValue(
				"DateManagement",
				"REFERENCEDATE");

		if (!StringUtils.isEmpty(currentDate)) {
			return getDateFormat(
					StringToMakeDate(currentDate, YYYYMMDD),
					JAPANESE_WEEK_DATE);
		}
		//3.システム日付
		return getDateFormat(new Date(), JAPANESE_WEEK_DATE);
	}

	/**
	 * 現在時刻をyyyy年M月d日 E曜日で取得します。
	 * 
	 * @@ getCurrentYYYYMMDDWD
	 * @note ゼロサプレスあり
	 * @param workSpace  ワークスペース
	 * @return yyyy年M月d日 E曜日形式の日付文字列
	 * @@
	 */
	public static String getCurrentYYYYMMDDWD(COM_p_WorkSpace workSpace) {
		//現在日をyyyy年M月d日　E曜日形式の文字列で返却する。
		//現在日は以下の優先順位で取得し、存在しない場合に次の優先順位のものを返却する。
		//1.ワークスペースの基準日
		String currentDate;
		if (workSpace != null) {
			currentDate = workSpace.getCurrentDate();
			if (!StringUtils.isEmpty(currentDate)) {
				return getDateFormat(
						StringToMakeDate(currentDate, YYYYMMDD),
						JAPANESE_WEEK_DAY_DATE);
			}
		}
		//2.プロパティファイルの基準日
		//・DateManagement.propertiesから「REFERENCEDATE」
		//をキーとして取得してください。詳細はプロパティファイル設定値一覧.xlsxを参照
		currentDate = Utility.getPropertyValue(
				"DateManagement",
				"REFERENCEDATE");

		if (!StringUtils.isEmpty(currentDate)) {
			return getDateFormat(
					StringToMakeDate(currentDate, YYYYMMDD),
					JAPANESE_WEEK_DAY_DATE);
		}

		//3.システム日付
		return getDateFormat(new Date(), JAPANESE_WEEK_DAY_DATE);
	}

	/**
	 * 現在時刻をyyyyMMddで取得します。
	 * 
	 * @@ getCurrentDate
	 * @note ゼロサプレスなし
	 * @param workSpace  ワークスペース
	 * @return yyyyMMdd形式の日付文字列
	 * @@
	 */
	public static String getCurrentDate(COM_p_WorkSpace workSpace) {
		//現在日をyyyyMMdd形式の文字列で返却する。
		//返却する現在日は以下の優先順位で取得し、存在しない場合に次の優先順位のものを返却する。
		//1.ワークスペースの基準日
		String currentDate;
		if (workSpace != null) {
			currentDate = workSpace.getCurrentDate();
			if (!StringUtils.isEmpty(currentDate)) {
				return getDateFormat(
						StringToMakeDate(currentDate, YYYYMMDD),
						YYYYMMDD);
			}
		}
		//2.プロパティファイルの基準日
		//・DateManagement.propertiesから「REFERENCEDATE」
		//をキーとして取得してください。詳細はプロパティファイル設定値一覧.xlsxを参照
		currentDate = Utility.getPropertyValue(
				"DateManagement",
				"REFERENCEDATE");

		if (!StringUtils.isEmpty(currentDate)) {
			return getDateFormat(
					StringToMakeDate(currentDate, YYYYMMDD),
					YYYYMMDD);
		}
		//3.システム日付
		return getDateFormat(new Date(), YYYYMMDD);
	}

	/**
	 * 生年月日と現在日から、年齢を計算します。
	 * @@
	 * getYearAge
	 * @note  
	 * @param byyyymmdd 生年月日の日付文字列
	 * @param workSpace  ワークスペース
	 * @return 年齢
	 * @@
	 */
	public static Integer getYearAge(String byyyymmdd, COM_p_WorkSpace workSpace) {

		//生年月日から年度年齢を計算し返却する。
		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(byyyymmdd)) {
			return null;
		}

		//引数がnull、または空文字の場合、8桁で無い場合はnullを返却する。
		if (byyyymmdd.length() != 8) {
			return null;
		}
		//現在日は以下の優先順位で取得し、存在しない場合に次の優先順位のものを返却する。
		//1.ワークスペースの基準日
		//2.プロパティファイルの基準日
		//3.システム日付
		String currentDate = getCurrentDate(workSpace);

		// 数値でない場合はnullを返します。
		try {
			Integer.parseInt(byyyymmdd);
		} catch (NumberFormatException e) {
			return null;
		}

		try {
			//日付を年、月、日に分割します。
			int byyyy = Integer.parseInt(byyyymmdd.substring(0, 4));
			int bmm = Integer.parseInt(byyyymmdd.substring(4, 6));
			int bdd = Integer.parseInt(byyyymmdd.substring(6));
			int yyyy = Integer.parseInt(currentDate.substring(0, 4));
			int mm = Integer.parseInt(currentDate.substring(4, 6));
			int dd = Integer.parseInt(currentDate.substring(6));

			//現在の年から生年月日の年を引きます。
			int ret = yyyy - byyyy;

			// 現在の月が生年月日の月より小さい場合
			if (mm < bmm) {
				// まだ誕生日を迎えていないので1歳引きます。
				ret--;
			}
			// 現在の月が生年月日の月と同じでかつ現在の日が生年月日の日より小さい場合
			if ((mm == bmm) && (dd < bdd)) {
				// まだ誕生日を迎えていないので1歳引きます。
				ret--;
			}
			//4/2～翌年4/1を1年（年度）と見做し、引数の生年月日が今年度で何歳になるかを計算する。
			if (currentDate.substring(4, 8).compareTo("0401") <= 0
					&& byyyymmdd.substring(4, 8).compareTo("0401") <= 0) {
				ret--;
			}
			// 求めた年齢を返却します。
			return new Integer(ret);

		} catch (Exception e) {
			return null;
		}

	}

	/**
	 * yyyyMMdd形式の日付文字列をDate型に変換します。
	 * 
	 * @@ makeDate
	 * @note
	 * @param s
	 *            yyyyMMdd形式の日付文字列
	 * @return Date型の日付情報
	 * @@
	 */
	public static Date makeDate(String s) {

		// 引数がNull又は空の場合nullを返却する。
		if (StringUtils.isEmpty(s)) {
			return null;
		}

		return StringToMakeDate(s, YYYYMMDD);

	}

	/**
	 * yyyyMMddより指定月の加減算を行ったyyyyMMddを求めます。
	 * 
	 * @@ addMonth
	 * @note
	 * @param sYYYYMMDD
	 *            yyyyMMdd形式の日付文字列
	 * @param month
	 *            月の加減算数(負の場合マイナスをつける)
	 * @return 加減算後のyyyyMMdd形式の日付文字列
	 * @@
	 */
	public static String addMonth(String sYYYYMMDD, int month) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(sYYYYMMDD)) {
			return null;
		}

		// 引数が8桁で無い場合はnullを返します。
		if (sYYYYMMDD.length() != 8) {
			return null;
		}

		String resultStr = "";

		Date date;

		// カレンダークラスのインスタンスを取得します。
		Calendar cal = Calendar.getInstance();

		// データフォーマットクラスのインスタンスをyyyyMMddで生成します。
		DateFormat df = new SimpleDateFormat(YYYYMMDD);

		// yyyyMMddをDate型に変換します。
		date = makeDate(sYYYYMMDD);

		// 日付情報をカレンダークラスに設定します。
		cal.setTime(date);

		// 指定の月分加減算を行います。
		cal.add(Calendar.MONTH, month);

		// 加減算した日付の取得を行います。
		resultStr = df.format(cal.getTime());

		return resultStr;
	}

	/**
	 * yyyyMMddより指定日の加減算を行ったyyyyMMddを求めます。
	 * 
	 * @@ addDay
	 * @note
	 * @param sYYYYMMDD
	 *            yyyyMMdd形式の日付文字列
	 * @param day
	 *            日の加減算数(負の場合マイナスをつける)
	 * @return 加減算後のyyyyMMdd形式の日付文字列
	 * @@
	 */
	public static String addDay(String sYYYYMMDD, int day) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(sYYYYMMDD)) {
			return null;
		}

		// 引数が8桁で無い場合はnullを返します。
		if (sYYYYMMDD.length() != 8) {
			return null;
		}

		String resultStr = "";

		Date date;

		// カレンダークラスのインスタンスを取得します。
		Calendar cal = Calendar.getInstance();

		// データフォーマットクラスのインスタンスをyyyyMMddで生成します。
		DateFormat df = new SimpleDateFormat(YYYYMMDD);

		// yyyyMMddをDate型に変換します。
		date = makeDate(sYYYYMMDD);

		// 日付情報をカレンダークラスに設定します。
		cal.setTime(date);

		// 指定の月分加減算を行います。
		cal.add(Calendar.DATE, day);

		// 加減算した日付の取得を行います。
		resultStr = df.format(cal.getTime());

		return resultStr;
	}

	/**
	 * パラメータの年月日の末日を取得します。
	 * 
	 * @@ calcEmoDay
	 * @note パラメータのDD部分は数値であればよい
	 * @param sYYYYMMDD
	 *            yyyyMMdd形式の日付文字列
	 * @return 算出した末日(ddのみ)
	 * @@
	 */
	public static String calcEmoDay(String sYYYYMMDD) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(sYYYYMMDD)) {
			return null;
		}

		// 引数が8桁で無い場合はnullを返します。
		if (sYYYYMMDD.length() != 8) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		// yyyy + MM + "0"とすることで月末日を算出します。
		cal.set(
				Integer.parseInt(sYYYYMMDD.substring(0, 4)),
				Integer.parseInt(sYYYYMMDD.substring(4, 6)),
				0);

		// 日のみを返します。
		return Integer.toString(cal.get(Calendar.DATE));
	}

	/**
	 * パラメータの年月日の末日を取得します。
	 * 
	 * @@ calcEmoDay
	 * @note パラメータのDD部分は数値であればよい
	 * @param sYYYYMMDD
	 *            yyyyMMdd形式の日付文字列
	 * @return 算出した末日(yyyyMMdd)
	 * @@
	 */
	public static String calcEmoYYYYMMDD(String sYYYYMMDD) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(sYYYYMMDD)) {
			return null;
		}

		// 引数が8桁で無い場合はnullを返します。
		if (sYYYYMMDD.length() != 8) {
			return null;
		}

		Calendar cal = Calendar.getInstance();
		// yyyy + MM + "0"とすることで月末日を算出します。
		cal.set(
				Integer.parseInt(sYYYYMMDD.substring(0, 4)),
				Integer.parseInt(sYYYYMMDD.substring(4, 6)),
				0);

		// 年月日を返します。
		return sYYYYMMDD.substring(0, 4)
				+ sYYYYMMDD.substring(4, 6)
				+ Integer.toString(cal.get(Calendar.DATE));
	}

	/**
	 * 日付の妥当性をチェックします。
	 * 
	 * @@ check
	 * @note
	 * @param date
	 *            チェックする日付 （８桁、１４桁、１７桁）または時刻（６桁、９桁）
	 * @return 判定結果 （true：妥当　false：妥当ではない）
	 * @@
	 */
	public static boolean check(String date) {

		// 引数に"－"又は"."が含まれる場合はfalseを返却します。
		if (date.indexOf('-') != -1 || date.indexOf('.') != -1) {
			return false;
		}

		int date_length = date.length();

		// 引数の桁数が8桁、14桁、17桁、6桁、9桁で無い場合falseを返却します。
		if (!(date_length == 8
				|| date_length == 14
				|| date_length == 17
				|| date_length == 6 || date_length == 9)) {
			return false;
		}

		try {
			// 引数の桁数が6桁、9桁の場合
			if (date_length == 6 || date_length == 9) {
				if (date_length == 9
						&& Integer.parseInt(date.substring(6, 9)) < 0) {
					return false;
				}
				// 秒数が59より大きい又は0より小さい場合falseを返します。
				if (Integer.parseInt(date.substring(4, 6)) > 59
						|| Integer.parseInt(date.substring(4, 6)) < 0) {
					return false;
					// 分が59より大きい又は0より小さい場合falseを返します。
				} else if (Integer.parseInt(date.substring(2, 4)) > 59
						|| Integer.parseInt(date.substring(2, 4)) < 0) {
					return false;
					// 時が24より大きい又は0より小さい場合falseを返します。
				} else if (Integer.parseInt(date.substring(0, 2)) > 23
						|| Integer.parseInt(date.substring(0, 2)) < 0) {
					return false;
				}
				return true;

				// 引数の桁数が8桁、14桁、17桁の場合
			} else if (date_length == 8
					|| date_length == 14
					|| date_length == 17) {
				int y = Integer.parseInt(date.substring(0, 4));
				int m = Integer.parseInt(date.substring(4, 6));
				int d = Integer.parseInt(date.substring(6, 8));

				// 年が0以下の場合はfalseを返します。
				if (y < 0) {
					return false;
					// 月が12以上又は1より小さい場合はfalseを返します。
				} else if (m > 12 || m < 1) {
					return false;
					// 日が31以上又は1より小さい場合はfalseを返します。
				} else if (d > 31 || d < 1) {
					return false;
					// 月が4で日が31の場合はfalseを返します。
				} else if (m == 4 && d == 31) {
					return false;
					// 月が6で日が31の場合はfalseを返します。
				} else if (m == 6 && d == 31) {
					return false;
					// 月が9で日が31の場合はfalseを返します。
				} else if (m == 9 && d == 31) {
					return false;
					// 月が11で日が31の場合はfalseを返します。
				} else if (m == 11 && d == 31) {
					return false;
					// 月が2で日が29より大きい場合はfalseを返します。
				} else if (m == 2 && d > 29) {
					return false;
					// 月が2で日が29かつ年が4で割り切れる場合falseを返します。
				} else if (m == 2 && d == 29 && y % 4 != 0) {
					return false;
					// 月が2で日が29かつ年が100で割り切れるかつ年が400で割り切れない場合falseを返します。
				} else if (m == 2 && d == 29 && y % 100 == 0 && y % 400 != 0) {
					return false;
				} else if (date.length() != 8) {
					// 時刻のチェックを行います。
					boolean flag = check(date.substring(8, 14));
					// 時刻が正常な値で無い場合falseを返します。
					if (!flag) {
						return false;
					}
					return true;
				} else {
					return true;
				}
			} else {
				return false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		} catch (StringIndexOutOfBoundsException sob) {
			return false;
		}
	}

	/**
	 * 
	 * 日付文字列を指定の形式に変換します。
	 * 
	 * @@ changeDateFormat
	 * @note
	 * @param sDate
	 *            日付データ
	 * @param oldFormat
	 *            sDateの日付形式
	 * @param newFormat
	 *            変換フォーマット形式
	 * @return 指定型形式の日付文字列
	 * @@
	 */
	public static String changeDateFormat(
			String sDate,
			String oldFormat,
			String newFormat) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(sDate)) {
			return null;
		}

		return getDateFormat(StringToMakeDate(sDate, oldFormat), newFormat);
	}

	/**
	 * 
	 * 日付を比較し、差分の日数を返します。
	 * 
	 * @@ subtractDay
	 * @note
	 * @param date1
	 *            比較する日付 （８桁）
	 * @param date2
	 *            比較する日付 （８桁）
	 * @return date1 - date2 の結果日数
	 * @@
	 */
	public static int subtractDay(String date1, String date2) {

		// 日付データが0の場合エラーを返却します。
		if (Integer.parseInt(date1.substring(0, 8)) == 0
				|| Integer.parseInt(date2.substring(0, 8)) == 0) {
			return -1;
		}
		// 引数に"－"又は"."が含まれる場合はエラーを返却します。
		if (date1.indexOf('-') != -1
				|| date2.indexOf('-') != -1
				|| date1.indexOf('.') != -1
				|| date2.indexOf('.') != -1) {
			return -1;
		}

		int date1_length = date1.length();
		int date2_length = date2.length();
		// 桁数が8桁でない場合エラーを返却します。
		if (date1_length != 8) {
			return -1;
		}
		// 桁数が8桁でない場合エラーを返却します。
		if (date2_length != 8) {
			return -1;
		}
		SimpleDateFormat form = new SimpleDateFormat(YYYYMMDD);
		// カレンダークラスのインスタンスを取得します。
		Calendar carender1 = Calendar.getInstance();
		Calendar carender2 = Calendar.getInstance();

		try {
			// パラメタの日付をDate型にしカレンダークラスに設定します。
			carender1.setTime(form.parse(date1));
			carender2.setTime(form.parse(date2));
		} catch (ParseException e) {
			return -1;
		}
		// 2つの日付の差をミリ秒で算出
		long d = carender1.getTime().getTime() - carender2.getTime().getTime();

		// ミリ秒で求めた差を日付に換算します。
		return (int) (d / (1000 * 60 * 60 * 24));
	}

	/**
	 * 日付を比較し、差分の月数を返します。
	 * 
	 * @@ subtractMonth
	 * @note
	 * @param date1
	 *            対象する日付 （６桁）
	 * @param date2
	 *            基準とする日付（６桁）
	 * @return date1 - date2 の結果月数
	 * @@
	 */
	public static int subtractMonth(String date1, String date2) {
		// 日付データが0の場合エラーを返却します。
		if (Integer.parseInt(date1.substring(0, 6)) == 0
				|| Integer.parseInt(date2.substring(0, 6)) == 0) {
			return -1;
		}
		// 引数に"－"又は"."が含まれる場合はエラーを返却します。
		if (date1.indexOf('-') != -1
				|| date2.indexOf('-') != -1
				|| date1.indexOf('.') != -1
				|| date2.indexOf('.') != -1) {
			return -1;
		}

		int date1_length = date1.length();
		int date2_length = date2.length();
		// 桁数が6桁でない場合エラーを返却
		if (date1_length != 6) {
			return -1;
		}
		// 桁数が6桁でない場合エラーを返却
		if (date2_length != 6) {
			return -1;
		}

		int iyyyy = Integer.parseInt(date1.substring(0, 4));
		int iyyyy2 = Integer.parseInt(date2.substring(0, 4));

		int imm = Integer.parseInt(date1.substring(4, 6));
		int imm2 = Integer.parseInt(date2.substring(4, 6));

		// 差の年数(対象年-基準年)＊12(ヶ月)＋(対象月-基準月)
		int ret = ((iyyyy - iyyyy2) * 12) + (imm - imm2);

		return ret;
	}

	/**
	 * 
	 * 日付文字列をDate型に変換します。
	 * 
	 * @@ StringToMakeDate
	 * @note
	 * @param s
	 *            日付文字列
	 * @param format
	 *            sのフォーマットの形式
	 * @return Date型の日付情報
	 * @@
	 */
	private static Date StringToMakeDate(String s, String format) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(s) || StringUtils.isEmpty(format)) {
			return null;
		}

		// DateFormatのインスタンスを生成します。
		DateFormat newDf = new SimpleDateFormat(format);
		try {
			// 日付文字列をDate型オブジェクトに変換します。
			Date retDate = newDf.parse(s);

			return retDate;

		} catch (ParseException e) {
			// Date型オブジェクトに変換できなかった場合、Nullを返却します。
			return null;
		}

	}

	/**
	 * 
	 * Date型を指定の日付の形式に変換します。
	 * 
	 * @@ getDateFormat
	 * @note
	 * @param date
	 *            Date型日付データ
	 * @param newFormat
	 *            変換フォーマット形式
	 * @return 指定フォーマット形式の日付文字列
	 * @@
	 */
	private static String getDateFormat(Date date, String newFormat) {

		// 引数がnull又は空文字の場合はnullを返します。
		if (date == null || StringUtils.isEmpty(newFormat)) {
			return null;
		}

		// DateFormatのインスタンスを生成します。
		DateFormat newDf = new SimpleDateFormat(newFormat);
		// フォーマット済みの日付文字列を格納します。
		String rtnDate;

		try {
			// 返却すべきフォーマットの日付文字列を取得します。
			rtnDate = newDf.format(date);
		} catch (Exception e) {
			// Date型オブジェクトに変換できなかった場合、空文字""を返却します。
			rtnDate = null;
		}

		// 日付の文字列を返却します。
		return rtnDate;
	}

	// 20140424 NF466 運用商品一覧画面変更対応 insert start
	/**
	 * yyyyMMddからyyyy年M月d日に変換します。
	 * 
	 * @@ convertToDateString
	 * @note ゼロサプレスあり
	 * @param yyyymmdd
	 *            年月日
	 * @return yyyy年M月d日形式の日付文字列
	 * @@
	 */
	public static String convertToDateStringYYYYMD(String yyyymmdd) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(yyyymmdd)) {
			return null;
		}

		// 引数が8桁で無い場合はnullを返します。
		if (yyyymmdd.length() != 8) {
			return null;
		}

		return getDateFormat(
				StringToMakeDate(yyyymmdd, YYYYMMDD),
				JAPANESE_DATE);

	}

	/**
	 * yyyyMMからyyyy年M月に変換します。
	 * 
	 * @@ convertToDateStringYYYYMM
	 * @note ゼロサプレスあり
	 * @param yyyymm
	 *            yyyyMM型の文字列
	 * @return yyyy年MM月形式の日付文字列
	 * @@
	 */
	public static String convertToDateStringYYYYM(String yyyymm) {

		// 引数がnull又は空文字列の場合はnullを返します。
		if (StringUtils.isEmpty(yyyymm)) {
			return null;
		}

		// 引数が6桁で無い場合はnullを返します。
		if (yyyymm.length() != 6) {
			return null;
		}

		return getDateFormat(
				StringToMakeDate(yyyymm, YYYY_MM),
				JAPANESE_YEAR_MONTH_SUPPRES);
	}

	/**
	 * 終了日と開始日の間の日数を算出する。
	 * 
	 * @@ daysBetween
	 * @note ゼロサプレスあり
	 * @param strFromDate
	 *            yyyymmdd 年月日
	 * @param strToDate
	 *            yyyymmdd 年月日
	 * @return パラメータが妥当でない場合はnullを返却し、妥当の場合は日数を返却する。
	 */
	public static Integer daysBetween(String strFromDate, String strToDate) {
		if (StringUtils.isEmpty(strFromDate)) {
			return null;
		}

		if (strFromDate.length() != 8) {
			return null;
		}

		if (StringUtils.isEmpty(strToDate)) {
			return null;
		}

		if (strToDate.length() != 8) {
			return null;
		}

		try {
			Date fromDate = StringToMakeDate(strFromDate, YYYYMMDD);
			Date toDate = StringToMakeDate(strToDate, YYYYMMDD);
			int days = (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
			return days;
		} catch (Exception e) {
			return null;
		}
	}

	// 20140424 NF466 運用商品一覧画面変更対応 insert end

	/**
	 * 
	 * @@ addYear
	 * @note
	 * @param sYYYYMMDD
	 * @param year
	 * @return 
	 * @@
	 */
	public static String addYear(String sYYYYMMDD, int year) {
		return addMonth(sYYYYMMDD, 12 * year);
	}
}
