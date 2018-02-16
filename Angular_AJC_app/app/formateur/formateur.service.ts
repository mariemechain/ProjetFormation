import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { AppConfigService } from '../app-config.service';

@Injectable()
export class FormateurService {
    // private formateurs: Array<formateur>;

    constructor(private appConfig: AppConfigService, private http: Http) {
        // this.save(new Client("TEST", "Titi"));
        // this.save(new Client("BLOB", "Fish"));
        // this.save(new Client("PLANET", "Venus"));
    }

    //
    // public findAll() {
    //   if(this.clients == null){
    //     this.refresh();
    //   return new Array<Client>();
    //        }
    //   else{
    //     return this.clients;
    //   }
    //
    // }
    // public refresh(){
    //   this.http
    //   .get(this.appConfig.uri +"/client")
    //   .subscribe(resp => this.clients = resp.json());
    // }
    //
    // public findById(id: number) {
    //     for (let client of this.clients) {
    //         if (client.id == id) {
    //             return client;
    //         }
    //     }
    //
    //     return null;
    // }
    //
    //
    // public save(c: Client) {
    //   if(c.id == null){
    //     this.http.post(this.appConfig.uri + "/client", c).subscribe(resp => this.refresh());
    //   }else{
    //       this.http.put(this.appConfig.uri + "/client/"+c.id, c).subscribe(resp => this.refresh());
    //   }
    // }
    //
    // public delete(client: Client) {
    //      this.http.delete(this.appConfig.uri + "/client/" + client.id).subscribe(resp => this.refresh());
    // }
}
