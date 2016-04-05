/**
 * 
 */
package haui.library;

/**
 * @author Dinh Hieu
 *
 */
public class StringUltils {

	/**
	 * 
	 */
	public StringUltils() {
	}

	public static boolean isEmpty(String s) {
		if (s == null || "".equals(s)) {
			return true;
		}
		return false;
	}

}
