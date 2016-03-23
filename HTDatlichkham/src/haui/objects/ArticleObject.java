/**
 * 
 */
package haui.objects;

/**
 * @author Dinh Hieu
 *
 */
public class ArticleObject extends CategoryObject{
	private int article_id;
	private String article_title;
	private String article_summary;
	private String article_content;
	private String article_created_date;
	private String article_last_modified;
	private String article_image;
	private short article_category_id;
	private short article_section_id;
	private short article_visited;
	private String article_author_name;
	private boolean article_enable;
	private String article_url_link;
	private String article_tag;
	private String article_title_en;
	private String article_summary_en;
	private String article_content_en;
	private String article_tag_en;
	private int article_fee;
	private boolean article_isfee;
	private boolean article_delete;
	private String article_deleted_date;
	private String article_restored_date;
	private String article_modified_author_name;
	private short article_author_permission;
	private String article_source;
	private byte article_language;
	private boolean article_focus;

	/**
	 * 
	 */
	public ArticleObject() {
	}

	/**
	 * @return the article_id
	 */
	public int getArticle_id() {
		return article_id;
	}

	/**
	 * @param article_id
	 *            the article_id to set
	 */
	public void setArticle_id(int article_id) {
		this.article_id = article_id;
	}

	/**
	 * @return the article_title
	 */
	public String getArticle_title() {
		return article_title;
	}

	/**
	 * @param article_title
	 *            the article_title to set
	 */
	public void setArticle_title(String article_title) {
		this.article_title = article_title;
	}

	/**
	 * @return the article_summary
	 */
	public String getArticle_summary() {
		return article_summary;
	}

	/**
	 * @param article_summary
	 *            the article_summary to set
	 */
	public void setArticle_summary(String article_summary) {
		this.article_summary = article_summary;
	}

	/**
	 * @return the article_content
	 */
	public String getArticle_content() {
		return article_content;
	}

	/**
	 * @param article_content
	 *            the article_content to set
	 */
	public void setArticle_content(String article_content) {
		this.article_content = article_content;
	}

	/**
	 * @return the article_created_date
	 */
	public String getArticle_created_date() {
		return article_created_date;
	}

	/**
	 * @param article_created_date
	 *            the article_created_date to set
	 */
	public void setArticle_created_date(String article_created_date) {
		this.article_created_date = article_created_date;
	}

	/**
	 * @return the article_last_modified
	 */
	public String getArticle_last_modified() {
		return article_last_modified;
	}

	/**
	 * @param article_last_modified
	 *            the article_last_modified to set
	 */
	public void setArticle_last_modified(String article_last_modified) {
		this.article_last_modified = article_last_modified;
	}

	/**
	 * @return the article_image
	 */
	public String getArticle_image() {
		return article_image;
	}

	/**
	 * @param article_image
	 *            the article_image to set
	 */
	public void setArticle_image(String article_image) {
		this.article_image = article_image;
	}

	/**
	 * @return the article_category_id
	 */
	public short getArticle_category_id() {
		return article_category_id;
	}

	/**
	 * @param article_category_id
	 *            the article_category_id to set
	 */
	public void setArticle_category_id(short article_category_id) {
		this.article_category_id = article_category_id;
	}

	/**
	 * @return the article_section_id
	 */
	public short getArticle_section_id() {
		return article_section_id;
	}

	/**
	 * @param article_section_id
	 *            the article_section_id to set
	 */
	public void setArticle_section_id(short article_section_id) {
		this.article_section_id = article_section_id;
	}

	/**
	 * @return the article_visited
	 */
	public short getArticle_visited() {
		return article_visited;
	}

	/**
	 * @param article_visited
	 *            the article_visited to set
	 */
	public void setArticle_visited(short article_visited) {
		this.article_visited = article_visited;
	}

	/**
	 * @return the article_author_name
	 */
	public String getArticle_author_name() {
		return article_author_name;
	}

	/**
	 * @param article_author_name
	 *            the article_author_name to set
	 */
	public void setArticle_author_name(String article_author_name) {
		this.article_author_name = article_author_name;
	}

	/**
	 * @return the article_enable
	 */
	public boolean isArticle_enable() {
		return article_enable;
	}

	/**
	 * @param article_enable
	 *            the article_enable to set
	 */
	public void setArticle_enable(boolean article_enable) {
		this.article_enable = article_enable;
	}

	/**
	 * @return the article_url_link
	 */
	public String getArticle_url_link() {
		return article_url_link;
	}

	/**
	 * @param article_url_link
	 *            the article_url_link to set
	 */
	public void setArticle_url_link(String article_url_link) {
		this.article_url_link = article_url_link;
	}

