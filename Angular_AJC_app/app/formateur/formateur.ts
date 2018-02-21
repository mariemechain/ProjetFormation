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
public email: string = "inconnu";
public tel: string = "inconnu";
public dateNaissance: string = "inconnu";
public adresse: string ="22 rue de l'inconnu";

  constructor() {
}


}
