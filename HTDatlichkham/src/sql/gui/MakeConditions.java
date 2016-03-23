/**
 * 
 */
package sql.gui;

import haui.objects.ArticleObject;

/**
 * @author Dinh Hieu
 *
 */
public class MakeConditions {

	/**
	 * 
	 */
	public MakeConditions() {

	}

	public static String createCondition(ArticleObject similar) {
		String tmp = "";
		short sid = similar.getArticle_section_id();
		if (similar != null) {
			if (sid == 0) {
				sid = similar.getCategory_section_id();

				if (sid == 0) {
					sid = similar.getArticle_section_id();
				}
			}
		}

		short cid = similar.getArticle_category_id();
		if (cid == 0) {
			cid = similar.getCategory_id();
		}

		boolean focus = similar.isArticle_focus();

		// tao cac dieu kien cho menh de WHERE
		if (sid > 0) {
			tmp = " (article_section_id= " + sid + " )";
		}

		if (cid > 0) {
			if (!tmp.equalsIgnoreCase("")) {
				tmp += " AND (article_category_id=" + cid + ") ";
			} else {
				tmp += " (article_category_id=" + cid + ") ";
			}
		}

		if (focus) {
			if (!tmp.equalsIgnoreCase("")) {
				tmp += " AND (article_focus = 1) ";
			} else {
				tmp += " (article_focus = 1) ";
			}
		}

		return tmp;
	}

}