	/**
	 * @return the article_tag
	 */
	public String getArticle_tag() {
		return article_tag;
	}

	/**
	 * @param article_tag
	 *            the article_tag to set
	 */
	public void setArticle_tag(String article_tag) {
		this.article_tag = article_tag;
	}

	/**
	 * @return the article_title_en
	 */
	public String getArticle_title_en() {
		return article_title_en;
	}

	/**
	 * @param article_title_en
	 *            the article_title_en to set
	 */
	public void setArticle_title_en(String article_title_en) {
		this.article_title_en = article_title_en;
	}

	/**
	 * @return the article_summary_en
	 */
	public String getArticle_summary_en() {
		return article_summary_en;
	}

	/**
	 * @param article_summary_en
	 *            the article_summary_en to set
	 */
	public void setArticle_summary_en(String article_summary_en) {
		this.article_summary_en = article_summary_en;
	}

	/**
	 * @return the article_content_en
	 */
	public String getArticle_content_en() {
		return article_content_en;
	}

	/**
	 * @param article_content_en
	 *            the article_content_en to set
	 */
	public void setArticle_content_en(String article_content_en) {
		this.article_content_en = article_content_en;
	}

	/**
	 * @return the article_tag_en
	 */
	public String getArticle_tag_en() {
		return article_tag_en;
	}

	/**
	 * @param article_tag_en
	 *            the article_tag_en to set
	 */
	public void setArticle_tag_en(String article_tag_en) {
		this.article_tag_en = article_tag_en;
	}

	/**
	 * @return the article_fee
	 */
	public int getArticle_fee() {
		return article_fee;
	}

	/**
	 * @param article_fee
	 *            the article_fee to set
	 */
	public void setArticle_fee(int article_fee) {
		this.article_fee = article_fee;
	}

	/**
	 * @return the article_isfee
	 */
	public boolean isArticle_isfee() {
		return article_isfee;
	}

	/**
	 * @param article_isfee
	 *            the article_isfee to set
	 */
	public void setArticle_isfee(boolean article_isfee) {
		this.article_isfee = article_isfee;
	}

	/**
	 * @return the article_delete
	 */
	public boolean isArticle_delete() {
		return article_delete;
	}

	/**
	 * @param article_delete
	 *            the article_delete to set
	 */
	public void setArticle_delete(boolean article_delete) {
		this.article_delete = article_delete;
	}

	/**
	 * @return the article_deleted_date
	 */
	public String getArticle_deleted_date() {
		return article_deleted_date;
	}

	/**
	 * @param article_deleted_date
	 *            the article_deleted_date to set
	 */
	public void setArticle_deleted_date(String article_deleted_date) {
		this.article_deleted_date = article_deleted_date;
	}

	/**
	 * @return the article_restored_date
	 */
	public String getArticle_restored_date() {
		return article_restored_date;
	}

	/**
	 * @param article_restored_date
	 *            the article_restored_date to set
	 */
	public void setArticle_restored_date(String article_restored_date) {
		this.article_restored_date = article_restored_date;
	}

	/**
	 * @return the article_modified_author_name
	 */
	public String getArticle_modified_author_name() {
		return article_modified_author_name;
	}

	/**
	 * @param article_modified_author_name
	 *            the article_modified_author_name to set
	 */
	public void setArticle_modified_author_name(String article_modified_author_name) {
		this.article_modified_author_name = article_modified_author_name;
	}

	/**
	 * @return the article_author_permission
	 */
	public short getArticle_author_permission() {
		return article_author_permission;
	}

	/**
	 * @param article_author_permission
	 *            the article_author_permission to set
	 */
	public void setArticle_author_permission(short article_author_permission) {
		this.article_author_permission = article_author_permission;
	}

	/**
	 * @return the article_source
	 */
	public String getArticle_source() {
		return article_source;
	}

	/**
	 * @param article_source
	 *            the article_source to set
	 */
	public void setArticle_source(String article_source) {
		this.article_source = article_source;
	}

	/**
	 * @return the article_language
	 */
	public byte getArticle_language() {
		return article_language;
	}

	/**
	 * @param article_language
	 *            the article_language to set
	 */
	public void setArticle_language(byte article_language) {
		this.article_language = article_language;
	}

	/**
	 * @return the article_focus
	 */
	public boolean isArticle_focus() {
		return article_focus;
	}

	/**
	 * @param article_focus
	 *            the article_focus to set
	 */
	public void setArticle_focus(boolean article_focus) {
		this.article_focus = article_focus;
	}

}
