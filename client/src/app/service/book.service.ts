import { Injectable } from '@angular/core';
import { GlobalService } from "./global.service";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Subject } from 'rxjs';
import {Book} from "../entity/Book";

@Injectable()
export class BookService {
  private globalURL;

  constructor(private globalService : GlobalService,
              private http : HttpClient) {
    this.globalURL = this.globalService.getServerURL();
  }

  public search(searchParam) {
    const query = {params: {search: searchParam}};

    return this.http.get<Book[]>(this.globalURL + "book", query);
  }
}
