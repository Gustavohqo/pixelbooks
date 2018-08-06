import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public user;

  constructor(private userService : UserService) {
    this.user = {};
  }

  ngOnInit() {
  }

  private singin() {
    console.log(this.user);
    this.userService.login(this.user).subscribe(
      next => console.log(next)
    )
  }

}
