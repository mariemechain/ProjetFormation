//function test(objSelect) {
//	var titre = $('input[name="titre"]');
//
//    if(objSelect.value == "Formateur") {
//      ajouterPersonnel.getElementById(titre).display = "block";
//    } else  {
//    ajouterPersonnel.getElementById(titre).display = "none";
//    }
//    
//    
//   }

function changementType() {
	var type = document.getElementById("personnels").value;
	var div = document.getElementById("titre");
	var patience = document.getElementById("patience");
	if (type == "Formateur") {
		div.style.display = "block";
		patience.style.display = "block";
	} else {
		div.style.display = "none";
		patience.style.display = "none";
	}
}

function activerBouton() {
	var type = document.getElementById("personnels").value;
	var bout = document.getElementById("bouton1");

	if (type == "Formateur" || type == "Gestionnaire" || type == "Technicien"
			|| type == "Administrateur") {
		bout.disabled = false;
		bout.style = "cursor: pointer;"
	} else {
		bout.disabled = true;
		bout.style = "cursor: not-allowed;"
	}
}
