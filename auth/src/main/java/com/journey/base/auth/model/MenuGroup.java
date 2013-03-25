/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-11-27</p>
 */
package com.journey.base.auth.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.util.CollectionUtils;

import com.journey.base.auth.constant.AuthConstants;
import com.journey.base.auth.entity.Resource;

/**
 * 菜单组，提供相应的插入，取出等方法
 */
public class MenuGroup extends Model {
	
	/**
	 *  MenuGroup.java
	 */
	private static final long serialVersionUID = -4112177613362756543L;

	int levels = 0;
	
	/**
	 * map的结构：key：层级，value：每一层所有的menu所构成的Map
	 */
	Map<Integer, Map<String,Menu>> menus = new HashMap<Integer, Map<String,Menu>>();
	
	
	
	/**
	 * 插入类型为资源到菜单组中
	 * @param res
	 */
	public void setMenu(Resource res) {
		if(res == null || !res.getResTypeCode().equals(AuthConstants.RES_TYPE_MENU)){
			return;
		}
		//因为一级菜单处于资源等级的第二级，所以计算菜单等级需要减以2
		setMenu(res,res.getLevel().intValue()-2);
	}
	
	public void setMenu(Resource res,int level) {
		
		levels = (level > levels)? level:levels;
		
		Map<String,Menu> levelMenus = menus.get(level);
		if(levelMenus == null) {
			levelMenus = new HashMap<String,Menu>();
			menus.put(level, levelMenus);
		}
		levelMenus.put(res.getResCode(), new Menu(res));
	}
	/**
	 *  得到菜单层级
	 */
	public int getMenuLevels() {
		return levels;
	}
	
	/**
	 * 得到每一级的所有菜单
	 */
	public List<Menu> getMenus(int level) {
		Map<String, Menu> m = this.menus.get(level);
		return new ArrayList<Menu>(m.values());
	}
	
	/**
	 * 得到传入菜单的子菜单
	 */
	public List<Menu> getChildMenus(Menu menu) {
		List<Menu> menuList = new ArrayList<Menu>();
		if(menu == null) return menuList;
		Map<String,Menu> map = this.menus.get(menu.getLevel()+1);
		if(CollectionUtils.isEmpty(map)) {
			return menuList;
		}
		Iterator<String> i = map.keySet().iterator();
		while(i.hasNext()) {
			Menu m = map.get(i.next());
			if(m.getParentResCode().equals(menu.getResCode())) {
				menuList.add(m);
			}
		}
		return menuList;
	}
	
	/**
	 * 菜单类
	 */
	public class Menu extends Model{
		
		/**
		 *  MenuGroup.java
		 */
		private static final long serialVersionUID = 6582224073604099364L;
		
		private String resCode;
		private String name;
		private String chnName;
		private String url;
		private int level;
		private String parentResCode;
		public Menu(Resource re) {
			resCode = re.getResCode();
			name = re.getRemark();
			chnName = re.getResName();
			url = re.getExt1();
			//因为一级菜单处于资源等级的第二级，所以计算菜单等级需要减以2
			level = re.getLevel().intValue() -2;
			parentResCode = re.getParentResCode();
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getChnName() {
			return chnName;
		}
		public void setChnName(String chnName) {
			this.chnName = chnName;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
		public int getLevel() {
			return level;
		}
		public void setLevel(int level) {
			this.level = level;
		}
		public String getParentResCode() {
			return parentResCode;
		}
		public void setParentResCode(String parentResCode) {
			this.parentResCode = parentResCode;
		}
		public String getResCode() {
			return resCode;
		}
		public void setResCode(String resCode) {
			this.resCode = resCode;
		}
	}
}
