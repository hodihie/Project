/**
 * 
 */
package haui.objects;

/**
 * @author Dinh Hieu
 *
 */
public class CustomerObject {

	private int customer_id;
	private String customer_fullname;
	private short customer_gender;
	private String customer_birthday;
	private String customer_address;
	private String customer_phone;
	private String customer_email;
	private String customer_code;

	/**
	 * 
	 */
	public CustomerObject() {
	}

	/**
	 * @param customer_id
	 * @param customer_fullname
	 * @param customer_gender
	 * @param customer_birthday
	 * @param customer_address
	 * @param customer_phone
	 * @param customer_email
	 * @param customer_code
	 */
	public CustomerObject(int customer_id, String customer_fullname, short customer_gender, String customer_birthday,
			String customer_address, String customer_phone, String customer_email, String customer_code) {
		this.customer_id = customer_id;
		this.customer_fullname = customer_fullname;
		this.customer_gender = customer_gender;
		this.customer_birthday = customer_birthday;
		this.customer_address = customer_address;
		this.customer_phone = customer_phone;
		this.customer_email = customer_email;
		this.customer_code = customer_code;
	}

	/**
	 * @return the customer_id
	 */
	public int getCustomer_id() {
		return customer_id;
	}

	/**
	 * @param customer_id
	 *            the customer_id to set
	 */
	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	/**
	 * @return the customer_fullname
	 */
	public String getCustomer_fullname() {
		return customer_fullname;
	}

	/**
	 * @param customer_fullname
	 *            the customer_fullname to set
	 */
	public void setCustomer_fullname(String customer_fullname) {
		this.customer_fullname = customer_fullname;
	}

	/**
	 * @return the customer_gender
	 */
	public short getCustomer_gender() {
		return customer_gender;
	}

	/**
	 * @param customer_gender
	 *            the customer_gender to set
	 */
	public void setCustomer_gender(short customer_gender) {
		this.customer_gender = customer_gender;
	}

	/**
	 * @return the customer_birthday
	 */
	public String getCustomer_birthday() {
		return customer_birthday;
	}

	/**
	 * @param customer_birthday
	 *            the customer_birthday to set
	 */
	public void setCustomer_birthday(String customer_birthday) {
		this.customer_birthday = customer_birthday;
	}

	/**
	 * @return the customer_address
	 */
	public String getCustomer_address() {
		return customer_address;
	}

	/**
	 * @param customer_address
	 *            the customer_address to set
	 */
	public void setCustomer_address(String customer_address) {
		this.customer_address = customer_address;
	}

	/**
	 * @return the customer_phone
	 */
	public String getCustomer_phone() {
		return customer_phone;
	}

	/**
	 * @param customer_phone
	 *            the customer_phone to set
	 */
	public void setCustomer_phone(String customer_phone) {
		this.customer_phone = customer_phone;
	}

	/**
	 * @return the customer_email
	 */
	public String getCustomer_email() {
		return customer_email;
	}

	/**
	 * @param customer_email
	 *            the customer_email to set
	 */
	public void setCustomer_email(String customer_email) {
		this.customer_email = customer_email;
	}

	/**
	 * @return the customer_code
	 */
	public String getCustomer_code() {
		return customer_code;
	}

	/**
	 * @param customer_code
	 *            the customer_code to set
	 */
	public void setCustomer_code(String customer_code) {
		this.customer_code = customer_code;
	}

}
