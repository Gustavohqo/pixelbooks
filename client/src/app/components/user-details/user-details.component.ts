import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {BookService} from "../../service/book.service";
import {Book} from "../../entity/Book";

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent implements OnInit {
  public user;

  public searchParam;
  public books: Book[];

  constructor(private userService : UserService,
              private bookService : BookService) {
    this.user = {};

    this.userService.getUser().subscribe(
      next => {
        this.user = next;
      }
    )
  }

  ngOnInit() {
  }

  public bookSearch() {
    this.bookService.search(this.searchParam).subscribe(
      next =>{
        console.log(next);
        this.books = next;
      }
    )
  }

}
