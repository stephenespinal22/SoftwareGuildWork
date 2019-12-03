var DataService = function() {
    var self = this;

    self.getItems = function(callback, myErrorFunc) {
        $.ajax({
            url: 'http://localhost:8080/items',
            method: 'GET',
            success: callback,
            error: myErrorFunc
        });
    };

    self.buyItem = function(money, itemId, callback, myErrorFunc) {
        $.ajax({
            url: 'http://localhost:8080/money/' + money + '/item/' + itemId,
            method: 'GET',
            success: callback,
            error: myErrorFunc
        });
    };
};