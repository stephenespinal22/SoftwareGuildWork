let ds = new DataService();

let currentId = null;
let amountInMachine = 0;

function emptyMessages() {
    $("#changeMessage").text("");
    $("#message").text("");
};

function emptyMachine() {
    //release change all at once
    amountInMachine = 0;
    //display new amount
    let amountForDisplay = amountInMachine.toFixed(2)
    $("#totalIn").text("$" + amountForDisplay);
    amountInMachine = parseFloat(amountForDisplay);
};


//format selections
function formatSelection(item) {
    return `<div class="selection" data-itemid='${item.id}' id="${item.id}">
    <p>${item.id}</p>
    <p>${item.name}</p>
    <p>$${item.price.toFixed(2)}</p>
    <p>Quantity Left: ${item.quantity}</p>
  </div>`;
};

function refreshItems(items) {
    let selections = $("#items");
    selections.empty();
    for (let i = 0; i < items.length; i++) {
        const item = items[i];
        $(selections).append(formatSelection(item));
    }
    //maintain selection highlighted
    if (currentId != null) {
        $(`#${currentId}`).css("border", "5px solid CornflowerBlue");
    }
};

function errorItems() {
    alert("Could not get items");
};

function errorPurchase(result) {
    $("#message").text(result.responseJSON.message);
    ds.getItems(refreshItems, errorItems);
};

function selectItem(e) {
    e.preventDefault();
    emptyMessages();

    currentId = $(this).data('itemid');
    $("#itemIdSelected").text(currentId);

    //highlight on click
    //remove any highlight
    $(".selection").css("border", "1px solid black");
    //add highlight on this
    $(this).css("border", "5px solid CornflowerBlue");
};

function addMoney(e) {
    e.preventDefault();
    emptyMessages();

    let amount = parseFloat($(this).data('id'));
    amountInMachine += amount;
    let amountForDisplay = amountInMachine.toFixed(2)
    $("#totalIn").text("$" + amountForDisplay);
    amountInMachine = parseFloat(amountForDisplay);
};

function clickMakePurchase(e) {
    e.preventDefault();
    emptyMessages();

    if (currentId == null) {
        alert("Please make a selection");
        return;
    }
    if (amountInMachine == 0) {
        alert("Please add money");
        return;
    }
    ds.buyItem(amountInMachine, currentId, makePurchase, errorPurchase);
};

function makePurchase(result) {
    $("#message").text("Thank you!!!");

    //update the items quantity
    ds.getItems(refreshItems, errorItems);

    // //update amount in machine
    // let change = (result.quarters * .25) + (result.dimes * .1) + (result.nickels * .05);
    // amountInMachine = change;

    emptyMachine();

    //display change
    let changeString = "";
    if (result.quarters != 0)
        changeString += " Quarters: " + result.quarters;
    if (result.dimes != 0)
        changeString += " Dimes: " + result.dimes;
    if (result.nickels != 0)
        changeString += " Nickels: " + result.nickels;
    $("#changeMessage").text(changeString);


}

function clickChangeReturn(e) {
    e.preventDefault();

    //empty messages
    emptyMessages();

    //empty current selction
    $("#itemIdSelected").text("");
    currentId = null;

    //void highlights
    $(".selection").css("border", "1px solid black");

    if (amountInMachine == 0) {
        //send alert
        alert("No Money In Machine");
        return;
    }

    let amountToBreakDown = amountInMachine;
    let quarters = 0;
    let dimes = 0;
    let nickels = 0;

    //break down change


    quarters = Math.floor(amountToBreakDown / 0.25);
    amountToBreakDown = amountToBreakDown % 0.25;

    dimes = Math.floor(amountToBreakDown / 0.10);
    amountToBreakDown = amountToBreakDown % 0.10;
    //need to round up here
    nickels = Math.floor(amountToBreakDown / 0.05);
    amountToBreakDown = amountToBreakDown % 0.05;

    //display change
    let changeString = "";
    if (quarters != 0)
        changeString += " Quarters: " + quarters;
    if (dimes != 0)
        changeString += " Dimes: " + dimes;
    if (nickels != 0)
        changeString += " Nickels: " + nickels;

    $("#changeMessage").text(changeString);

    emptyMachine();
};

function handleDocumentReady() {
    ds.getItems(refreshItems, errorItems);
    $(document).on("click", ".selection", selectItem);
    $(document).on("click", ".btn-primary", addMoney); //passing e
    $(document).on("click", ".btn-success", clickMakePurchase);
    $(document).on("click", ".btn-secondary", clickChangeReturn);

    //highlight on hover
    $(document).on({
        mouseenter: function() {
            $(this).css("background-color", "CornflowerBlue");
        },
        mouseleave: function() {
            $(this).css("background-color", "");
        }
    }, ".selection"); //pass the element as an argument to .on
};

$(document).ready(handleDocumentReady);