//load the header
$(document).ready(function(){
	$.get("/HM2B/hm2b-pages/header.html", function(data){
	    $("#hm2bHeader").html(data);
	});
});

//load the footer
$(document).ready(function(){
	$.get("/HM2B/hm2b-pages/footer.html", function(data){
	    $("#hm2bFooter").html(data);
	});
});