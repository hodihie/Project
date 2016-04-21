/**
 * 
 */
package haui.library;

/**
 * @author Dinh Hieu
 *
 */
public class StringUtils {

	/**
	 * 
	 */
	public StringUtils() {
	}

	public static boolean isEmpty(String s) {
		if (s == null || "".equals(s)) {
			return true;
		}
		return false;
	}

}
