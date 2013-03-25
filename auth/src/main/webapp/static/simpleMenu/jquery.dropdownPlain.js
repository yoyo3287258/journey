$(function(){

    $("ul.dropdown li").hover(function(){
        $(this).addClass("hover");
        $('ul:first',this).css('visibility', 'visible');
    }, function(){
        $(this).removeClass("hover");
        $('ul:first',this).css('visibility', 'hidden');
    });
    /**
     * 给第一层级加圆角
     */
    $("ul.dropdown>li:first").addClass("j_corner-left");
    $("ul.dropdown>li:last").addClass("j_corner-right");
    /**
     * 给第二层级加圆角
     */
    $("ul.dropdown>li>ul").each(function(i){
    	$(">li:first",this).addClass("j_corner-top");
    	$(">li:last",this).addClass("j_corner-bottom");
    	});
    /**
     * 给第三层级加圆角
     */
    $("ul.dropdown>li>ul>li>ul").each(function(i){
    	$(">li:first",this).addClass("j_corner-top");
    	$(">li:last",this).addClass("j_corner-bottom");
    	});
    
    $("ul.dropdown li").each(
		function(i){
			if($(this).has("ul")) {
				$(">a:first>span:last",this).addClass("hasChildMenuItem");
			}
    	}
    );
});