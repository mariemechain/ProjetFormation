import { Router } from '@angular/router';
import { Component} from '@angular/core';
import { FormateurService } from './formateur/formateur.service';
import { Formateur } from './formateur/formateur'

@Component({
selector: 'home',
templateUrl: 'app/home.component.html'
})


export class HomeComponent {

constructor ( private formateurService: FormateurService) {}


}
