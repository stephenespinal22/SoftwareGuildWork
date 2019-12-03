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
function formatRow(dvd) {
  return `<tr>
  <td>${dvd.title}</td>
  <td>${dvd.releaseYear}</td>
  <td>${dvd.director}</td>
  <td>${dvd.rating}</td>
  <td>
    <a href="#" data-dvdid='${dvd.dvdId}' class='deleteDvd'><i class="fa fa-trash"></i></a>
    <a href="#" data-dvdid='${dvd.dvdId}' class='editDvd'><i class="fa fa-pencil" aria-hidden="true"></i></a>
  </td>
</tr>`;
}
function refreshTable(dvds) {
  let dvdTable = $("#dvdTable>tbody");
  dvdTable.empty();
  for (let i = 0; i < dvds.length; i++) {
    const dvd = dvds[i];
    $(dvdTable).append(formatRow(dvd));
  }
}
function removeDvd(dvdId) {
  let dList = [];
  for (let i = 0; i < dvdList.length; i++) {
    const dvd = dvdList[i];
    if (dvd.dvdId != dvdId) {
      dList.push(dvd);
    }
  }
  dvdList = dList;
}
$(document).ready(function () {
  // alert('test');
  refreshTable(dvdList);
  //submit attached to form #addDvd is the whole form
  //we are doing a method on another method
  $(document).on("submit", "#addDvd", function (e) {
    e.preventDefault(); // stop the browser from reloading the page
    //so this is refering to the form
    let form = $(this);
    let dvd = {
      dvdId: ++counter,
      title: $("#title").val(),
      releaseYear: $("#releaseYear").val(),
      director: $("#director").val(),
      rating: $("#rating").val()
    };
    setTimeout(function () {
      dvdList.push(dvd);
      refreshTable(dvdList);
      $(form)[0].reset();
    }, 500)
  });
  $(document).on('click', ".deleteDvd", function (e) {
    e.preventDefault();
    var dvdId = $(this).data('dvdid');
    removeDvd(dvdId);
    refreshTable(dvdList);
  });
});