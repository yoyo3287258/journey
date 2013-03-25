/*!
 * journey platform auth base JavaScript Library v1.0
 * http://journey ***.com/
 *
 * Copyright 2012 liu lin kun, All Rights Reserved.
 * 
 * Date: Wed 2012-12-05 12:46:34
 */

jQuery(function() {
	
	/**
	 * 设置高度
	 */
	var screenHeight = $(window).height();
	var pageLayoutHeight = screenHeight ; 
	var headerHeight = jQuery('#header').height();
	var footerHeight = jQuery('#footer').height();
	var headerBorder = 2,footerPadding = 15,footerBorder = 2;
	var contentHeight = pageLayoutHeight - headerHeight - headerBorder - footerPadding - footerHeight - footerBorder;
	jQuery('div.pageLayout').css("height",pageLayoutHeight);
	jQuery('div.contentLayout').css("height",contentHeight);
		
	/**
	 * 初始化主页的tab控件
	 */
	var mainTabs = jQuery('#mainTabs');
	if(mainTabs) {
		window._$_mainTabs = mainTabs.omTabs({
			height : 'fit',
			onBeforeClose  : function(n,event) {
				/**
				 * 防止关闭了的tab打不开，关闭前，把存有tabId的值remove
				 */
				var tabId = _$_mainTabs.omTabs('getAlter',n);
				_$_mainTabs.removeData(tabId);
		     },
		});
	}
	
	/**
	 * 为菜单添加单击事件
	 */
	jQuery('ul.dropdown').delegate('a','click',function(){
		var iframeHeight = jQuery('#mainTabs>div').last().height();
		var iframeString = '<iframe src="" style="height:' + (iframeHeight-2-18) + 'px;width: 100%;border:0" ></iframe>';
		if(this.title) {
			jQuery('ul.dropdown li > ul ').css('visibility','hidden');
			/**
			 * 避免重复打开相同的tab，当取出的tabId有值时，直接返回
			 */
			var tabId = _$_mainTabs.data($(this).text());
			if(tabId) {
				return;
			}
			_$_mainTabs.data($(this).text(),$(this).text());
			_$_mainTabs.omTabs('add',{
			    title : $(this).text(),
			    content : mergeIframeURL(iframeString,this.title.substr(1)),
			    closable : true,
			    tabId : $(this).text()
			});
		}
	});
	
});


function mergeIframeURL(iframeString,url) {
	var mergedURL;
	mergedURL = iframeString.replace('src=""','src="'+ url + '"');
	return mergedURL;
}
