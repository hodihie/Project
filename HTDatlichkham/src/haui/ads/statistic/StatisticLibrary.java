/**
 * 
 */
package haui.ads.statistic;

import java.util.ArrayList;

import haui.library.DateUtils;

/**
 * @author Dinh Hieu
 *
 */
public class StatisticLibrary {

	/**
	 * 
	 */
	public StatisticLibrary() {

	}

	public static String getCategory(String currentDate, int number) {

		StringBuilder tmp = new StringBuilder("[");

		for (int i = number - 1; i >= 0; i--) {

			tmp.append("'");
			tmp.append(DateUtils.changeDateFormat(DateUtils.addDay(currentDate, -i), DateUtils.YYYY_MM_DD_HH_MM,
					DateUtils.DISPLAY_DATE));
			tmp.append("'");
			if (i != 0) {
				tmp.append(",");
			}

		}
		tmp.append("]");
		return tmp.toString();
	}

	public static String getSeries(ArrayList<StatisticItem> items, int number) {
		StringBuilder tmp = new StringBuilder();
		tmp.append("[{name: 'Số bệnh nhân', data: [");
		for (int i = number-1; i >= 0; i--) {
			tmp.append(items.get(i).getNumberPatient());
			if(i!=0){
				tmp.append(", ");
			}
		}
		tmp.append("]},");
		tmp.append("{name: 'Số lịch khám', data: [");
		for (int i = number-1; i >= 0; i--) {
			tmp.append(items.get(i).getNumberApointment());
			if(i!=0){
				tmp.append(", ");
			}
		}
		tmp.append("]}]");

		return tmp.toString();
	}

}
