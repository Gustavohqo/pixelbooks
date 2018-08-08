import { Injectable } from '@angular/core';

@Injectable()
export class StorageService {
  constructor() {
  }

  public storeUser(authUser) {
    localStorage.setItem('access_token', 'Bearer ' + authUser.token);
    localStorage.setItem('username', authUser.username);
  }

  public getAccessToken() {
    return localStorage.getItem('access_token');
  }

  public getUsername () {
    return localStorage.getItem('username');
  }
}
