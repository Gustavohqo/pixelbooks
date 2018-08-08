import { Injectable } from '@angular/core';

import {
  CanActivate,
  Router,
  ActivatedRouteSnapshot,
  RouterStateSnapshot
} from '@angular/router';

import { UserService } from './user.service'
import { Observable } from "rxjs";

@Injectable()
export class AuthService implements CanActivate {

  constructor(
    private userService: UserService,
    private router: Router
  ) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | boolean {
    if (! this.userService.isAuthenticated()) {
      this.router.navigate(['/']);
      return false;
    }

    return true;
  }
}
