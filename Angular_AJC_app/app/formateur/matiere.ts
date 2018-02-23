import { Expertise } from './expertise';


export class Matiere {
public id: number;
public titre: string;
public duree:  number;
public objectifs: string;
public prerequis: Array<Matiere>;
public contenu: string;
public expertise: Array<Expertise>;


  constructor() {
}


}
