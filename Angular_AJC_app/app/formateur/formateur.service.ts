import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AppConfigService } from '../app-config.service';
import { Formateur } from './formateur';
import { Router } from '@angular/router';


@Injectable()
export class FormateurService {
     public formateur: Formateur;
     public IsConnected: boolean = false;
    constructor(private appConfig: AppConfigService, private http: Http, private router: Router) {

    }


    // public findById(id: number) {
    //   this.http.get(this.appConfig.uri + "/formateur/"+id).subscribe(resp => this.formateur =  resp.json());
    //   this.expertises = this.formateur.expertises;
    //   return this.expertises;
    // }



    public connect(login: string, motDePasse: string){
  		this.http.post(this.appConfig.uri +"/formateur/connexion/" + login + "/" + motDePasse,{} ).subscribe(resp=> {
                                                if (resp["_body"] != "" ){
                                                  this.formateur = resp.json();
                                                  this.IsConnected = true;
                                                  this.router.navigate(['home']);

                                                }

  																						});
  	}

    public Deconnexion(){
      this.IsConnected = false;
      this.router.navigate(['']);
    }

    public isConnectedIn(){
      return this.IsConnected;
    }


}
