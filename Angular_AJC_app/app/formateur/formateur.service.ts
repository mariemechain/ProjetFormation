import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AppConfigService } from '../app-config.service';
import { Formateur } from './formateur';
import { Router } from '@angular/router';


@Injectable()
export class FormateurService {
     private formateur: Formateur;

    constructor(private appConfig: AppConfigService, private http: Http, private router: Router) {

    }


    // public findById(id: number) {
    //   this.http.get(this.appConfig.uri + "/formateur/"+id).subscribe(resp => this.formateur =  resp.json());
    //   this.expertises = this.formateur.expertises;
    //   return this.expertises;
    // }



    public connect(login: string, motDePasse: string){
  		this.http.post(this.appConfig.uri +"formateur/connexion", {login: login}{motDePasse: motDePasse}).subscribe(resp=> {
  																							this.formateur = resp.json().formateur;
  																							this.router.navigate(['home']);
  																						});
  	}


}
