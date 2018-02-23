import {Component} from '@angular/core';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
import { Disponibilite } from './disponibilite';
import { DispoService } from './dispo.service';
import { FormateurService } from './formateur.service';
import { Router } from '@angular/router';
import { Formateur } from './formateur';


const equals = (one: NgbDateStruct, two: NgbDateStruct) =>
one && two && two.year === one.year && two.month === one.month && two.day === one.day;

const before = (one: NgbDateStruct, two: NgbDateStruct) =>
!one || !two ? false : one.year === two.year ? one.month === two.month ? one.day === two.day
? false : one.day < two.day : one.month < two.month : one.year < two.year;

const after = (one: NgbDateStruct, two: NgbDateStruct) =>
!one || !two ? false : one.year === two.year ? one.month === two.month ? one.day === two.day
? false : one.day > two.day : one.month > two.month : one.year > two.year;

@Component({
  selector: 'ngbd-datepicker-range',
  templateUrl: 'app/formateur/datepicker-range.html',
  styles: [`
    .custom-day {
      text-align: center;
      padding: 0.185rem 0.25rem;
      display: inline-block;
      height: 2rem;
      width: 2rem;
    }
    .custom-day.focused {
      background-color: #e6e6e6;
    }
    .custom-day.range, .custom-day:hover {
      background-color: rgb(2, 117, 216);
      color: white;
    }
    .custom-day.faded {
      background-color: rgba(2, 117, 216, 0.5);
    }
    `]
  })
  export class NgbdDatepickerRange {

    hoveredDate: NgbDateStruct;

    public fromDate: NgbDateStruct;
    public toDate: NgbDateStruct;
    private dispo: Disponibilite;
    private dated: Date;
    private datef: Date;


    constructor(calendar: NgbCalendar,private dispoService: DispoService, private service: FormateurService, private router: Router) {
      this.fromDate = calendar.getToday();
      this.toDate = calendar.getNext(calendar.getToday(), 'd', 10);
    }

    public addDispo() {

      this.dated = new Date(this.fromDate.year + "-" + this.fromDate.month + "-" + this.fromDate.day);
      this.datef = new Date(this.toDate.year + "-" + this.toDate.month + "-" + this.toDate.day);
      this.dispo = new Disponibilite(this.dated,this.datef);

      this.dispo.formateur = new Formateur(this.service.formateur.id);
      this.dispoService.save(this.dispo);

    }

    public editDispo(d: Disponibilite){
      this.dated = new Date(this.fromDate.year + "-" + this.fromDate.month + "-" + this.fromDate.day);
      this.datef = new Date(this.toDate.year + "-" + this.toDate.month + "-" + this.toDate.day);
      this.dispo = new Disponibilite(this.dated,this.datef);
      this.dispo.id =  d.id;
      this.dispo.formateur = new Formateur(this.service.formateur.id);



      if (this.service.formateur.disponibilites.includes(d)){
          this.service.formateur.disponibilites.splice(this.service.formateur.disponibilites.indexOf(d),1,this.dispo);
          this.dispoService.save(this.dispo);
      }
    }


    public deleteDispo(d: Disponibilite) {
      console.log(d.id);
      this.dispoService.delete(d);
    }

    onDateChange(date: NgbDateStruct) {
      if (!this.fromDate && !this.toDate) {
        this.fromDate = date;
      } else if (this.fromDate && !this.toDate && after(date, this.fromDate)) {
        this.toDate = date;
      } else {
        this.toDate = null;
        this.fromDate = date;
      }
    }


    public save() {
      console.log(this.fromDate);
    }

    isHovered = date => this.fromDate && !this.toDate && this.hoveredDate && after(date, this.fromDate) && before(date, this.hoveredDate);
    isInside = date => after(date, this.fromDate) && before(date, this.toDate);
    isFrom = date => equals(date, this.fromDate);
    isTo = date => equals(date, this.toDate);
  }
