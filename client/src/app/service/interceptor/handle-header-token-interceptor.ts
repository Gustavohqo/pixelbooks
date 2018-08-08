import { Injectable } from '@angular/core';

import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';

import {Observable} from "rxjs";
import {StorageService} from "../storage.service";

@Injectable()
export class HeaderTokenInterceptor implements HttpInterceptor {
  constructor(private storageService: StorageService) {}

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    let token = this.storageService.getAccessToken();

    if (token) {
      console.log("INTERCEPTOR: ", token);
      request = request.clone({
        setHeaders: {
          'Authorization': this.storageService.getAccessToken()
        }
      });
    }

    return next.handle(request);
  }
}
