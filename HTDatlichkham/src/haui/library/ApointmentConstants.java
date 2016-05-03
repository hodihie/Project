/**
 * 
 */
package haui.library;

/**
 * @author Dinh Hieu
 *
 */
public class ApointmentConstants {

	// apointment length
	public static final int APOINTMENT_LENGTH;

	// start hour 08
	public static final int START_HOUR;

	// start minute 00
	public static final int START_MINUTE;

	// end hour 17
	public static final int END_HOUR;

	// end minute 30
	public static final int END_MINUTE;

	// otp time out
	public static final int OTP_TIMEOUT;

	static {

		APOINTMENT_LENGTH = 15;

		START_HOUR = 8;

		START_MINUTE = 0;

		END_HOUR = 17;

		END_MINUTE = 30;

		OTP_TIMEOUT = 15;
	}

}
