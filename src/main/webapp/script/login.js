$(document).ready(function() {
	function login() {
		if ($('#login').val() == "" && $('#login').val() == "") {
			alert("Remplir Les champs Obligatoirement");
			return false;


		} else if ($('#login').val() == "") {
			alert("Remplir Le champ  login Obligatoirement");
			return false;

		} else if ($('#password').val() == "") {
			alert("Remplir Le champ  password Obligatoirement");
			return false;

		}

		var sdata = {
			login: $('#login').val(),
			password: $('#password').val()
		};
		$.ajax({
			url: "UserController",
			type: "POST",
			data: sdata,
			dataType: 'JSON',
			success: function(data) {

				if (data.status === true) {
					window.location.replace("Dashbord.jsp");
				}
				else {
					alert("Données incorrectes");
					return false;
				}
			}
		})
	}
	$("#connect").click(function() {
		login();
	});
})