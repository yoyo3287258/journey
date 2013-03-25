<%@tag pageEncoding="UTF-8"%>

<script type="text/javascript">
	jQuery(function() {
		/**
		 * 给content赋予contentHeight的样式
		 */
		var contentHeight = jQuery('div.contentLayout').height() -25 -10 ;
		jQuery('.content').css('height',contentHeight);
		
		
		var westTitle = jQuery('.west-panel').attr("title");
		var centerTitle = jQuery('.center-panel').attr("title");
		
		jQuery('.west-panel').attr("id",jQuery('.west-panel').attr("class"));
		jQuery('.center-panel').attr("id",jQuery('.center-panel').attr("class"));
		var westId = jQuery('.west-panel').attr("id");
		var centerId = jQuery('.center-panel').attr("id");
		jQuery('.content').omBorderLayout({
			    panels:[{ 
			       id:centerId, 
			       title:centerTitle, 
			       region:"center" 
			   },{ 
			       id:westId, 
			       title: westTitle, 
			       region:"west", 
			       resizable:true, 
			       collapsible:true, 
			       width:200 
			   }], 
			   spacing:3 
			});
	});
</script>