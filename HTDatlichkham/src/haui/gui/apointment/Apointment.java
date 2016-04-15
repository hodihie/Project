/**
 * 
 */
package haui.gui.apointment;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.ApointmentObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Apointment extends ShareControl{

	public boolean addApointment(ApointmentObject item);
	public boolean editApointment(ApointmentObject item);
	public boolean delApointment(ApointmentObject item);
	
	public ResultSet getApointment(int id);	
	public ResultSet getNextApointmentsByDocId(int docId, String currentDate);	
	public ResultSet getApointments(ApointmentObject similar);
}
