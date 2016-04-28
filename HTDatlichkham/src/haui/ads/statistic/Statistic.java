/**
 * 
 */
package haui.ads.statistic;

import java.sql.ResultSet;

import haui.ShareControl;

/**
 * @author Dinh Hieu
 *
 */
public interface Statistic extends ShareControl {
	public ResultSet[] getApointmentStatistics(String currentDate);
}
