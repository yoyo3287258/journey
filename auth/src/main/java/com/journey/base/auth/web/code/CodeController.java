package com.journey.base.auth.web.code;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springside.modules.mapper.JsonMapper;

import com.journey.base.auth.entity.CodeInfo;
import com.journey.base.auth.entity.CodeType;
import com.journey.base.auth.model.CodeTypeTreeNode;
import com.journey.base.auth.model.GridModel;
import com.journey.base.auth.service.Code.CodeInfoService;
import com.journey.base.auth.service.Code.CodeTypeService;

/**
 * CodeController负责打开码表页面，以及对码表的操作
 * 码表类型是二级树状结构，第一级是码表类型的分类，第二级才是具体的码表类型
 * @author 刘霖坤
 */
@Controller
public class CodeController {

	@Autowired
	private CodeTypeService codeTypeService;
	
	@Autowired
	private CodeInfoService codeInfoService;
	
	@RequestMapping(value = "/code/view",method=RequestMethod.GET)
	public String codeView() {
		return "code/code";
	}

	/**
	 * 获得码表类型的树节点
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/code/getCodeTree")
	public void getCodeTree(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String typeCode = request.getParameter("typeCode");
		/**
		 * 第一次加载父节点
		 */
		if(typeCode == null) {
			List<CodeType> groupList = this.codeTypeService.getCodeTypeByGroup(0,Integer.MAX_VALUE);
			List<CodeTypeTreeNode> cttnLst = this.transCodeType(groupList,true);
			String jsonStr = JsonMapper.nonEmptyMapper().toJson(cttnLst);
			response.getWriter().write(jsonStr);
		}else {
			/**
			 * 异步加载子节点
			 */
			Map<String,Object> param = new HashMap<String,Object>();
			param.put("groupName", typeCode);
			List<CodeType> codeTypeList = this.codeTypeService.getCodeTypeByCondition(param, 0, Integer.MAX_VALUE);
			List<CodeTypeTreeNode> cttnLst = this.transCodeType(codeTypeList,false);
			String jsonStr = JsonMapper.nonEmptyMapper().toJson(cttnLst);
			response.getWriter().write(jsonStr);
		}
	}
	
	/**
	 *获得码表类型的列表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/code/codeTypeQuery")
	public void searchCodeTypeList(@RequestParam Map<String,String> param, HttpServletResponse response) throws IOException {
		String startStr = param.get("start");
	    String limitStr = param.get("limit");
	    String typeCode = param.get("typeCode");
	    int offset = Integer.parseInt(startStr);
	    int pagesize = Integer.parseInt(limitStr);
	    if(StringUtils.isEmpty(typeCode)) {
	    	List<CodeType>  lst = codeTypeService.getCodeTypeByGroup(offset,pagesize);
	    	int total = codeTypeService.getCountOfCodeTypeByGroup();
	    	GridModel<CodeType> gm = new GridModel<CodeType>();
			gm.setTotal(total);
			gm.setRows(lst);
			String jsonStr = JsonMapper.nonDefaultMapper().toJson(gm);
			response.getWriter().write(jsonStr);
		}else {
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("groupName", typeCode);
			List<CodeType>  lst = codeTypeService.getCodeTypeByCondition(condition, offset, pagesize);
			int total = codeTypeService.getCountOfCodeTypeByCondition(condition);
			GridModel<CodeType> gm = new GridModel<CodeType>();
			gm.setTotal(total);
			gm.setRows(lst);
			String jsonStr = JsonMapper.nonDefaultMapper().toJson(gm);
			response.getWriter().write(jsonStr);
		}
	}
	
	/**
	 *获得编码值列表
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/code/codeInfoQuery")
	public void searchCodeInfoList(@RequestParam Map<String,String> param, HttpServletResponse response) throws IOException {
		String startStr = param.get("start");
	    String limitStr = param.get("limit");
	    String typeCode = param.get("typeCode");
	    int offset = Integer.parseInt(startStr);
	    int pagesize = Integer.parseInt(limitStr);
	    if(StringUtils.isNotEmpty(typeCode)) {
	    	List<CodeInfo>  lst = codeInfoService.getCodeInfoByCodeType(typeCode, offset, pagesize);
	    	int total = codeInfoService.getCountOfCodeInfoByCodeType(typeCode);
	    	GridModel<CodeInfo> gm = new GridModel<CodeInfo>();
			gm.setTotal(total);
			gm.setRows(lst);
			String jsonStr = JsonMapper.nonDefaultMapper().toJson(gm);
			response.getWriter().write(jsonStr);
		}
	}
	
	
	/**
	 * 保存码表类型
	 * @param codeType
	 * @throws IOException
	 */
	@RequestMapping(value = "/code/addCodeType")
	public void addCodeType(@ModelAttribute CodeType codeType,HttpServletResponse response) throws IOException {
		try{
			this.codeTypeService.save(codeType);
			response.getWriter().write("保存成功！");
		}catch(Exception e) {
			response.getWriter().write("保存失败！\n" + e.getMessage());
		}
	}
	
	/**
	 * 修改码表类型
	 * @param codeType
	 * @throws IOException
	 */
	@RequestMapping(value = "/code/updateCodeType")
	public void updateCodeType(@ModelAttribute CodeType codeType,HttpServletResponse response) throws IOException {
		try{
			this.codeTypeService.update(codeType);
			response.getWriter().write("更新成功！");
		}catch(Exception e) {
			response.getWriter().write("更新失败！\n" + e.getMessage());
		}
	}
	
	/**
	 * 删除码表类型
	 * @param codeType
	 * @throws IOException
	 */
	@RequestMapping(value = "/code/deleteCodeType")
	public void deleteCodeType(@ModelAttribute CodeType codeType,HttpServletResponse response) throws IOException {
		try{
			this.codeTypeService.delete(codeType);
			response.getWriter().write("删除成功！");
		}catch(Exception e) {
			response.getWriter().write("删除失败！\n" + e.getMessage());
		}
	}
	
	/**
	 * 把码表模型转换成页面数节点的结构
	 * @param list
	 * @return
	 */
	private List<CodeTypeTreeNode> transCodeType(List<CodeType> list,boolean isParent) {
		List<CodeTypeTreeNode> retLst = new ArrayList<CodeTypeTreeNode>();
		for(CodeType ct:list) {
			CodeTypeTreeNode cttn = new CodeTypeTreeNode();
			cttn.setName(ct.getTypeName());
			cttn.setParent(isParent);
			cttn.setTypeCode(ct.getTypeCode());
			retLst.add(cttn);
		}
		return retLst;
	}
	
}
