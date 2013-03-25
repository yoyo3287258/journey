/* <p>Copyright@ Journey Platform(2012) All right reserved.</p>
 *	 
 * @author liulinkun
 * <p>Datetime:2012-12-24</p>
 */
package com.journey.base.auth.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.commons.lang3.StringUtils;
import org.springside.modules.mapper.JsonMapper;

import com.journey.base.auth.tag.model.Column;

/**
 * grid标签，作用是把Grid标签转换成OM-Grid组件输出
 */
public class GridTag extends SimpleTagSupport {

	/**
	 * id		*require
	 */
	private String id;
	/**
	 * 从url地址用ajax方式取数  		*require
	 */
	private String url;
	/**
	 * 表格高度，单位为px,也可以设为'fit'，表示自适应父容器高度。默认fit
	 */
	private String height;
	/**
	 * 表格宽度，单位为px,也可以设为'fit'，表示自适应父容器宽度。默认100%
	 */
	private String width;
	/**
	 * 每页数据条数，比如每页要显示10条则设成10。注意：如果设成0或负数则不分页
	 *此属性仅用于取数不用于显示,
	 *即如果limit设成10，取数时告诉后台要10条数据，如果后台非要返回15条数据，
	 *则页面会显示出15条而不是10条数据）,默认15条 
	 */
	private String pagesize;
	/**
	 * 是否在最左边显示序号列。默认false
	 */
	private String showIndex;
	/**
	 * 是否自动拉伸各列以适应表格的宽度
	 *（比如共2列第一列宽度100第二列宽度200，
	 *则当表格总宽度是600px时第一列自动会变成200px第二列宽度会自动变成400px
	 *，而如果表格总宽度是210px时第一列自动会变成70px第二列宽度会自动变成140px）
	 *。注意：只有所有列的宽度都不是'autoExpand'时该属性才会起作用。默认false
	 */
	private String autoFit;
	
	
	private List<Column> columnLst = new ArrayList<Column>();
	

	
	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(this.getJspContext().getOut());
		if(columnLst.size() == 0) {
			throw new JspException("the grid tag must have  its children tag 'cloumnTag' !");
		}
		checkAttribute();
		String outStr = this.parseTag();
		this.getJspContext().getOut().write(outStr);
	}
	
	/**
	 * 检验标签属性
	 */
	private void checkAttribute() {
		
		/**
		 * 通过ELResolver,解析出当前JspContext实例中的request属性
		 */
		ELContext el = this.getJspContext().getELContext();
		HttpServletRequest request = (HttpServletRequest)el.getELResolver().getValue(el, this.getJspContext(), "request");
		this.url = request.getContextPath() + url;
		if(StringUtils.isEmpty(height)) {
			height = "fit";
		}
		if("fit".equals(height)) {
			height = "'" + height + "'";
		}
		if(StringUtils.isEmpty(width)) {
			width = "fit";
		}
		if("fit".equals(width)) {
			width = "'" + width + "'";
		}
		if(StringUtils.isEmpty(pagesize)) {
			pagesize = "15";
		}
		if(StringUtils.isEmpty(showIndex)) {
			showIndex = "false";
		}
		if(StringUtils.isEmpty(autoFit)) {
			autoFit = "false";
		}
	}

	private String parseTag() {
		/**
		 * 列是json格式的数据，需要进行json转换
		 */
		String colModel = JsonMapper.nonEmptyMapper().toJson(this.getColumnLst());
		
		StringBuilder sb = new StringBuilder();
		sb.append("<script type=\"text/javascript\">");
			sb.append("jQuery(document).ready(function() {");
				sb.append("jQuery('#"+ id + "').omGrid({");
					sb.append("title : '',");
					sb.append(" dataSource : '"+ url + "',");
					sb.append(" height : "+ height + ",");
					sb.append(" limit : "+ pagesize + ",");
					sb.append(" showIndex : "+ showIndex + ",");
					sb.append(" autoFit : "+ autoFit + ",");
					sb.append(" colModel : "+ colModel + ",");
				sb.append(" });");
			sb.append("});");
		sb.append("</script>");
		sb.append("<table id='"+ id + "'></table>");
		return sb.toString();
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public String getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(String width) {
		this.width = width;
	}

	/**
	 * @return the pagesize
	 */
	public String getPagesize() {
		return pagesize;
	}

	/**
	 * @param pagesize the pagesize to set
	 */
	public void setPagesize(String pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * @return the showIndex
	 */
	public String getShowIndex() {
		return showIndex;
	}

	/**
	 * @param showIndex the showIndex to set
	 */
	public void setShowIndex(String showIndex) {
		this.showIndex = showIndex;
	}

	/**
	 * @return the autoFit
	 */
	public String getAutoFit() {
		return autoFit;
	}

	/**
	 * @param autoFit the autoFit to set
	 */
	public void setAutoFit(String autoFit) {
		this.autoFit = autoFit;
	}

	/**
	 * @return the columnTagLst
	 */
	public List<Column> getColumnLst() {
		return columnLst;
	}

	/**
	 * @param columnTagLst the columnTagLst to set
	 */
	public void setColumnLst(List<Column> columnLst) {
		this.columnLst = columnLst;
	}
}
