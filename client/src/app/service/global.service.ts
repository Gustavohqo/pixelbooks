import { Injectable } from '@angular/core';
import {StorageService} from "./storage.service";

@Injectable()
export class GlobalService {
  private serverURL : String;

  constructor(private storageService : StorageService) {
    this.serverURL = 'http://localhost:4201/';
  }

  public getServerURL() {
    return this.serverURL;
  }

  public storeCurrentUser(authUser) {
    this.storageService.storeUser(authUser);
  }

  public getUsername() {
    return this.storageService.getUsername();
  }

  public getAccessToken() {
    return this.storageService.getAccessToken();
  }
}
