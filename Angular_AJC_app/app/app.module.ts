import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormateurModule } from './formateur/formateur.module'
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';

import { AppConfigService } from './app-config.service';


import { LoginRouteGuard } from './formateur/login-route-guard';
import { AppComponent } from './app.component';
import { HomeComponent } from './home.component';
import { NgbdDatepickerRange } from './formateur/datepicker-range';




const routes: Routes = [
  { path: 'home', component: HomeComponent, /*canActivate: [LoginRouteGuard]*/ }
  //{ path: '', redirectTo: 'home', pathMatch: 'full' },
  // { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    HttpModule,
    FormateurModule,

  ],
  providers: [
    AppConfigService,
    LoginRouteGuard,
    NgbdDatepickerRange

  ],

  declarations: [
    AppComponent,
    HomeComponent,

  ],

  bootstrap: [ AppComponent ]
})
export class AppModule { }
