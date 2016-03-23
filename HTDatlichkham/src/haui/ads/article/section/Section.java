/**
 * 
 */
package haui.ads.article.section;

import java.sql.ResultSet;

import haui.ShareControl;
import haui.objects.SectionObject;

/**
 * @author Dinh Hieu
 *
 */
public interface Section extends ShareControl {
	public boolean addSection(SectionObject item);
	public boolean editSection(SectionObject item);
	public boolean delSection(SectionObject item);
	
	public ResultSet getSection(short id);
	public ResultSet getSections(SectionObject similar, int at, byte total);
}
