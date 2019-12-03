

//Object 
var character = {
    name: "Randall",
    health: 15,
    maxHealth: 15,
    gold: 0,
    steps: 0,
    level: 1,
    potions: [5, 5, 5, 5],
    isAlive: true
};


function onBtnClickMe(e) {
    var roll = Math.random()*10;
    console.log(roll);
    if (roll > 5) {
        $("#story").text("You Encountered a goblin");
        character.health--;
        $("#Health").text(character.health);
    } else {
        $("#story").text("You successfully took a step");

    }
    
    character.steps++;
    if (character.steps % 10 == 0) {
        character.level++;
        $("#Level").text(character.level);
    }
    $("#steps").text(character.steps);
    e.preventDefault();
};

$(document).ready(function () {

    $("#Character").text(character.name);
    $("#Health").text(character.health);
    $("#MaxHealth").text(character.maxHealth);
    $("#Gold").text(character.gold);
    $("#Potions").text(character.potions);
    $("#Level").text(character.level);
    $("#isAlive").text(character.isAlive);
    $("#steps").text(character.steps);

    $("#btnClickMe").click(onBtnClickMe);



});





