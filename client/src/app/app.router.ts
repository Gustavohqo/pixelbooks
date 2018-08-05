import { LoginComponent } from './components/login/login.component';
import { ModuleWithProviders } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";

export const appRoutes: Routes =[
    {path: 'login', component: LoginComponent},
];