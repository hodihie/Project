/**
 * 
 */
package haui.ads.statistic;

import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ads.doctor.DoctorLibrary;
import haui.ads.doctor.DoctorModel;
import haui.objects.DoctorObject;

/**
 * @author Dinh Hieu
 *
 */
public class StatisticControl {
	
	private StatisticModel sm;

	/**
	 * 
	 */
	public StatisticControl(ConnectionPool cp) {
		this.sm = new StatisticModel(cp);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.sm = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.sm.getConnectionPool();
	}

	public void releaseConnection() {
		this.sm.releaseConnection();
	}

	// ************************************************	
	
	public String getSeries(String currentDate) {
		ArrayList items = this.sm.getStatisticItems(currentDate);
		return StatisticLibrary.getSeries(items);
	}
	
	public String getCategory(String currentDate) {
		ArrayList items = this.sm.getStatisticItems(currentDate);
		return StatisticLibrary.getCategory(items);
	}

}
