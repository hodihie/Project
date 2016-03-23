/**
 * 
 */
package sql.ads;

import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public class MakeConditions {

	/**
	 * 
	 */
	public MakeConditions() {

	}

	public static String createCondition(UserObject similar) {
		String tmp = "";
		if (similar != null) {
			byte permis = similar.getUser_permission();

			tmp = "(user_permission<=" + permis + ")";
		}
		return tmp;
	}

}
