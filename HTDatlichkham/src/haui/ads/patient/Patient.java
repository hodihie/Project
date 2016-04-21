/**
 * 
 */
package haui.ads.patient;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.PatientObject;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Patient extends ShareControl {

	public int addPatient(PatientObject item);
	public boolean editPatient(PatientObject item);
	public boolean delPatient(PatientObject item);

	public ResultSet getPatient(int id);	
	public ResultSet getPatients(PatientObject similar, int at, byte total);
}
