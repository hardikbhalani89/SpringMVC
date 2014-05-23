$(function(){
	$("#fileField").css("width","150px");
	$('#browse').on('click',function (e) {
     $("#fileField").click();
	  //alert('done');
	  e.preventDefault();
	});
	
	/* Popup Box function */
	$(document).keyup(function(e) {
	  if (e.keyCode == 27) { unloadPopupBox(); }
	});

	
});
//TO Unload the Popupbox
function unloadPopupBox() {
	$('#popup_box').fadeOut("slow");
	$('#wrapper').find('.overlay').remove();
}   
       
// To Load the Popupbox
function loadPopupBox(pouptext,popupvalue) {
	
	var divHeight = $(document).height();
	var overlayHTML = '<div class="overlay" onclick="unloadPopupBox();"></div>';
	$('#wrapper').append(overlayHTML);
	$('.overlay').css("height",divHeight);
	$('#popup_box').fadeIn("slow");
	$("#pouptext").html(pouptext);
	
	
	if(popupvalue!=undefined && popupvalue!=""){
		$("#popupvalue").val(popupvalue);
		$("#popupvalue").show();
	}else{
		$("#popupvalue").hide();
	}
}