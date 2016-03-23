/**
 * 
 */
package haui.objects;

/**
 * @author Dinh Hieu
 *
 */
public class CategoryObject extends SectionObject{
	private short category_id;
	private String category_name;
	private short category_section_id;
	private String category_notes;
	private String category_created_date;
	private int category_created_author_id;
	private String category_last_modified;
	private int category_manager_id;
	private boolean category_enable;
	private boolean category_delete;
	private String category_image;
	private String category_name_en;
	private byte category_language;

	/**
	 * 
	 */
	public CategoryObject() {
	}

	/**
	 * @return the category_id
	 */
	public short getCategory_id() {
		return category_id;
	}

	/**
	 * @param category_id
	 *            the category_id to set
	 */
	public void setCategory_id(short category_id) {
		this.category_id = category_id;
	}

	/**
	 * @return the category_name
	 */
	public String getCategory_name() {
		return category_name;
	}

	/**
	 * @param category_name
	 *            the category_name to set
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	/**
	 * @return the category_section_id
	 */
	public short getCategory_section_id() {
		return category_section_id;
	}

	/**
	 * @param category_section_id
	 *            the category_section_id to set
	 */
	public void setCategory_section_id(short category_section_id) {
		this.category_section_id = category_section_id;
	}

	/**
	 * @return the category_notes
	 */
	public String getCategory_notes() {
		return category_notes;
	}

	/**
	 * @param category_notes
	 *            the category_notes to set
	 */
	public void setCategory_notes(String category_notes) {
		this.category_notes = category_notes;
	}

	/**
	 * @return the category_created_date
	 */
	public String getCategory_created_date() {
		return category_created_date;
	}

	/**
	 * @param category_created_date
	 *            the category_created_date to set
	 */
	public void setCategory_created_date(String category_created_date) {
		this.category_created_date = category_created_date;
	}

	/**
	 * @return the category_created_author_id
	 */
	public int getCategory_created_author_id() {
		return category_created_author_id;
	}

	/**
	 * @param category_created_author_id
	 *            the category_created_author_id to set
	 */
	public void setCategory_created_author_id(int category_created_author_id) {
		this.category_created_author_id = category_created_author_id;
	}

	/**
	 * @return the category_last_modified
	 */
	public String getCategory_last_modified() {
		return category_last_modified;
	}

	/**
	 * @param category_last_modified
	 *            the category_last_modified to set
	 */
	public void setCategory_last_modified(String category_last_modified) {
		this.category_last_modified = category_last_modified;
	}

	/**
	 * @return the category_manager_id
	 */
	public int getCategory_manager_id() {
		return category_manager_id;
	}

	/**
	 * @param category_manager_id
	 *            the category_manager_id to set
	 */
	public void setCategory_manager_id(int category_manager_id) {
		this.category_manager_id = category_manager_id;
	}

	/**
	 * @return the category_enable
	 */
	public boolean isCategory_enable() {
		return category_enable;
	}

	/**
	 * @param category_enable
	 *            the category_enable to set
	 */
	public void setCategory_enable(boolean category_enable) {
		this.category_enable = category_enable;
	}

	/**
	 * @return the category_delete
	 */
	public boolean isCategory_delete() {
		return category_delete;
	}

	/**
	 * @param category_delete
	 *            the category_delete to set
	 */
	public void setCategory_delete(boolean category_delete) {
		this.category_delete = category_delete;
	}

	/**
	 * @return the category_image
	 */
	public String getCategory_image() {
		return category_image;
	}

	/**
	 * @param category_image
	 *            the category_image to set
	 */
	public void setCategory_image(String category_image) {
		this.category_image = category_image;
	}

	/**
	 * @return the category_name_en
	 */
	public String getCategory_name_en() {
		return category_name_en;
	}

	/**
	 * @param category_name_en
	 *            the category_name_en to set
	 */
	public void setCategory_name_en(String category_name_en) {
		this.category_name_en = category_name_en;
	}

	/**
	 * @return the category_language
	 */
	public byte getCategory_language() {
		return category_language;
	}

	/**
	 * @param category_language
	 *            the category_language to set
	 */
	public void setCategory_language(byte category_language) {
		this.category_language = category_language;
	}

}
