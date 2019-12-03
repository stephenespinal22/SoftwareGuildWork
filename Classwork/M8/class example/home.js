function Character(health){
  var self = this;
  self.health = health;
}
var character = {
  health: 15,
  maxHealth: 15,
  gold:0,
  steps:0,
  potions:[5,5,5,5]
};
function onBtnClickMe (e){
  console.log('test');
  $("#example").fadeIn("slow");
  $("#example").append("<p>Hello</p>");
  var c = new Character(20);
  var b = new Character(10);
  console.log(character);
  console.log(c);
  e.preventDefault();
}
function blowMindsOfStudents(callback){
  callback("Wow");
}
$(document).ready(function(){
  $(".box").css("width", "50%");
  $("#example").css("background-color","red");
  
  $("#btnClickMe").click(onBtnClickMe);
  blowMindsOfStudents(function(msg){
    console.log(msg);
  });
});