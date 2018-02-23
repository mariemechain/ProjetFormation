import { Router } from '@angular/router';
import { Component, ElementRef} from '@angular/core';
import { Disponibilite } from './disponibilite';
import { DispoService } from './dispo.service';
import { FormateurService } from './formateur.service';
import { NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';
import { NgbdDatepickerRange } from './datepicker-range';


@Component({
  templateUrl: 'app/formateur/dispo.component.html'
})

export class DispoComponent {
  private dated: Date ;
  private datef: Date ;
  private dispo: Disponibilite;


  constructor(private dispoService: DispoService, private service: FormateurService, private el: ElementRef) {
    //console.log(el.nativeElement.querySelector('ngbd-datepicker-range'));
  }


  public addDispo() {
    // this.picker.save();
    // console.log(this.picker.fromDate);
    // this.dated = this.picker.fromDate;
    // this.datef = this.picker.toDate;
    // this.dispo = new Disponibilite(this.dated,this.datef);
    // this.dispo.formateur = this.service.formateur;
    // this.dispo.formateur.id = this.service.formateur.id;
    // // this.dispoService.save(this.dispo);

  }



  public editer(d: Disponibilite) {
    this.dispo = d;
  }

  public supprimer(d: Disponibilite) {
    this.dispoService.delete(d);
  }

}
