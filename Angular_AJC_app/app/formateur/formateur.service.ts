import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AppConfigService } from '../app-config.service';
import { Formateur } from './formateur';

@Injectable()
export class FormateurService {
     private formateur: Formateur;

    constructor(private appConfig: AppConfigService, private http: Http) {

    }


    // public findById(id: number) {
    //   this.http.get(this.appConfig.uri + "/formateur/"+id).subscribe(resp => this.formateur =  resp.json());
    //   this.expertises = this.formateur.expertises;
    //   return this.expertises;
    // }



}
