import { Router } from '@angular/router';
import { Component} from '@angular/core';
import { Disponibilite } from './disponibilite';
import { DispoService } from './dispo.service';
import { FormateurService } from './formateur.service';

@Component({
  templateUrl: 'app/formateur/dispo.component.html'
})

export class DispoComponent {
  private dated: Date = new Date(118, 1, 19);
  private datef: Date = new Date(118, 1, 20);
  private dispo: Disponibilite = new Disponibilite(this.dated,this.datef);



  constructor(private dispoService: DispoService, private formateurService: FormateurService) { }


  public addDispo() {
    this.dispoService.save(this.dispo);
    this.dispo = new Disponibilite(this.dated,this.datef);
  }



  public editer(d: Disponibilite) {
    this.dispo = d;
  }

  public supprimer(d: Disponibilite) {
    this.dispoService.delete(d);
  }

}
