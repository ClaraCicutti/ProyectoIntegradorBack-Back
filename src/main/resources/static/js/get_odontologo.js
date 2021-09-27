//$(document).ready(function(){
//    (function(){
//        $.ajax({
//            type : "GET",
//            url : "/odontologos",
//            success: function(response){
//              $.each(response, (i, odontologo) => {
//
//
//                let get_More_Info_Btn = '<button' +
//                                            ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
//                                            ' type="button" class="btn btn-info btn_id">' +
//                                            odontologo.id +
//                                            '</button>';
//
//                let tr_id = 'tr_' + odontologo.id;
//                let odontologoRow = '<tr id=\"' + tr_id + "\"" + '>' +
//                          '<td>' + get_More_Info_Btn + '</td>' +
//                          '<td class=\"td_first_name\">' + odontologo.nombre.toUpperCase() + '</td>' +
//                          '<td class=\"td_last_name\">' + odontologo.apellido + '</td>' +
//                          '<td class=\"td_matricula\">' + odontologo.matricula + '</td>' +
//                          '</tr>';
//                $('#odontologoTable tbody').append(odontologoRow);
//              });
//            },
//            error : function(e) {
//              alert("ERROR: ", e);
//              console.log("ERROR: ", e);
//            }
//        });
//    })();
//
//    (function(){
//        let pathname = window.location.pathname;
//        if (pathname == "/odontologos.html") {
//            $(".nav .nav-item a:last").addClass("active");
//        }
//    })();
//});

window.addEventListener('load', function (event) {

  event.preventDefault();
  const url = '/odontologos';
  const settings = {
    method: 'GET'
  }

  fetch(url, settings)
    .then(response => response.json())
    .then(data => {
      for (odontologo of data) {
        console.log(odontologo)

        let deleteButton = '<button' +
          ' id=' + '\"' + 'btn_delete_' + odontologo.id + '\"' +
          ' type="button" onclick="deleteBy(' + odontologo.id + ')" class="btn btn-danger btn_delete">' +
          '&times' +
          '</button>';

        let get_More_Info_Btn = '<button' +
          ' id=' + '\"' + 'btn_id_' + odontologo.id + '\"' +
          ' type="button" onclick="findBy(' + odontologo.id + ')" class="btn btn-info btn_id">' +
          odontologo.id +
          '</button>';

        let tr_id = 'tr_' + odontologo.id;
        let odontologoRow = '<tr id=\"' + tr_id + "\"" + '>' +
          '<td>' + get_More_Info_Btn + '</td>' +
          '<td class=\"td_nombre\">' + odontologo.nombre + '</td>' +
          '<td class=\"td_apellido\">' + odontologo.apellido + '</td>' +
          '<td class=\"td_matricula\">' + odontologo.matricula + '</td>' +
          '<td>' + deleteButton + '</td>' +
          '</tr>';
        console.log(odontologoRow);
        console.log($('#odontologoTable tbody'));
        $('#odontologoTable tbody').append(odontologoRow);
      };

    })
})

  // (function () {
  //   let pathname = window.location.pathname;
  //   if (pathname == "/odontologos.html") {
  //     document.querySelector(".nav .nav-item a:last").addClass("active");
  //   }
  // })