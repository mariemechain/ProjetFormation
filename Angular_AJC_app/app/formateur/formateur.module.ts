import { NgModule } from '@angular/core';

import { FormateurService } from './formateur.service';

import { DispoComponent } from './dispo.component';
import { DispoService } from './dispo.service';
import { ExpertiseService } from './expertise.service';
import { ConnexionComponent } from './connexion.component';

import { LoginRouteGuard } from './login-route-guard';

import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { NgbdDatepickerRange } from './datepicker-range';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';



const routesFormateur: Routes = [
{ path: 'formateur/dispo', component: DispoComponent,canActivate: [LoginRouteGuard] },
{ path: 'formateur/connexion', component: ConnexionComponent},
{ path: '',redirectTo: 'formateur/connexion',pathMatch: 'full'}
// { path: 'formateur/:nom/:prenom/:ca', component:FormateurComponent }
];

@NgModule({
    imports: [
      FormsModule,
      BrowserModule,
      RouterModule.forChild(routesFormateur),
      HttpModule,
      NgbModule.forRoot()

    ],
    providers: [

        FormateurService,
        DispoService,
        ExpertiseService,
        LoginRouteGuard

    ],

    declarations: [


        DispoComponent,
        ConnexionComponent,
        NgbdDatepickerRange,


    ],

})
export class FormateurModule { }
