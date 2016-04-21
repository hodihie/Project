/**
 * 
 */
package haui.objects;

/**
 * @author Dinh Hieu
 *
 */
public class PatientObject {

	private int patient_id;
	private String patient_fullname;
	private short patient_gender;
	private String patient_birthday;
	private String patient_address;
	private String patient_phone;
	private String patient_email;
	private String patient_code;

	/**
	 * 
	 */
	public PatientObject() {
	}

	/**
	 * @param patient_id
	 * @param patient_fullname
	 * @param patient_gender
	 * @param patient_birthday
	 * @param patient_address
	 * @param patient_phone
	 * @param patient_email
	 * @param patient_code
	 */
	public PatientObject(int patient_id, String patient_fullname, short patient_gender, String patient_birthday,
			String patient_address, String patient_phone, String patient_email, String patient_code) {
		this.patient_id = patient_id;
		this.patient_fullname = patient_fullname;
		this.patient_gender = patient_gender;
		this.patient_birthday = patient_birthday;
		this.patient_address = patient_address;
		this.patient_phone = patient_phone;
		this.patient_email = patient_email;
		this.patient_code = patient_code;
	}

	/**
	 * @return the patient_id
	 */
	public int getPatient_id() {
		return patient_id;
	}

	/**
	 * @param patient_id
	 *            the patient_id to set
	 */
	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	/**
	 * @return the patient_fullname
	 */
	public String getPatient_fullname() {
		return patient_fullname;
	}

	/**
	 * @param patient_fullname
	 *            the patient_fullname to set
	 */
	public void setPatient_fullname(String patient_fullname) {
		this.patient_fullname = patient_fullname;
	}

	/**
	 * @return the patient_gender
	 */
	public short getPatient_gender() {
		return patient_gender;
	}

	/**
	 * @param patient_gender
	 *            the patient_gender to set
	 */
	public void setPatient_gender(short patient_gender) {
		this.patient_gender = patient_gender;
	}

	/**
	 * @return the patient_birthday
	 */
	public String getPatient_birthday() {
		return patient_birthday;
	}

	/**
	 * @param patient_birthday
	 *            the patient_birthday to set
	 */
	public void setPatient_birthday(String patient_birthday) {
		this.patient_birthday = patient_birthday;
	}

	/**
	 * @return the patient_address
	 */
	public String getPatient_address() {
		return patient_address;
	}

	/**
	 * @param patient_address
	 *            the patient_address to set
	 */
	public void setPatient_address(String patient_address) {
		this.patient_address = patient_address;
	}

	/**
	 * @return the patient_phone
	 */
	public String getPatient_phone() {
		return patient_phone;
	}

	/**
	 * @param patient_phone
	 *            the patient_phone to set
	 */
	public void setPatient_phone(String patient_phone) {
		this.patient_phone = patient_phone;
	}

	/**
	 * @return the patient_email
	 */
	public String getPatient_email() {
		return patient_email;
	}

	/**
	 * @param patient_email
	 *            the patient_email to set
	 */
	public void setPatient_email(String patient_email) {
		this.patient_email = patient_email;
	}

	/**
	 * @return the patient_code
	 */
	public String getPatient_code() {
		return patient_code;
	}

	/**
	 * @param patient_code
	 *            the patient_code to set
	 */
	public void setPatient_code(String patient_code) {
		this.patient_code = patient_code;
	}

}
