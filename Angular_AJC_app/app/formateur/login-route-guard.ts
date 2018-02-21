import { CanActivate } from '@angular/router';
import { Injectable } from '@angular/core';
import { FormateurService } from './formateur.service';

@Injectable()
export class LoginRouteGuard implements CanActivate {

  constructor(private loginService: FormateurService) {}

  canActivate() {
    return this.loginService.isConnectedIn();
  }
}
