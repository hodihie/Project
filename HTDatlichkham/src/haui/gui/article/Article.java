/**
 * 
 */
package haui.gui.article;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.ArticleObject;
import haui.objects.UserObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Article extends ShareControl {

	public ResultSet getArticle(int id);
	public ResultSet getArticle(int id, boolean isUpdated);//co cap nhat so lan doc ko	
	
	public ResultSet getArticles(ArticleObject similar, int at, byte total, boolean isMostVisited);

	public ResultSet[] getArticles(ArticleObject similar, int at, byte total, UserObject user);
}
