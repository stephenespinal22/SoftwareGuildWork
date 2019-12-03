var DataService = function () {
    var self = this;
    let counter = 2;
    let dvdList = [
      {
        dvdId: 1,
        title: 'Matrix',
        releaseYear: '1999',
        director: 'The Wachowski Brothers',
        rating: 'R'
      }
    ];
    
    self.getDvds = function(){
      return dvdList;
    }
    self.addDvd = function(dvd){
      dvd.dvdId = ++counter;
      dvdList.push(dvd);
    }
    self.removeDvd = function (dvdId) {
      let dList = [];
      for (let i = 0; i < dvdList.length; i++) {
        const dvd = dvdList[i];
        if (dvd.dvdId != dvdId) {
          dList.push(dvd);
        }
      }
      dvdList = dList;
    }
    self.getDvdById = function (dvdId) {
      for (let i = 0; i < dvdList.length; i++) {
        const dvd = dvdList[i];
        if (dvd.dvdId == dvdId) {
          return dvd;
        }
      }
      return null;
    }
    self.updateDvd = function (dvd) {
      for (let i = 0; i < dvdList.length; i++) {
        if (dvdList[i].dvdId == dvd.dvdId) {
          dvdList[i] = dvd;
        }
      }
    }
  }