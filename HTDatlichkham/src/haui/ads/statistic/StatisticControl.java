/**
 * 
 */
package haui.ads.statistic;

import java.util.ArrayList;

import haui.ConnectionPool;

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
	public String getCategory(String currentDate, int number) {
		return StatisticLibrary.getCategory(currentDate, number);
	}

	public String getSeries(String currentDate, int number) {
		ArrayList items = this.sm.getStatisticItems(currentDate, number);
		return StatisticLibrary.getSeries(items, number);
	}

}
