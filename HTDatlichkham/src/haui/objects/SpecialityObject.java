/**
 * 
 */
package haui.objects;

/**
 * @author Dinh Hieu
 *
 */
public class SpecialityObject {
	private int speciality_id;
	private String speciality_name;
	private String speciality_place;
	private int speciality_number_of_room;
	private int speciality_number_of_doctors;
	private String speciality_phone;
	private String speciality_note;

	/**
	 * 
	 */
	public SpecialityObject() {
	}

	/**
	 * @param speciality_id
	 * @param speciality_name
	 * @param speciality_place
	 * @param speciality_number_of_room
	 * @param speciality_number_of_doctors
	 * @param speciality_phone
	 * @param speciality_note
	 */
	public SpecialityObject(int speciality_id, String speciality_name, String speciality_place,
			int speciality_number_of_room, int speciality_number_of_doctors, String speciality_phone,
			String speciality_note) {
		this.speciality_id = speciality_id;
		this.speciality_name = speciality_name;
		this.speciality_place = speciality_place;
		this.speciality_number_of_room = speciality_number_of_room;
		this.speciality_number_of_doctors = speciality_number_of_doctors;
		this.speciality_phone = speciality_phone;
		this.speciality_note = speciality_note;
	}

	/**
	 * @return the speciality_id
	 */
	public int getSpeciality_id() {
		return speciality_id;
	}

	/**
	 * @param speciality_id
	 *            the speciality_id to set
	 */
	public void setSpeciality_id(int speciality_id) {
		this.speciality_id = speciality_id;
	}

	/**
	 * @return the speciality_name
	 */
	public String getSpeciality_name() {
		return speciality_name;
	}

	/**
	 * @param speciality_name
	 *            the speciality_name to set
	 */
	public void setSpeciality_name(String speciality_name) {
		this.speciality_name = speciality_name;
	}

	/**
	 * @return the speciality_place
	 */
	public String getSpeciality_place() {
		return speciality_place;
	}

	/**
	 * @param speciality_place
	 *            the speciality_place to set
	 */
	public void setSpeciality_place(String speciality_place) {
		this.speciality_place = speciality_place;
	}

	/**
	 * @return the speciality_number_of_room
	 */
	public int getSpeciality_number_of_room() {
		return speciality_number_of_room;
	}

	/**
	 * @param speciality_number_of_room
	 *            the speciality_number_of_room to set
	 */
	public void setSpeciality_number_of_room(int speciality_number_of_room) {
		this.speciality_number_of_room = speciality_number_of_room;
	}

	/**
	 * @return the speciality_number_of_doctors
	 */
	public int getSpeciality_number_of_doctors() {
		return speciality_number_of_doctors;
	}

	/**
	 * @param speciality_number_of_doctors
	 *            the speciality_number_of_doctors to set
	 */
	public void setSpeciality_number_of_doctors(int speciality_number_of_doctors) {
		this.speciality_number_of_doctors = speciality_number_of_doctors;
	}

	/**
	 * @return the speciality_phone
	 */
	public String getSpeciality_phone() {
		return speciality_phone;
	}

	/**
	 * @param speciality_phone
	 *            the speciality_phone to set
	 */
	public void setSpeciality_phone(String speciality_phone) {
		this.speciality_phone = speciality_phone;
	}

	/**
	 * @return the speciality_note
	 */
	public String getSpeciality_note() {
		return speciality_note;
	}

	/**
	 * @param speciality_note
	 *            the speciality_note to set
	 */
	public void setSpeciality_note(String speciality_note) {
		this.speciality_note = speciality_note;
	}

}
