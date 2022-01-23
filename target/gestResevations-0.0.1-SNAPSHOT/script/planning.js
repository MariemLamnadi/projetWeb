
$(document).ready(function() {
	let evenements = [];
	$.ajax({
		url: "OccupationController",
		data: { op: "load" },
		type: 'POST',
		success: function(data, textStatus, jqXHR) {

			for (var i = 0; i < data.length; i++) {
				console.log(data[i].statut);
				var date = new Date(data[i].date);
				var dd = date.getDate();
				var mm = date.getMonth() + 1; //January is 0!

				var yyyy = date.getFullYear();
				if (dd < 10) {
					dd = '0' + dd;
				}
				if (mm < 10) {
					mm = '0' + mm;
				}
				date = yyyy + "-" + mm + "-" + dd;

				evenements.push({
					title: data[i].salle.code +  "/" +data[i].creneaux.heurDebut 
					+ " - " + data[i].creneaux.heurFin,
					start: date,

					backgroundColor: "#5233FF"

				});
			}


			var calendarEl = document.getElementById('calendar');
			var calendar = new FullCalendar.Calendar(calendarEl, {
				initialView: 'dayGridMonth',
				events: evenements,


			});
			calendar.render();
		},
		error: function(jqXHR, textStatus, errorThrown) {
			console.log(textStatus);
		}
	});

});