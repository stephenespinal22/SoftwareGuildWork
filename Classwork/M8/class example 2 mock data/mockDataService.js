var DataService = function () {
    var self = this;
    var item = [
      {
        id: 0,
        name: 3,
        price: 3.12,
        quantity: 1
      }
    ];
    self.getAllItems = function (callback, myErrorFunc) {
      callback(item);
    }
    self.vendItem = function (itemID, amount, callback, myErrorFunc) {
      if (item[0].id != itemID) {
        myErrorFunc({ message: "Please Select Item" });
      } else if (item[0].quantity == 0) {
        myErrorFunc({ message: "SOLD OUT!!!" });
      } else if (item[0].price > amount) {
        myErrorFunc({ message: "Please Deposit 1 million dollars" });
      } else {
        callback({
          quaters: 1,
          dimes: 0,
          nickles: 0,
          pennies: 0
        });
      }
    }
  }
  var ds = new DataService();
  function refreshItemView(items){
    // do something with items
  }
  ds.getAllItems(refreshItemView)