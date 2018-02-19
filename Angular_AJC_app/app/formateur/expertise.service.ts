import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AppConfigService } from '../app-config.service';
import { Expertise } from './expertise';

@Injectable()
export class ExpertiseService {
     private expertises: new Array<Expertise>;
     private formateur: Formateur;

    constructor(private appConfig: AppConfigService, private http: Http) {

    }

    public findById(id: number) {
        this.http.get(this.appConfig.uri + "/formateur/"+id).subscribe(resp => this.formateur =  resp.json());
        this.expertises = this.formateur.expertises;
        return this.expertises;

    }


}
