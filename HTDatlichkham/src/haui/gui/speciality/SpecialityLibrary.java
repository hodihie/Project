/**
 * 
 */
package haui.gui.speciality;

import java.util.ArrayList;

import haui.objects.SpecialityObject;

/**
 * @author Dinh Hieu
 *
 */
public class SpecialityLibrary {

	public static String viewSpecialities(ArrayList<SpecialityObject> items) {
		String tmp = " ";
		for (SpecialityObject item : items) {
			tmp += " <option value=\"" + item.getSpeciality_id() + "\">" + item.getSpeciality_name() + "</option> ";
		}

		return tmp;
	}
}
