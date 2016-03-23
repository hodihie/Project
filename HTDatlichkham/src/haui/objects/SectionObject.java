/**
 * 
 */
package haui.objects;

/**
 * @author Dinh Hieu
 *
 */
public class SectionObject {
	private short section_id;
	private String section_name;
	private String section_notes;
	private String section_created_date;
	private int section_manager_id;
	private boolean section_enable;
	private boolean section_delete;
	private String section_last_modified;
	private int section_created_author_id;
	private String section_name_en;
	private byte section_language;

	/**
	 * 
	 */
	public SectionObject() {
	}

	/**
	 * @return the section_id
	 */
	public short getSection_id() {
		return section_id;
	}

	/**
	 * @param section_id
	 *            the section_id to set
	 */
	public void setSection_id(short section_id) {
		this.section_id = section_id;
	}

	/**
	 * @return the section_name
	 */
	public String getSection_name() {
		return section_name;
	}

	/**
	 * @param section_name
	 *            the section_name to set
	 */
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}

	/**
	 * @return the section_notes
	 */
	public String getSection_notes() {
		return section_notes;
	}

	/**
	 * @param section_notes
	 *            the section_notes to set
	 */
	public void setSection_notes(String section_notes) {
		this.section_notes = section_notes;
	}

	/**
	 * @return the section_created_date
	 */
	public String getSection_created_date() {
		return section_created_date;
	}

	/**
	 * @param section_created_date
	 *            the section_created_date to set
	 */
	public void setSection_created_date(String section_created_date) {
		this.section_created_date = section_created_date;
	}

	/**
	 * @return the section_manager_id
	 */
	public int getSection_manager_id() {
		return section_manager_id;
	}

	/**
	 * @param section_manager_id
	 *            the section_manager_id to set
	 */
	public void setSection_manager_id(int section_manager_id) {
		this.section_manager_id = section_manager_id;
	}

	/**
	 * @return the section_enable
	 */
	public boolean isSection_enable() {
		return section_enable;
	}

	/**
	 * @param section_enable
	 *            the section_enable to set
	 */
	public void setSection_enable(boolean section_enable) {
		this.section_enable = section_enable;
	}

	/**
	 * @return the section_delete
	 */
	public boolean isSection_delete() {
		return section_delete;
	}

	/**
	 * @param section_delete
	 *            the section_delete to set
	 */
	public void setSection_delete(boolean section_delete) {
		this.section_delete = section_delete;
	}

	/**
	 * @return the section_last_modified
	 */
	public String getSection_last_modified() {
		return section_last_modified;
	}

	/**
	 * @param section_last_modified
	 *            the section_last_modified to set
	 */
	public void setSection_last_modified(String section_last_modified) {
		this.section_last_modified = section_last_modified;
	}

	/**
	 * @return the section_created_author_id
	 */
	public int getSection_created_author_id() {
		return section_created_author_id;
	}

	/**
	 * @param section_created_author_id
	 *            the section_created_author_id to set
	 */
	public void setSection_created_author_id(int section_created_author_id) {
		this.section_created_author_id = section_created_author_id;
	}

	/**
	 * @return the section_name_en
	 */
	public String getSection_name_en() {
		return section_name_en;
	}

	/**
	 * @param section_name_en
	 *            the section_name_en to set
	 */
	public void setSection_name_en(String section_name_en) {
		this.section_name_en = section_name_en;
	}

	/**
	 * @return the section_language
	 */
	public byte getSection_language() {
		return section_language;
	}

	/**
	 * @param section_language
	 *            the section_language to set
	 */
	public void setSection_language(byte section_language) {
		this.section_language = section_language;
	}

}
