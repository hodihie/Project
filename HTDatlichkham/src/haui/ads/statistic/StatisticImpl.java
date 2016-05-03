/**
 * 
 */
package haui.ads.statistic;

import java.sql.ResultSet;

import haui.ConnectionPool;
import haui.ads.basic.BasicImpl;
import haui.library.DateUtils;

/**
 * @author Dinh Hieu
 *
 */
public class StatisticImpl extends BasicImpl implements Statistic {

	/**
	 * 
	 */
	public StatisticImpl(ConnectionPool cp) {
		super(cp, "Statistic");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see haui.ads.statistic.Statistic#getStatistics()
	 */
	@Override
	public ResultSet[] getApointmentStatistics(String currentDate, int number) {
		String[] sqls = new String[number];
		
		for (int i = 0; i < number; i++) {
			sqls[i] = " SELECT COUNT(distinct a.apointment_patient_id) AS totalPatient, COUNT(a.apointment_id) AS totalApointment from tblapointment a, tblpatient p  WHERE p.patient_id = a.apointment_patient_id and apointment_date > '"
					+ DateUtils.addDay(currentDate, -i) + "' and apointment_date < '"
					+ DateUtils.addDay(currentDate, -i + 1) + "' ";
		}
		return this.gets(sqls);
	}

}
