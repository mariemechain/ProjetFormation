import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AppConfigService } from '../app-config.service';
import { Formateur } from './formateur';

@Injectable()
export class FormateurService {
     private formateurs: Array<Formateur>;

    constructor(private appConfig: AppConfigService, private http: Http) {

    }


    public findById(id: number) {
        for (let formateur of this.formateurs) {
            if (formateur.id == id) {
                return formateur;
            }
        }

        return null;
    }



}
