/**
 * 
 */
package haui.ads.apointment;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.ApointmentObject;
import haui.objects.DoctorObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Apointment extends ShareControl{

	public boolean addApointment(ApointmentObject item);
	public boolean editApointment(ApointmentObject item);
	public boolean delApointment(ApointmentObject item);
	
	public ResultSet getApointment(int id);	
	public ResultSet getApointments(ApointmentObject similar, int at, byte total);
}
