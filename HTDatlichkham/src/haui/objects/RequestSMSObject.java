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

	/**
	 * 
	 */
	public RequestSMSObject() {

	}

	/**
	 * @param req_PhoneNumber
	 * @param req_sendDate
	 */
	public RequestSMSObject(String req_PhoneNumber, String req_sendDate) {
		this.req_PhoneNumber = req_PhoneNumber;
		this.req_sendDate = req_sendDate;
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

}
