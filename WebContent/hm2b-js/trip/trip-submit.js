//Trip URL controller
function tripController(){
	var TRIPURL = document.URL;
	var TRIPDIR = TRIPURL.split("#")[1];
	var TRIPSTATUS = TRIPDIR.split("-")[2];
	switch(TRIPSTATUS){
		case "1":
			loadTripSubmit1();
			break;
		case "2":
			loadTripSubmit2();
			break;
		case "3":
			loadTripSubmit3();
			break;
		default:
			loadTripSubmit1();
	}
}

function resetProgress(){
	for(var i = 1; i <= 3; i++){
		$("#pbStep-"+i).css("background-color","");
		$("#pbLine-"+i).css("background-color","");
		$("#pblink-"+i).addClass("my-link-disable");
	}
}

function progressDisplay(step){
	if(step == undefined){
		step = 1;
	}
	$("#pbStep-"+step).css("background-color","#33CCFF");
	$("#pbLine-"+step).css("background-color","#33CCFF");
	$("#pblink-"+step).removeClass("my-link-disable");
}

function loadTripSubmit1(){
	$(document).ready(function(){
		$.get("/HM2B/hm2b-pages/trip/trip-submit-1.html", function(data){
		    $("#tripContent").html(data);
		});
	});
	resetProgress();
	progressDisplay(1);
}

function loadTripSubmit2(){
	$(document).ready(function(){
		$.get("/HM2B/hm2b-pages/trip/trip-submit-2.html", function(data){
		    $("#tripContent").html(data);
		});
	});
	resetProgress();
	progressDisplay(1);
	progressDisplay(2);
}

function loadTripSubmit3(){
	$(document).ready(function(){
		$.get("/HM2B/hm2b-pages/trip/trip-submit-3.html", function(data){
		    $("#tripContent").html(data);
		});
	});
	resetProgress();
	progressDisplay(1);
	progressDisplay(2);
	progressDisplay(3);
}

//google auto complete
var placeSearch, autocomplete;
var componentForm = {
	street_number: 'short_name',
	route: 'long_name',
	locality: 'long_name',
	administrative_area_level_1: 'short_name',
	country: 'long_name',
	postal_code: 'short_name'
};

function initialize() {
	autocomplete = new google.maps.places.Autocomplete((document.getElementById('tripLocation')),{
		types: ['geocode']
	});
}
function geolocate() {
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(function(position) {
			var geolocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
			autocomplete.setBounds(new google.maps.LatLngBounds(geolocation, geolocation));
		});
	}
}
