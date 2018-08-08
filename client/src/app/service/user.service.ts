import { Injectable } from '@angular/core';
import { GlobalService } from "./global.service";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Subject } from 'rxjs';

@Injectable()
export class UserService {

  private $auth: Subject<{}> = new Subject();
  private headers;
  private globalURL;



  constructor(private globalService : GlobalService,
              private http : HttpClient) {
    this.globalURL = this.globalService.getServerURL();
  }

  public login(user) {
    const observable = this.http.post(this.globalURL + "user/signin", user, {headers: this.headers});

    observable.subscribe(
        next => {
          next["username"] = user.username;
          this.globalService.storeCurrentUser(next);
          this.$auth.next(next);
        }
      );

    return this.$auth;
  }

  public getUser() {
    return this.http.get(this.globalURL + "user/" + this.globalService.getUsername());
  }

  public isAuthenticated(){
    return this.globalService.getAccessToken();
  }
}
