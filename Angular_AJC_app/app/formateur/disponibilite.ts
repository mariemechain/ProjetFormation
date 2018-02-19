
export class Disponibilite {
public dateDebut : Date;
public dateFin : Date;
public id: number;

constructor(date1:Date, date2:Date){
  this.dateDebut = date1;
  this.dateFin = date2;
}

}
