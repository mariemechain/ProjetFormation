import { Disponibilite } from './disponibilite';
import { Expertise } from './expertise';



export class Formateur {
public disponibilites: Array<Disponibilite>;
public expertises: Array<Expertise>;
public titre: string;
public patience: number;
public prenom: string;
public nom: string;
public id: number;
public email: string ;
public telephone: string ;
public date: string;
public adresse: string ;

  constructor(id?: number) {
    this.id = id;
}


}
