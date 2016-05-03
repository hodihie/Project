/**
 * 
 */
package haui.objects;

/**
 * @author Dinh Hieu
 *
 */
public class RequestSMSObject {
	private String req_PhoneNumber;
	private String req_sendDate;
	private String req_otp;
	private String req_otpExpire;

	/**
	 * 
	 */
	public RequestSMSObject() {

	}

	/**
	 * @param req_PhoneNumber
	 * @param req_sendDate
	 * @param req_otp
	 * @param req_otpExpire
	 */
	public RequestSMSObject(String req_PhoneNumber, String req_sendDate, String req_otp, String req_otpExpire) {
		this.req_PhoneNumber = req_PhoneNumber;
		this.req_sendDate = req_sendDate;
		this.req_otp = req_otp;
		this.req_otpExpire = req_otpExpire;
	}

	/**
	 * @return the req_PhoneNumber
	 */
	public String getReq_PhoneNumber() {
		return req_PhoneNumber;
	}

	/**
	 * @param req_PhoneNumber
	 *            the req_PhoneNumber to set
	 */
	public void setReq_PhoneNumber(String req_PhoneNumber) {
		this.req_PhoneNumber = req_PhoneNumber;
	}

	/**
	 * @return the req_sendDate
	 */
	public String getReq_sendDate() {
		return req_sendDate;
	}

	/**
	 * @param req_sendDate
	 *            the req_sendDate to set
	 */
	public void setReq_sendDate(String req_sendDate) {
		this.req_sendDate = req_sendDate;
	}

	/**
	 * @return the req_otp
	 */
	public String getReq_otp() {
		return req_otp;
	}

	/**
	 * @param req_otp
	 *            the req_otp to set
	 */
	public void setReq_otp(String req_otp) {
		this.req_otp = req_otp;
	}

	/**
	 * @return the req_otpExpire
	 */
	public String getReq_otpExpire() {
		return req_otpExpire;
	}

	/**
	 * @param req_otpExpire
	 *            the req_otpExpire to set
	 */
	public void setReq_otpExpire(String req_otpExpire) {
		this.req_otpExpire = req_otpExpire;
	}

}
