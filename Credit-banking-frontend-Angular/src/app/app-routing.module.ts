import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import {LoginComponent} from "./login/login.component";
import {AdminTemplateComponent} from "./admin-template/admin-template.component";
import {AuthenticationGuard} from "./guards/authentication.guard";
import {NotAuthorizedComponent} from "./not-authorized/not-authorized.component";
import {authorizationGuard} from "./guards/authorization.guard";

const routes: Routes = [
  {path : '',redirectTo : '/login',pathMatch :"full"},
  {path : 'login',component : LoginComponent},
  {path : "admin" , component : AdminTemplateComponent , canActivate : [AuthenticationGuard] , children : [
      {
        path: 'add-customer',
        canActivate: [AuthenticationGuard, authorizationGuard],
        data: { role: "ADMIN" }
      },

      { path: 'notAuthorized', component: NotAuthorizedComponent }
    ]},


  { path: '', redirectTo: '/customers', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
