import { NgModule } from '@angular/core';

import { FormateurService } from './formateur.service';
import { FormateurComponent } from './formateur.component';
import { DispoComponent } from './dispo.component';
import { DispoService } from './dispo.service';
import { ExpertiseService } from './expertise.service';

import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { NgbdDatepickerRange } from './datepicker-range';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

const routesFormateur: Routes = [
{ path: 'formateur', component: FormateurComponent },
{ path: 'formateur/dispo', component: DispoComponent },
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
        ExpertiseService

    ],

    declarations: [

        FormateurComponent,
        DispoComponent,
        NgbdDatepickerRange


    ],

})
export class FormateurModule { }
