/**
 * 
 */
package haui.ads.statistic;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import haui.ConnectionPool;
import haui.ConnectionPoolImpl;

/**
 * @author Dinh Hieu
 *
 */
public class StatisticModel {
	private Statistic s;

	/**
	 * 
	 */
	public StatisticModel(ConnectionPool cp) {
		this.s = new StatisticImpl(cp);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#finalize()
	 */
	@Override
	protected void finalize() throws Throwable {
		this.s = null;
		super.finalize();
	}

	public ConnectionPool getConnectionPool() {
		return this.s.getConnectionPool();
	}

	public void releaseConnection() {
		this.s.releaseConnection();
	}

	// **************************************
	public ArrayList getStatisticItems(String currentDate) {
		ArrayList<StatisticItem> items = new ArrayList<>();
		StatisticItem item = null;

		ResultSet[] rses = this.s.getApointmentStatistics(currentDate);
		ResultSet rsDate = null;
		if (rses.length > 0) {
			for (int i = 0; i < rses.length; i++) {
				rsDate = rses[i];
				if (rsDate != null) {
					try {
						if (rsDate.next()) {
							item = new StatisticItem();
							item.setNumberPatient(rsDate.getInt("totalPatient"));
							item.setNumberApointment(rsDate.getInt("totalApointment"));
							items.add(item);
						}
						//rsDate.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return items;
	}
	
	public static void main(String[] args) {
		ConnectionPool cp= new ConnectionPoolImpl();
		StatisticModel sm= new StatisticModel(cp);
		System.out.println(sm.getStatisticItems("201604170000"));
	}
}
