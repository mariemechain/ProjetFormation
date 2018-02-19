import { Matiere } from './matiere';
import { Formateur } from './formateur';

export class Expertise {
public niveau : Array<string> = new Array<string>('Debutant','Intermediaire','Avance','Expert');
public matiere : Matiere;
public formateur: Formateur;
public id: number;

constructor(){
}

}
