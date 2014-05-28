//Load the header and footer
loadHeader();
loadFooter();

//Main URL controller
mainController();

function mainController(){
	var URL = document.URL;
	var DIR = URL.split("#")[1];
	switch(DIR){
		case "trip-submit": 
		case "trip-submit-1": 
		case "trip-submit-2": 
		case "trip-submit-3":
			loadTripSubmit();
			break;
		case "trip-done":
			loadTripDone();
			break;
		default:
			if(checkLogin()){
				
			}else{
				loadSplash();
			}
	}
}

function checkLogin(){
	return false;
}

function loadHeader(){
	$(document).ready(function(){
		$.get("/HM2B/hm2b-pages/header.html", function(data){
		    $("#hm2bHeader").html(data);
		});
	});
}

function loadFooter(){
	$(document).ready(function(){
		$.get("/HM2B/hm2b-pages/footer.html", function(data){
		    $("#hm2bFooter").html(data);
		});
	});
}

function loadSplash(){
	$(document).ready(function(){
		$.get("/HM2B/hm2b-pages/splash/splash.html", function(data){
		    $("#hm2bContent").html(data);
		});
	});
}

function loadTripSubmit(){
	$(document).ready(function(){
		$.get("/HM2B/hm2b-pages/trip/trip-submit.html", function(data){
		    $("#hm2bContent").html(data);
		});
	});
}

function loadTripDone(){
	$(document).ready(function(){
		$.get("/HM2B/hm2b-pages/trip/trip-done.html", function(data){
		    $("#hm2bContent").html(data);
		});
	});
}