import { Component } from '@angular/core';
import { FormateurService } from './formateur.service';


@Component({
templateUrl: 'app/formateur/connexion.component.html'
})


export class ConnexionComponent {

  public login: string = "";
  public motDePasse: string = "";

  constructor(private formateurService: FormateurService) {
      }
  connexion(){
		this.formateurService.connect(this.login,this.motDePasse);
	}

}
