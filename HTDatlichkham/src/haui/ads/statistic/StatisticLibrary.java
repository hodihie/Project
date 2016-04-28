/**
 * 
 */
package haui.ads.statistic;

import java.util.ArrayList;

import haui.objects.DoctorObject;

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

	public static String getCategory(ArrayList<StatisticItem> items) {
		String tmp = "[";
		int i = 0;
		for (StatisticItem item : items) {

			tmp += item.getNumberApointment() + ": " + item.getNumberPatient() + "<br/>";

		}
		return tmp;
	}

	public static String getSeries(ArrayList<StatisticItem> items) {
		String tmp = "";
		int i = 0;

		tmp += "[{name: 'Số bệnh nhân', data: ["+items.get(2).getNumberPatient()+", "+items.get(1).getNumberPatient()+", "+items.get(0).getNumberPatient()+"]},";
		tmp += "{name: 'Số lịch khám', data: ["+items.get(2).getNumberApointment()+", "+items.get(1).getNumberApointment()+", "+items.get(0).getNumberApointment()+"]}]";

		return tmp;
	}

}
