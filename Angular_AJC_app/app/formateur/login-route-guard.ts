import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';
import { FormateurService } from './formateur.service';
import { Router } from '@angular/router';

@Injectable()
export class LoginRouteGuard implements CanActivate {

  constructor(private loginService: FormateurService, private router: Router) {}

  canActivate() {
    if (this.loginService.isConnectedIn() == false ){
      this.router.navigate(['']);
    }
    return this.loginService.isConnectedIn();
  }
}
