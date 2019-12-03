var ds = new DataService();

var zipCode;

function onSubmitAddZip(){
    zipCode = $("#inputZipCode").val();

    ds.getFiveDay(zipCode, callback ,errormsg);

};

function callback(weather) {
    $("#text").text(weather.name);
}


$(document).ready(function () {
    $("#submit").on("click", onSubmitAddZip)
});

function errormsg(msg) {
    alert(msg);
}