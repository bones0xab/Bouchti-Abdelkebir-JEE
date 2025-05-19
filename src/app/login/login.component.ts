import { Component, type OnInit } from "@angular/core"
import { FormBuilder, type FormGroup, ReactiveFormsModule, Validators} from "@angular/forms"
import  { AuthService } from "../services/auth.service"
import  { Router } from "@angular/router"
import {MatFormField} from "@angular/material/form-field";
import {MatCard, MatCardActions, MatCardContent, MatCardHeader} from "@angular/material/card";
import {MatProgressSpinner} from "@angular/material/progress-spinner";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.css"],
  imports: [
    MatFormField,
    MatCardHeader,
    MatCard,
    MatCardContent,
    MatCardActions,
    MatProgressSpinner,
    ReactiveFormsModule
  ],
  standalone: true
})
export class LoginComponent implements OnInit {
  formLogin!: FormGroup
  errorMessage = ""
  isLoading = false

  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
    private router: Router,
  ) {}

  ngOnInit() {
    // Redirect if already logged in
    if (this.authService.isAuthenticated) {
      this.router.navigateByUrl("/admin")
      return
    }

    this.formLogin = this.fb.group({
      username: this.fb.control("", [Validators.required]),
      password: this.fb.control("", [Validators.required]),
    })
  }

  login() {
    if (this.formLogin.invalid) {
      return
    }

    this.isLoading = true
    this.errorMessage = ""

    const username = this.formLogin.value.username
    const pwd = this.formLogin.value.password

    this.authService.login(username, pwd).subscribe({
      next: (data) => {
        this.authService.loadProfile(data)
        this.router.navigateByUrl("/admin")
      },
      error: (err) => {
        this.isLoading = false
        if (err.status === 401) {
          this.errorMessage = "Nom d'utilisateur ou mot de passe incorrect"
        } else {
          this.errorMessage = "Une erreur est survenue lors de la connexion"
        }
        console.error(err)
      },
      complete: () => {
        this.isLoading = false
      },
    })
  }
}
