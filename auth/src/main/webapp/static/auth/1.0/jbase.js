/*!
 * journey platform auth base JavaScript Library v1.0
 * http://journey ***.com/
 *
 * Copyright 2012 liu lin kun, All Rights Reserved.
 * 
 * Date: Wed 2012-12-05 12:46:34
 */

/**
 * 清空表单元素的输入值
 */
function clearForm(formId) {
	$("#" + formId +" input,textarea,select").val("");
	$("#" + formId +" input:radio,input:checkbox").attr("checked",false);
}


/**
 * 通过jsonObject的数据，对表单元素进行赋值
 * todu:对于radio和checkbox的赋值还不一定正确，需要测试和完善
 * @param formId  表单Id
 * @param jsonObject  json对象
 */
function setJsonValue2FormElements(formId,jsonObject) {
	$("#" + formId +" input,textarea,select").each(function(i){
		var value = jsonObject[this.name];
		if(!$.isEmptyObject(value)) {
			this.value = value;
		}
	});
	$("#" + formId +" input:radio,input:checkbox").each(function(i){
		var value = jsonObject[this.name];
		if(!$.isEmptyObject(value) || "false" == value) {
			this.checked = false;
		}
		if("true" == value) {
			this.checked = true;
		}
	});
}

/**
 * ajax 提交表单，并可回调callback函数
 * @param formId   表单Id
 * @param serverUrl 后台URL
 * @param callBack  
 */
function postFormToServer(formId,serverUrl,callBack) {
	var data = dealFormBeforeCallServer(formId);
	alert(data);
	$.post(serverUrl,data,callBack,'html');
	
}

function dealFormBeforeCallServer(formId) {
	var data = $("#" + formId).serialize();
	return data;
}