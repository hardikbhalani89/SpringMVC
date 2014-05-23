/*Select Box Plugin
--------------------------------------------------------------------------------------------------*/
(function($)
{
	$.fn.selectBox = function(options){
			var defaults = {  
				contWidth: 200,
				selectMenu: 200
				
		};  
			var opt = $.extend(defaults, options);  
	this.each(function(){
/*------Get Class of select box-------*/
	var prefex = $(this).attr('class');
	
	var selectClass = prefex.split(" ")[0];
	$(this).wrap('<div class="select_box"></div>');
	if($(this).hasClass('alignright'))
	{
		$('.'+selectClass).parent().css({'width':opt.contWidth,'float':'right'});	
	}
	
	$('.'+selectClass).css('width',opt.contWidth);
	$('.'+selectClass).parent().css('width', opt.contWidth);
	
	
	var defval = $('.'+selectClass+' option:selected').text();
	
	$('.'+selectClass).after('<span></span>');
	$('.'+selectClass).after('<em>'+defval+'</em>');
	
	$('.'+selectClass).change(function() {  //Change Value With Selected option
	
   // assign the value to a variable, so you can test to see if it is working
    var selectVal = $('.'+selectClass+' option:selected').text();   //Get Value of selected option
	
	$('.'+selectClass).next('em').remove(); // Remove Em
	
	$('.'+selectClass).after('<em>'+selectVal+'</em>'); // Add new Element(EM) with Value
	});
	
	})	
	}	
})(jQuery);