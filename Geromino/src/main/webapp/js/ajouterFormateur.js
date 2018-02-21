
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
	var div2 = document.getElementById("patience");
	if (type == "Formateur") { 
	div.style.display="block"; 
	div2.style.display="block";
	} else { 
	div.style.display="none";
	div2.style.display="none";
	} 
	}