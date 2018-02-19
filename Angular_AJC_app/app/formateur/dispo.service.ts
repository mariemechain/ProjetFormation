import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AppConfigService } from '../app-config.service';
import { Formateur } from './formateur';

@Injectable()
export class DispoService {
     private formateurs: Array<Formateur>;

    constructor(private appConfig: AppConfigService, private http: Http) {

    }


    public findAll() {
      if(this.formateurs == null){
        this.refresh();
      return new Array<Formateur>();
           }
      else{
        return this.formateurs;
      }

    }
    public refresh(){
      this.http
      .get(this.appConfig.uri +"/formateur")
      .subscribe(resp => this.formateurs = resp.json());
    }

    public findById(id: number) {
        for (let formateur of this.formateurs) {
            if (formateur.id == id) {
                return formateur;
            }
        }

        return null;
    }


    public save(f: Formateur) {
      if(f.id == null){
        this.http.post(this.appConfig.uri + "/formateur", f).subscribe(resp => this.refresh());
      }else{
          this.http.put(this.appConfig.uri + "/formateur/"+f.id, f).subscribe(resp => this.refresh());
      }
    }

    public delete(formateur: Formateur) {
         this.http.delete(this.appConfig.uri + "/formateur/" + formateur.id).subscribe(resp => this.refresh());
    }
