function test(objSelect) {
    
    if(objSelect.options[objSelect.selectedIndex].value =="Formateur") {
      document.getElementById("titre").display = "block";
    } else  {
      document.getElementById("titre").display = "none";
    }
   }