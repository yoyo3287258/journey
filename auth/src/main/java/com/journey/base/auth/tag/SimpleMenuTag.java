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

import org.apache.shiro.SecurityUtils;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import com.journey.base.auth.constant.AuthConstants;
import com.journey.base.auth.model.MenuGroup;
import com.journey.base.auth.model.UserProfile;
import com.journey.base.auth.service.account.UserProfileService;

/**
 * @author liulinkun
 *
 */
public class SimpleMenuTag extends TagSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6277401223723694669L;
	
	private MenuGroup menuGroup;

	
	@Override
	public int doStartTag() throws JspException {
		
		try {
			menuGroup = ((UserProfile)pageContext.getSession().getAttribute(AuthConstants.USER_PROFILE)).getMenuGroup();
			/**
			 * 当web容器启动后，每次修改代码，容器会自动重启加载修改后的代码，但是会清空掉session的值，然而重启前登录过的用户，shoro却会保存已经登录的状态。
			 * 由于menugroup等用户相关的信息存储在session中，这就导致menuGroup取出的是null
			 * 所以需要重新获取相关信息并存放到session中
			 * 
			 * 新：当把作为session Attribute 的UserProfile，menugroup 等 类 设置成serializable后，重启时容器会序列化这些属性，并把反序列化到session中。
			 * 以至于不会导致session的属性被清空的情况
			 */
			if(menuGroup == null && SecurityUtils.getSubject().isAuthenticated()) {
				WebApplicationContext wc =ContextLoaderListener.getCurrentWebApplicationContext();
				UserProfileService userProfileService =  (UserProfileService)wc.getBean("userProfileService");
				userProfileService.setUserProfileToSession(SecurityUtils.getSubject().getPrincipals().toString());
				menuGroup = ((UserProfile)pageContext.getSession().getAttribute(AuthConstants.USER_PROFILE)).getMenuGroup();
			}
			JspWriter out = this.pageContext.getOut();
			if(menuGroup == null) {
				out.println("No MenuGroup Object Found");
				return SKIP_BODY;
			}
			
			/**
			 * 构造菜单
			 */
			out.println("<div class='headerMenu'>");
			out.println("<ul class='dropdown'>");
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
			out.println("<li><a href='#'> <span>" +  menu.getChnName() + "</span><span></span></a>");
			out.println("<ul >");
			for(MenuGroup.Menu cdmenu:cdMenuLst) { 
				loopParse(cdmenu,out);
			}
			out.println("</ul>");
			out.println("</li>");
		}else {
			out.println("<li><a href='javascript:void(0)' title='"+ menu.getUrl() +"'>" +  menu.getChnName() + "</a></li>");
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
