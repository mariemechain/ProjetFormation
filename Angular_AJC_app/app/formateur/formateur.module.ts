import { NgModule } from '@angular/core';

import { FormateursService } from './formateurs.service';
import { FormateurComponent } from './formateur.component';


import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';


const routesFormateur: Routes = [
{ path: 'formateur', component: FormateurComponent },
// { path: 'formateur/:nom/:prenom/:ca', component:FormateurComponent }
];

@NgModule({
    imports: [
      FormsModule,
      BrowserModule,
      RouterModule.forChild(routesFormateur),
      HttpModule,
    ],
    providers: [

        FormateursService
    ],

    declarations: [

        FormateurComponent,
        // ClientPipe,


    ],

})
export class FormateurModule { }
