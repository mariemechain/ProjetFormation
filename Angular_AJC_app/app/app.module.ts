import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';

import { AppConfigService } from './app-config.service';

import { HttpModule } from '@angular/http';
import { FormateurModule } from './client/client.module';


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
    // HomeComponent,
  ],

  bootstrap: [ AppComponent ]
})
export class AppModule { }
