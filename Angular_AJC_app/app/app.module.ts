import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { FormateurModule } from './formateur/formateur.module'
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';



import { AppConfigService } from './app-config.service';



import { AppComponent } from './app.component';
import { HomeComponent } from './home.component';



const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  // { path: '**', component: PageNotFoundComponent }
];

@NgModule({
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpModule,
    FormateurModule,
  ],
  providers: [
    AppConfigService,
  ],

  declarations: [
    AppComponent,
    HomeComponent,
  ],

  bootstrap: [ AppComponent ]
})
export class AppModule { }
