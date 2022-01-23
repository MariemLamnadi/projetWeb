var id = 0;
$(document).ready(function () {
  $.ajax({
        url: "CreneauController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            remplir(data);
           
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }});
 $("#add").click(function () {
        var heurDebut = $("#heurDebut").val();
        var heurFin = $("#heurFin").val();
        if (id === 0)
        {
            $.ajax({
                url: "CreneauController",
                   data: {heurDebut:heurDebut, heurFin:heurFin },
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    remplir(data);
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
            });
        } else
        {
            $.ajax({
                url: "CreneauController",
                 data: {op: "update", id:id , heurDebut: heurDebut, heurFin: heurFin},
                type: 'POST',
                success: function (data, textStatus, jqXHR) {
                    remplir(data);
                    id = 0;
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    console.log(textStatus);
                }
            });
        }

    });
       $("#content").on("click", ".delete", function () {

        var id = $(this).closest('tr').find('td').eq(0).text();
        $.ajax({
        url: "CreneauController",
        data: {op: "delete", id:id},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            remplir(data);
            
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }
    });

    });
    
    $("#content").on("click", ".update", function () {
        //alert($(this).attr('val'));         
        id = $(this).closest('tr').find('td').eq(0).text();
        var heurDebut= $(this).find('td:eq(1)').text();
        var heurFin = $(this).find('td:eq(2)').text();
        $("#heurDebut").val(heurDebut);
        $("#heurFin").val(heurFin);
     

    });
        $("#table").on("click", "tbody tr", function() {
             
        id = $(this).closest('tr').find('td').eq(0).text();
        var heurDebut= $(this).find('td:eq(1)').text();
        var heurFin = $(this).find('td:eq(2)').text();

        $("#heurDebut").val(heurDebut);
        $("#heurFin").val(heurFin);
    
        
});
    
     
 function remplir(data) {
        var ligne = "";
        for (var i = 0; i < data.length; i++) {
            
            ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].heurDebut + "</td><td>" + data[i].heurFin + "</td><td><button class ='delete  btn btn-custon-rounded-four btn-danger' val='"+ data[i].id +"'>Supprimer</i></button> <button  class ='update  btn btn-custon-rounded-four btn-primary'  val='"+ data[i].id +"'>Modifier</button></td></tr>";
        }
 $("#content").html(ligne);
}

});