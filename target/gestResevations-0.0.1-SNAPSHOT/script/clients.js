var id = 0;
$(document).ready(function () {
  $.ajax({
        url: "ClientController",
        data: {op: "load"},
        type: 'POST',
        success: function (data, textStatus, jqXHR) {
            remplir(data);
           
        },
        error: function (jqXHR, textStatus, errorThrown) {
            console.log(textStatus);
        }});
 $("#add").click(function () {
        var nom = $("#nom").val();
        var prenom = $("#prenom").val();
        var cin = $("#cin").val();
        var email = $("#email").val();
        var password = $("#password").val();
        if (id === 0)
        {
            $.ajax({
                url: "ClientController",
                data: {nom: nom, prenom: prenom ,cin:cin ,email :email, password:password},
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
                url: "ClientController",
                  data: {op: "update", id: id, nom: nom, prenom: prenom ,cin:cin ,email :email,password:password},
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
       $("#contenu").on("click", ".delete", function () {

        var id = $(this).closest('tr').find('td').eq(0).text();
        $.ajax({
        url: "ClientController",
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
    
    $("#contenu").on("click", ".update", function () {
        //alert($(this).attr('val'));
          
         id = $(this).closest('tr').find('td').eq(0).text();
         var nom = $("#nom").val(code);
         var prenom = $("#prenom").val(prenom);
         var cin = $("#cin").val(cin);
         var email =$("#email").val(email);
         var password = $("#password").val(password);
          $("#nom").val(nom);
        $("#prenom").val(prenom);
        $("#cin").val(cin);
        $("#email").val(email);
        $("#password").val(password);
        
     

    });
        $("#table").on("click", "tbody tr", function() {        
         id = $(this).closest('tr').find('td').eq(0).text();
        var nom= $(this).find('td:eq(1)').text();    
        var prenom = $(this).find('td:eq(2)').text();
        var cin =  $(this).find('td:eq(3)').text();
        var email =  $(this).find('td:eq(4)').text();
        var password =  $(this).find('td:eq(5)').text();
        $("#nom").val(nom);
        $("#prenom").val(prenom);
        $("#cin").val(cin);
        $("#email").val(email);
        $("#password").val(password);
        
});
    
     
 function remplir(data) {
        var ligne = "";
        for (var i = 0; i < data.length; i++) {
            
            ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].nom + "</td><td>" + data[i].prenom + "</td><td>" + data[i].cin+ "</td><td>" + data[i].email+ "</td><td>" + data[i].password + "</td><td><button class =' delete  btn btn-custon-rounded-four btn-danger' val='"+ data[i].id +"'>Supprimer</i></button> <button  class ='update btn btn-custon-rounded-four btn-primary'  val='"+ data[i].id +"'>Modifier</button></td></tr>";
        }
 $("#contenu").html(ligne);
}

});