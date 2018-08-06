import { Injectable } from '@angular/core';
import { GlobalService } from "./global.service";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Subject } from 'rxjs';

@Injectable()
export class UserService {

  private $user: Subject<{}> = new Subject();
  private headers;
  private globalURL;

  constructor(private globalService : GlobalService,
              private http : HttpClient) {

    this.headers = new HttpHeaders();
    this.headers.set('Content-Type', 'application/json');
    this.globalURL = this.globalService.getServerURL();
  }

  public login(user) {
    const req = this.http.post(this.globalURL + "user/signin", user, {headers: this.headers});
    const sub = req.subscribe(
      next => this.$user.next(next)
    );


    return this.$user;
  }

}
