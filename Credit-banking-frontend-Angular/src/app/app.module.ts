import { NgModule } from "@angular/core"
import { BrowserModule } from "@angular/platform-browser"
import { HTTP_INTERCEPTORS, HttpClientModule } from "@angular/common/http"
import { FormsModule, ReactiveFormsModule } from "@angular/forms"
import { BrowserAnimationsModule } from "@angular/platform-browser/animations"
import { RouterModule, type Routes } from "@angular/router"

// Material Modules
import { MatToolbarModule } from "@angular/material/toolbar"
import { MatSidenavModule } from "@angular/material/sidenav"
import { MatButtonModule } from "@angular/material/button"
import { MatIconModule } from "@angular/material/icon"
import { MatListModule } from "@angular/material/list"
import { MatCardModule } from "@angular/material/card"
import { MatFormFieldModule } from "@angular/material/form-field"
import { MatInputModule } from "@angular/material/input"
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner"
import { MatTooltipModule } from "@angular/material/tooltip"
import { MatTableModule } from "@angular/material/table"
import { MatPaginatorModule } from "@angular/material/paginator"
import { MatSortModule } from "@angular/material/sort"
import { MatSelectModule } from "@angular/material/select"
import { MatDatepickerModule } from "@angular/material/datepicker"
import { MatNativeDateModule } from "@angular/material/core"

// Components
import { AppComponent } from "./app.component"
import { ClientListComponent } from "./client-list/client-list.component"
import { ClientDetailsComponent } from "./client-details/client-details.component"
import { LoginComponent } from "./login/login.component"
import { AdminTemplateComponent } from "./admin-template/admin-template.component"
import { NotAuthorizedComponent } from "./not-authorized/not-authorized.component"

// Guards
import { AuthenticationGuard } from "./guards/authentication.guard"
import { authorizationGuard } from "./guards/authorization.guard"

// Interceptors
import { appHttpInterceptor } from "./interceptors/app-http.interceptor"

const routes: Routes = [
  { path: "", redirectTo: "/login", pathMatch: "full" },
  { path: "login", component: LoginComponent },
  {
    path: "admin",
    component: AdminTemplateComponent,
    canActivate: [AuthenticationGuard],
    children: [
      { path: "", redirectTo: "dashboard", pathMatch: "full" },
      { path: "clients", component: ClientListComponent },
      // {
      //   path: "clients/new",
      //   component: ClientFormComponent,
      //   canActivate: [AuthenticationGuard, authorizationGuard],
      //   data: { role: "ADMIN" },
      // },
      // { path: "clients/:id", component: ClientDetailsComponent },
      // {
      //   path: "clients/:id/edit",
      //   component: ClientFormComponent,
      //   canActivate: [AuthenticationGuard, authorizationGuard],
      //   data: { role: "ADMIN" },
      // // },
      // { path: "credits", component: CreditListComponent },
      // {
      //   path: "credits/new",
      //   component: CreditFormComponent,
      //   canActivate: [AuthenticationGuard, authorizationGuard],
      //   data: { role: "ADMIN" },
      // },
      // { path: "credits/new/:clientId", component: CreditFormComponent },
      // { path: "credits/:id", component: CreditDetailsComponent },
      // {
      //   path: "credits/:id/edit",
      //   component: CreditFormComponent,
      //   canActivate: [AuthenticationGuard, authorizationGuard],
      //   data: { role: "ADMIN" },
      // },
      // { path: "credits/:creditId/remboursements", component: RemboursementListComponent },
      // {
      //   path: "credits/:creditId/remboursements/new",
      //   component: RemboursementFormComponent,
      //   canActivate: [AuthenticationGuard, authorizationGuard],
      //   data: { role: "ADMIN" },
      // },
      // {
      //   path: "remboursements/:id/edit",
      //   component: RemboursementFormComponent,
      //   canActivate: [AuthenticationGuard, authorizationGuard],
      //   data: { role: "ADMIN" },
      // },
      { path: "notAuthorized", component: NotAuthorizedComponent },
    ],
  },
  { path: "**", redirectTo: "/login" },
]

@NgModule({
  declarations: [
    AppComponent,
    ClientListComponent,
    // ClientDetailsComponent,
    // ClientFormComponent,
    // CreditListComponent,
    // CreditDetailsComponent,
    // CreditFormComponent,
    // RemboursementListComponent,
    // RemboursementFormComponent,
    // DashboardComponent,
    NotAuthorizedComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot(routes),
    BrowserAnimationsModule,
    // Material Modules
    MatToolbarModule,
    MatSidenavModule,
    MatButtonModule,
    MatIconModule,
    MatListModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatProgressSpinnerModule,
    MatTooltipModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
    MatSelectModule,
    MatDatepickerModule,
    MatNativeDateModule,
    LoginComponent,
    AdminTemplateComponent,
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: appHttpInterceptor, multi: true }],
  bootstrap: [AppComponent],
})
export class AppModule {}
