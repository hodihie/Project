/**
 * 
 */
package haui.gui.speciality;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.SpecialityObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Speciality extends ShareControl{

	public ResultSet getSpeciality(int id);	
	public ResultSet getSpecialities(SpecialityObject similar);
}
