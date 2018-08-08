import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {
  MatCardModule,
  MatFormFieldModule,
  MatInputModule,
  MatButtonModule,
  MatToolbarModule,
  MatIconModule
} from '@angular/material';
import { RouterModule } from '@angular/router';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http'
import { FormsModule } from "@angular/forms";

import { appRoutes } from './app.router';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';

import { StorageService } from "./service/storage.service";
import { GlobalService } from "./service/global.service";
import { UserService } from "./service/user.service";
import { AuthService } from "./service/auth.service";
import {HeaderTokenInterceptor} from "./service/interceptor/handle-header-token-interceptor";
import {BookService} from "./service/book.service";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    UserDetailsComponent
  ],
  imports: [
    BrowserModule,
    FlexLayoutModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatToolbarModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    FormsModule,
    MatIconModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HeaderTokenInterceptor,
      multi: true
    },
    StorageService,
    GlobalService,
    UserService,
    AuthService,
    BookService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
