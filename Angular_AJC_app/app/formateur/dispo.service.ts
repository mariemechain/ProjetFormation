import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AppConfigService } from '../app-config.service';
import { Formateur } from './formateur';

@Injectable()
export class DispoService {
     private disponibilites: Array<Disponibilite>;

    constructor(private appConfig: AppConfigService, private http: Http) {

    }


    public findAll() {
      if(this.disponibilites == null){
        this.refresh();
      return new Array<Disponibilite>();
           }
      else{
        return this.disponibilites;
      }

    }
    public refresh(){
      this.http
      .get(this.appConfig.uri +"/formateur/dispo")
      .subscribe(resp => this.disponibilites = resp.json());
    }

    public findById(id: number) {
        for (let d of this.disponibilites) {
            if (d.id == id) {
                return d;
            }
        }

        return null;
    }


    public save(d: Disponibilite) {
      if(d.id == null){
        this.http.post(this.appConfig.uri + "/formateur/dispo", d).subscribe(resp => this.refresh());
      }else{
          this.http.put(this.appConfig.uri + "/formateur/dispo"+d.id, d).subscribe(resp => this.refresh());
      }
    }

    public delete(d: Disponibilite) {
         this.http.delete(this.appConfig.uri + "/formateur/dispo" + d.id).subscribe(resp => this.refresh());
    }
}
