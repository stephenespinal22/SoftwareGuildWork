var DataService = function() {
    var self = this;

    self.getFiveDay = function (zipCode, callback, myErrorFunc) {
        $.ajax({
          url: 'https://api.openweathermap.org/data/2.5/weather?zip=' + zipCode + ',us&appid=81a43d491be65ebc3ef085d6d6e6365b',
          method: 'GET',
          success: callback,
          error: myErrorFunc
        });
      };
};
// looks good to me
//HECTORRRRRRRRRRRRRRRRRR


