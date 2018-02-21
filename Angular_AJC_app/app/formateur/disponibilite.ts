
export class Disponibilite {
  public date_debut : Date;
  public date_fin : Date;
  public id: number;

  constructor(date1:Date, date2:Date){
    this.date_debut = date1;
    this.date_fin = date2;
  }

}
