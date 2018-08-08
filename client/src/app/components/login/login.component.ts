import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user;

  constructor(private userService : UserService,
              private route : ActivatedRoute,
              private router : Router) {
    this.user = {};
  }

  ngOnInit() {
  }

  private singin() {
    console.log(this.user);
    this.userService.login(this.user).subscribe(next => {
      this.router.navigate(["/user/"+ this.user.username]);

    },
    error => console.log("login com sucesso") );
  }

}
