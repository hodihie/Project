/**
 * 
 */
package haui.gui.doctor;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.DoctorObject;
import haui.objects.SpecialityObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Doctor extends ShareControl{

	public ResultSet getDoctor(int id);	
	public ResultSet getDoctors(DoctorObject similar );
	public ResultSet getDoctors(DoctorObject similar,int specialityId );
}
