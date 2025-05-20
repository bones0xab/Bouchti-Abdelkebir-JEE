import { Component } from "@angular/core"
import {Router, RouterOutlet} from "@angular/router"
import  { AuthService } from "../services/auth.service"
import {MatSidenavContainer} from "@angular/material/sidenav";
import {MatNavList} from "@angular/material/list";
import {MatIcon} from "@angular/material/icon";
import {MatToolbar} from "@angular/material/toolbar";

@Component({
  selector: "app-admin-template",
  templateUrl: "./admin-template.component.html",
  styleUrls: ["./admin-template.component.css"],
  imports: [
    MatSidenavContainer,
    MatNavList,
    MatIcon,
    MatToolbar,
    RouterOutlet
  ],
  standalone: true
})
export class AdminTemplateComponent {
  constructor(
    public authService: AuthService,
    private router: Router,
  ) {}

  logout() {
    this.authService.logout()
    this.router.navigateByUrl("/login")
  }

  toggle() {

  }
}
