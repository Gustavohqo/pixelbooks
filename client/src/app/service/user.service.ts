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
    const observable = this.http.post(this.globalURL + "user/signin", user, {headers: this.headers})

    observable.subscribe(
        next => {
          next["username"] = user.username;
          console.log(next);
          this.globalService.storeCurrentUser(next);
        }
      );

    return observable;
  }


  public isAuthenticated(){
    return this.globalService.getAccessToken();
  }
}
