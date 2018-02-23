import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AppConfigService } from '../app-config.service';
import { Formateur } from './formateur';
import { FormateurService } from './formateur.service';
import { Disponibilite } from './disponibilite';
@Injectable()
export class DispoService {


    constructor(private appConfig: AppConfigService, private http: Http,private service: FormateurService ) {

    }


    // public findAll() {
    //   if(this.disponibilites == null){
    //     this.refresh();
    //   return new Array<Disponibilite>();
    //        }
    //   else{
    //     return this.disponibilites;
    //   }
    //
    // }
    public refresh(){

    }

    // public findById(id: number) {
    //     for (let d of this.disponibilites) {
    //         if (d.id == id) {
    //             return d;
    //         }
    //     }
    //
    //     return null;
    // }


    public save(d: Disponibilite) {
      if(d.id == null){
        this.http.post(this.appConfig.uri + "/formateur/dispo", d).subscribe(resp => this.service.formateur.disponibilites.push(resp.json()));
      }else{
          this.http.put(this.appConfig.uri + "/formateur/dispo/"+d.id, d).subscribe(resp => this.refresh());
      }
    }

    public delete(d: Disponibilite) {
      var index = this.service.formateur.disponibilites.indexOf(d);
         this.http.delete(this.appConfig.uri + "/formateur/dispo/" + d.id).subscribe(resp =>
           this.service.formateur.disponibilites.splice(index,1));
    }
}
