/**
 * 
 */
package haui.objects;

/**
 * @author Dinh Hieu
 *
 */
public class ApointmentObject {

	private int apointment_id;
	private int apointment_patient_id;
	private int apointment_doctor_id;
	private String apointment_date;
	private String apointment_created_date;	
	private String apointment_symptom;
	private String apointment_note;

	/**
	 * 
	 */
	public ApointmentObject() {

	}

	/**
	 * @param apointment_id
	 * @param apointment_patient_id
	 * @param apointment_doctor_id
	 * @param apointment_date
	 * @param apointment_created_date
	 * @param apointment_time
	 * @param apointment_symptom
	 * @param apointment_note
	 */
	public ApointmentObject(int apointment_id, int apointment_patient_id, int apointment_doctor_id,
			String apointment_date, String apointment_created_date, String apointment_time, String apointment_symptom,
			String apointment_note) {
		this.apointment_id = apointment_id;
		this.apointment_patient_id = apointment_patient_id;
		this.apointment_doctor_id = apointment_doctor_id;
		this.apointment_date = apointment_date;
		this.apointment_created_date = apointment_created_date;		
		this.apointment_symptom = apointment_symptom;
		this.apointment_note = apointment_note;
	}

	/**
	 * @return the apointment_id
	 */
	public int getApointment_id() {
		return apointment_id;
	}

	/**
	 * @param apointment_id
	 *            the apointment_id to set
	 */
	public void setApointment_id(int apointment_id) {
		this.apointment_id = apointment_id;
	}

	/**
	 * @return the apointment_patient_id
	 */
	public int getApointment_patient_id() {
		return apointment_patient_id;
	}

	/**
	 * @param apointment_patient_id
	 *            the apointment_patient_id to set
	 */
	public void setApointment_patient_id(int apointment_patient_id) {
		this.apointment_patient_id = apointment_patient_id;
	}

	/**
	 * @return the apointment_doctor_id
	 */
	public int getApointment_doctor_id() {
		return apointment_doctor_id;
	}

	/**
	 * @param apointment_doctor_id
	 *            the apointment_doctor_id to set
	 */
	public void setApointment_doctor_id(int apointment_doctor_id) {
		this.apointment_doctor_id = apointment_doctor_id;
	}

	/**
	 * @return the apointment_date
	 */
	public String getApointment_date() {
		return apointment_date;
	}

	/**
	 * @param apointment_date
	 *            the apointment_date to set
	 */
	public void setApointment_date(String apointment_date) {
		this.apointment_date = apointment_date;
	}

	/**
	 * @return the apointment_created_date
	 */
	public String getApointment_created_date() {
		return apointment_created_date;
	}

	/**
	 * @param apointment_created_date
	 *            the apointment_created_date to set
	 */
	public void setApointment_created_date(String apointment_created_date) {
		this.apointment_created_date = apointment_created_date;
	}	

	/**
	 * @return the apointment_symptom
	 */
	public String getApointment_symptom() {
		return apointment_symptom;
	}

	/**
	 * @param apointment_symptom
	 *            the apointment_symptom to set
	 */
	public void setApointment_symptom(String apointment_symptom) {
		this.apointment_symptom = apointment_symptom;
	}

	/**
	 * @return the apointment_note
	 */
	public String getApointment_note() {
		return apointment_note;
	}

	/**
	 * @param apointment_note
	 *            the apointment_note to set
	 */
	public void setApointment_note(String apointment_note) {
		this.apointment_note = apointment_note;
	}

}
