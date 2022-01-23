var id = 0;
$(document).ready(function() {
	$.ajax({
		url: 'OccupationController',
		type: 'POST',
		data: { op: 'load' },
		success: function(data, textStatus, jqXHR) {
			remplirData(data);
		},
		error: function(data, textStatus, jqXHR) {
			console.log(textStatus);
		}
	});

	$("#ajouter").click(function() {
		var IDsalle = document.getElementById("IDsalle").value;
		var IDcreneaux = document.getElementById("IDcreneaux").value;
		var IDclient = document.getElementById("IDclient").value;
		var date = $('#date').val();
		console.log(IDsalle); console.log(IDcreneaux); console.log(IDclient)
		if (id === 0) {
			$.ajax({
				url: "OccupationController",
				data: { IDsalle: IDsalle, IDcreneaux: IDcreneaux, date: date, IDclient: IDclient },
				type: 'POST',
				success: function(data, textStatus, jqXHR){
					remplirData(data);
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log(textStatus);
				}
			});
		} else {
			$.ajax({
				url: "OccupationController",
				data: { id: id, IDsalle: IDsalle, IDcreneaux: IDcreneaux, date: date, IDclient: IDclient },
				type: 'POST',
				success: function(data, textStatus, jqXHR) {
					remplirData(data);
					id = 0;
				},
				error: function(jqXHR, textStatus, errorThrown) {
					console.log(textStatus);
				}
			});
		}

	});


	$("#content").on("click", ".update", function() {
		//alert($(this).attr('val'));

		id = $(this).closest('tr').find('td').eq(0).text();
		var date = $(this).closest('tr').find('td').eq(1).text();
		var IDsalle = $(this).closest('tr').find('td').eq(2).text();
		var IDcreneaux = $(this).closest('tr').find('td').eq(3).text();
		var IDclient = $(this).closest('tr').find('td').eq(4).text();

		$("#date").val(date);
		$("#IDsalle").val(IDsalle);
		$("#IDcreneaux").val(IDcreneaux);
		$("#IDclient").val(IDclient);
	});

	$("#content").on("click", ".delete", function() {

		id = $(this).closest('tr').find('td').eq(0).text();
		$.ajax({
			url: "OccupationController",
			data: { op: "delete", id: id },
			type: 'POST',
			success: function(data, textStatus, jqXHR) {
				remplirData(data);

			},
			error: function(jqXHR, textStatus, errorThrown) {
				console.log(textStatus);
			}
		});

	});

	$("#content").on("click", "tbody tr", function() {
		id = $(this).closest('tr').find('td').eq(0).text();
		var date = $(this).closest('tr').find('td').eq(1).text();
		var IDsalle = $(this).closest('tr').find('td').eq(2).text();
		var idcreneaux = $(this).closest('tr').find('td').eq(3).text();

		var idclient = $(this).closest('tr').find('td').eq(4).text();
		var dateF = new Date(date);
		var dd = dateF.getDate();
		var mm = dateF.getMonth() + 1; 

		var yyyy = dateF.getFullYear();
		if (dd < 10) {
			dd = '0' + dd;
		}
		if (mm < 10) {
			mm = '0' + mm;
		}
		dateF = yyyy + '-' + mm + '-' + dd;

		$("#date").val(dateF);
		$("#IDsalle").val(IDsalle);
		$("#IDcreneaux").val(idcreneaux);
		$("#IDclient").val(idclient);

	});
	function remplirData(data) {
		var ligne = "";
		for (var i = 0; i < data.length; i++) {
			ligne += "<tr><td>" + data[i].id + "</td><td>" + data[i].date + "</td><td>" + data[i].salle.code + "</td><td>" + data[i].creneaux.heurDebut + " - " + data[i].creneaux.heurFin + "</td>" + "<td>" + data[i].client.cin + "</td> <td><button type='button' class='delete btn btn-custon-rounded-four btn-danger'val ='" + data[i].id + "'>Supprimer</button><button style='margin-left:5px' type='button' class='update btn btn-custon-rounded-four btn-primary' val ='" + data[i].id + "'>Modifier</button></td></tr>";
		}
		$("#content").html(ligne);
	}

});