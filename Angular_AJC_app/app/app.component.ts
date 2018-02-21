import { Component } from '@angular/core';
import { FormateurService } from './formateur/formateur.service';
@Component({
    selector: 'eshop-app',
    templateUrl: 'app/app.component.html'
})
export class AppComponent {
  constructor(private service: FormateurService) {
  }
}
