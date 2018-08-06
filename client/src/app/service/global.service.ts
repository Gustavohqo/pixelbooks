import { Injectable } from '@angular/core';

@Injectable()
export class GlobalService {
  private serverURL : String;

  constructor() {
    this.serverURL = 'http://localhost:4201/';
  }

  public getServerURL() {
    return this.serverURL;
  }
}
