var id = 0;
$(document).ready(function() {
	$.ajax({
		url: "UserController",
		data: { op: "load" },
		type: 'POST',
		success: function(data, textStatus, jqXHR) {
			remplir(data);

		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});
	$("#add").click(function() {

		var login = $("#login").val();
		var password = $("#password").val();
		var role = $("#role").val();
		if (id === 0) {
			$.ajax({
				url: "UserController",
				data: { login: login, password: password, role: role },
				type: 'POST',
				success: function(data, textStatus, jqXHR) {
					remplir(data);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log(textStatus);
				}
			});
		} else {
			$.ajax({
				url: "UserController",
				data: { op: "update", id: id, login: login, password: password, role: role },
				type: 'POST',
				success: function(data, textStatus, jqXHR) {
					remplir(data);
					id = 0;
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log(textStatus);
				}
			});
		}

	});


	$("#contenu").on("click", ".update", function() {
		//alert($(this).attr('val'));

		id = $(this).closest('tr').find('td').eq(0).text();
		var login = $("#login").val(login);
		var password = $("#password").val(password);
		var role = $("#password").val(role);
		$("#login").val(login);
		$("#password").val(password);
		$("#role").val(role);


	});
	$("#table").on("click", "tbody tr", function() {
		id = $(this).closest('tr').find('td').eq(0).text();
		var login = $(this).find('td:eq(1)').text();
		var password = $(this).find('td:eq(2)').text();
		var role = $(this).find('td:eq(3)').text();
		$("#login").val(email);
		$("#password").val(password);
		$("#role").val(role);

	});


	function remplir(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {

			ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].login + "</td><td>" + data[i].password + "</td><td>" + data[i].role + "</td><td> <button  class ='update btn btn-custon-rounded-four btn-primary'  val='" + data[i].id + "'>Modifier</button></td></tr>";
		}
		$("#contenu").html(ligne);
	}

});