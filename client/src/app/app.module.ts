import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FlexLayoutModule } from '@angular/flex-layout';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule, MatFormFieldModule, MatInputModule, MatButtonModule, MatToolbarModule } from '@angular/material';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http'
import { FormsModule } from "@angular/forms";

import { appRoutes } from './app.router';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { UserDetailsComponent } from './components/user-details/user-details.component';

import { StorageService } from "./service/storage.service";
import { GlobalService } from "./service/global.service";
import { UserService } from "./service/user.service";
import { AuthService } from "./service/auth.service";

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
    FormsModule
  ],
  providers: [
    StorageService,
    GlobalService,
    UserService,
    AuthService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
