import { LoginComponent } from './components/login/login.component';
import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import {UserDetailsComponent} from "./components/user-details/user-details.component";
import {GlobalService} from "./service/global.service";

export const appRoutes: Routes =[
    {path: 'login', component: LoginComponent},
    {path: 'user/:username', component: UserDetailsComponent, canActivate: [GlobalService]}
];
