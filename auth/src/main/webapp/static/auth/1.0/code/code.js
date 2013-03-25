/**
 * 码表管理
 */
/**
 * 初始化js
 */
jQuery(function() {
	/**
	 * 布局
	 */
	$('#d_pageLayout').omBorderLayout({
		fit:true,
	    panels:[{ 
	       id:"d_query", 
	       title:"列表", 
	       region:"west" ,
	       width:200 
	   },{ 
	       id:"d_detail", 
	       title: "详细", 
	       region:"center", 
	       resizable:true, 
	       collapsible:true
	   }], 
	   spacing:3 
	});
	/**
	 * 初始化码表树
	 */
	var setting = {
		async: {
			enable: true,
			url: ctx +"/code/getCodeTree",
			autoParam:["typeCode"]
		},
		view: {selectedMulti: false,autoCancelSelected: false},
		callback: {onClick: selectCodeType}   //鼠标单击节点时触发事件
	};
	$.fn.zTree.init($("#codeTypeTree"), setting);
	
	/**
	 * 初始化码表列表
	 */
	 $('#codeList').omGrid({
         height : 420,
         width : 'fit',
         limit : 10, //分页显示，每页显示10条
         singleSelect : true,
         colModel : [    {header:'码表类型',name:'typeName', width:400, align : 'center'},
                         {header:'码表代码',name:'typeCode', width:250, align : 'left'},
                         {header:'备注',name:'remark', width:'autoExpand',wrap:true}
         ],
         dataSource : '/auth/code/codeTypeQuery' //后台取数的URL
     });
	 /**
	  * 初始化按钮条
	  */
	 $('#editButtonBar1').omButtonbar({
     	btns : [{label:"新增",id:"button1" ,
     	 		 onClick:function(){
     	 			clearForm("layer1Editform");
     	 			initLayer1AddDialog();
     	 			}
     			},
     	        {label:"修改",id:"button2",
     	 		 onClick:function(){
	     	 			 var selectData = $("#codeList").omGrid('getSelections',true);
	     	 			 /**
	     	 			  * 没有选择数据则弹出消息框
	     	 			  */
	     	 			 if(selectData.length == 0) {
	     	 				alert("请选择数据！");
	     	 				return false;
	     	 			 }
	     	 			 clearForm("layer1Editform");
	     	 			 setJsonValue2FormElements("layer1Editform",selectData[0]);
	     	 			 initLayer1EditDialog();
     	 			 }
     	        },
     	        {label:"删除",id:"button3" ,
     	        	onClick:function(){
     	        		 var selectData = $("#codeList").omGrid('getSelections',true);
	     	 			 /**
	     	 			  * 没有选择数据则弹出消息框
	     	 			  */
	     	 			 if(selectData.length == 0) {
	     	 				alert("请选择数据！");
	     	 				return false;
	     	 			 }
	     	 			 function callback(data) {
	     	 				 alert(data);
	     	 			 }
	     	 			 //ajax调用后台删除数据
	     	 			 $.post(ctx+"/code/deleteCodeType",selectData[0],callback,"html");
     	 			 }
     	        }]
		 });
});

function initLayer1AddDialog() {
	 //新增
	 $( "#layer1EditDialog").omDialog({
			autoOpen: true,
			modal: true,
			title: '新增',
			width: 350,
			resizable: false,
			closeOnEscape: false,
			buttons :[
			          {text:'确定',click:function(){
			        	  /**
		        		   * 调用后台新增码表类型分类
		        		   */
			        	  var callBack = function(data) {
			        		  $( "#layer1EditDialog").omDialog('close');
			        		  alert(data);
			        		  clearForm("layer1Editform");
			        	  };
			        	  
			        	  postFormToServer("layer1Editform",ctx + '/code/addCodeType',callBack);
			          }},
			          {text:'取消',click:function(){
			        	  $( "#layer1EditDialog").omDialog('close');
			        	  clearForm("layer1Editform");
			          }} 
			          ]
		});
}


