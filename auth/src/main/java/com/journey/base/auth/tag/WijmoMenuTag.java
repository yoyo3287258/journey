/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-5</p>
 */
package com.journey.base.auth.tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import com.journey.base.auth.constant.AuthConstants;
import com.journey.base.auth.model.MenuGroup;
import com.journey.base.auth.model.UserProfile;

/**
 * @author liulinkun
 *
 */
public class WijmoMenuTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6277401223723694669L;
	
	private MenuGroup menuGroup;

	
	@Override
	public int doStartTag() throws JspException {
		
		try {
			menuGroup = ((UserProfile)pageContext.getSession().getAttribute(AuthConstants.USER_PROFILE)).getMenuGroup();
			JspWriter out = this.pageContext.getOut();
			if(menuGroup == null) {
				out.println("No MenuGroup Object Found");
				return SKIP_BODY;
			}			
			/**
			 * 构造菜单
			 */
			out.println("<div class='headerMenu'>");
			out.println("<ul id='menu' >");
			int levels = 0;
			for(MenuGroup.Menu menu:menuGroup.getMenus(0)) {
				loopParse(menu,out);
			}
			out.println("</ul>");
			out.println("</div>");
		} catch (IOException e) {
			throw new JspException(e.getMessage());
		}
		
		return SKIP_BODY;
	}

	/**
	 * 递归构造菜单
	 * @param menu
	 * @param out
	 * @throws IOException
	 */
	private void loopParse(MenuGroup.Menu menu,JspWriter out) throws IOException {
		List<MenuGroup.Menu> cdMenuLst = menuGroup.getChildMenus(menu);
		if(cdMenuLst.size() > 0){
			out.println("<li><a >" +  menu.getChnName() + "</a>");
			out.println("<ul >");
			for(MenuGroup.Menu cdmenu:cdMenuLst) { 
				loopParse(cdmenu,out);
			}
			out.println("</ul>");
			out.println("</li>");
		}else {
			out.println("<li><a title='"+ menu.getUrl() +"'>" +  menu.getChnName() + "</a></li>");
		}
	}
	
	
	@Override
	public int doEndTag() throws JspException {
		return  EVAL_PAGE;
	}
	
	@Override
	public void release() {
		this.menuGroup = null;
		super.release();
	}
}
