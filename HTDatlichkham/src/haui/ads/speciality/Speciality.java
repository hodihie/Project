/**
 * 
 */
package haui.ads.speciality;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.SpecialityObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Speciality extends ShareControl{
	public boolean addSpeciality(SpecialityObject item);
	public boolean editSpeciality(SpecialityObject item);
	public boolean delSpeciality(SpecialityObject item);

	public ResultSet getSpeciality(int id);	
	public ResultSet getSpecialities(SpecialityObject similar, int at, byte total);
}