function initLayer1EditDialog() {
	 //修改
	 $( "#layer1EditDialog").omDialog({
			autoOpen: true,
			modal: true,
			title: '修改',
			width: 350,
			resizable: false,
			closeOnEscape: false,
			buttons :[
			          {text:'确定',click:function(){
			        	  
			        	  /**
		        		   * 调用后台新增码表类型分类
		        		   */
			        	  var callBack = function(data) {
			        		  $( "#layer1EditDialog").omDialog('close');
			        		  alert(data);
			        		  clearForm("layer1Editform");
			        	  };
			        	  
			        	  postFormToServer("layer1Editform",ctx + '/code/updateCodeType',callBack);
			          }},
			          {text:'取消',click:function(){
			        	  $( "#layer1EditDialog").omDialog('close');
			        	  clearForm("layer1Editform");
			          }} 
			          ]
		});
	
}

/**
 * ajax调用后台改变码表列表显示
 * @param event
 * @param treeId
 * @param treeNode
 */
function selectCodeType(event, treeId, treeNode) {
	var level = treeNode["level"];
	var param = {};
	param["typeCode"] = treeNode["typeCode"];
	if(level == 0) {
		 //列表
		 $('#codeList').omGrid({
	         height : 420,
	         width : 'fit',
	         limit : 10, //分页显示，每页显示10条
	         singleSelect : true,
	         colModel : [    {header:'码表类型',name:'typeName', width:400, align : 'center'},
	                         {header:'码表代码',name:'typeCode', width:250, align : 'left'},
	                         {header:'备注',name:'remark', width:'autoExpand',wrap:true}
	         ],
	         dataSource : '/auth/code/codeTypeQuery', //后台取数的URL
	         extraData : param
	     });
		//使“上级码表类型”行显示
		$("#td_groupName").removeClass("invisible");
		$("#button1").omButton(
			{onClick: function(){
						clearForm("layer1Editform");
						$("#td_groupName input").val(treeNode["typeCode"]);
		 	 			initLayer1AddDialog();
					}
			});
	}
	if(level == 1) {
		//列表
		$('#codeList').omGrid({
	         height : 420,
	         width : 'fit',
	         limit : 10, //分页显示，每页显示10条
	         singleSelect : true,
	         colModel : [    {header:'编码',name:'code', width:200, align : 'center'},
	                         {header:'编码值',name:'codeValue', width:200, align : 'left'},
	                         {header:'排序',name:'indexNo', width:'50',align : 'left'},
	                         {header:'码表代码',name:'codeType', width:200, align : 'left'},
	                         {header:'备注',name:'remark', width:'autoExpand',wrap:true}
	         ],
	         dataSource : '/auth/code/codeInfoQuery', //后台取数的URL
	         extraData : param
	     });
		//按钮条
		 $('#editButtonBar').omButtonbar({
		     	btns : [{label:"新增",id:"button1" ,
		     	 		 onClick:function(){
		     	 			clearForm("layer1Editform");
		     	 			initLayer1AddDialog();
		     	 			}
		     			},
		     	        {label:"修改",id:"button2",
		     	 		 onClick:function(){
			     	 			 var selectData = $("#codeList").omGrid('getSelections',true);
			     	 			 /**
			     	 			  * 没有选择数据则弹出消息框
			     	 			  */
			     	 			 if(selectData.length == 0) {
			     	 				alert("请选择数据！");
			     	 				return false;
			     	 			 }
			     	 			 clearForm("layer1Editform");
			     	 			 setJsonValue2FormElements("layer1Editform",selectData[0]);
			     	 			 initLayer1EditDialog();
		     	 			 }
		     	        },
		     	        {label:"删除",id:"button3" ,
		     	        	onClick:function(){
		     	        		 var selectData = $("#codeList").omGrid('getSelections',true);
			     	 			 /**
			     	 			  * 没有选择数据则弹出消息框
			     	 			  */
			     	 			 if(selectData.length == 0) {
			     	 				alert("请选择数据！");
			     	 				return false;
			     	 			 }
			     	 			 function callback(data) {
			     	 				 alert(data);
			     	 			 }
			     	 			 //ajax调用后台删除数据
			     	 			 $.post(ctx+"/code/deleteCodeType",selectData[0],callback,"html");
		     	 			 }
		     	        }]
				 });
	}
}
