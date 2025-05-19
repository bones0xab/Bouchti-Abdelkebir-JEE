import { Component, type OnInit } from "@angular/core"
import type { ActivatedRoute, Router } from "@angular/router"
import type { Client } from "../model/client.model"
import type { ClientService } from "../services/client.service"

interface Credit {
  id: number
  montant: number
  duree: number
  taux: number
  dateCreation: string
  type: string
}

@Component({
  selector: "app-client-details",
  templateUrl: "./client-details.component.html",
  styleUrls: ["./client-details.component.css"],
  standalone: true
})
export class ClientDetailsComponent implements OnInit {
  client: Client | null = null
  credits: Credit[] = []
  loading = true
  loadingCredits = false
  error = ""
  showDeleteConfirm = false

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private clientService: ClientService,
  ) {}

  ngOnInit(): void {
    this.loadClient()
  }

  loadClient(): void {
    const id = Number(this.route.snapshot.paramMap.get("id"))
    if (id) {
      this.clientService.getClient(id).subscribe({
        next: (data) => {
          this.client = data
          this.loading = false
          this.loadClientCredits(id)
        },
        error: (err) => {
          this.error = "Erreur lors du chargement du client"
          this.loading = false
          console.error(err)
        },
      })
    } else {
      this.error = "ID client invalide"
      this.loading = false
    }
  }

  loadClientCredits(clientId: number): void {
    this.loadingCredits = true
    // Assuming you have a method in your service to get credits by client ID
    // If not, you'll need to implement this in your service
    this.clientService.getClientCredits(clientId).subscribe({
      next: (data) => {
        this.credits = data
        this.loadingCredits = false
      },
      error: (err) => {
        console.error("Erreur lors du chargement des crédits", err)
        this.loadingCredits = false
      },
    })
  }

  editClient(): void {
    if (this.client) {
      this.router.navigate(["/admin/clients", this.client.id, "edit"])
    }
  }

  addCredit(): void {
    if (this.client) {
      this.router.navigate(["/admin/credits/new", this.client.id])
    }
  }

  confirmDelete(): void {
    this.showDeleteConfirm = true
  }

  cancelDelete(): void {
    this.showDeleteConfirm = false
  }

  deleteClient(): void {
    if (this.client) {
      this.clientService.deleteClient(this.client.id!).subscribe({
        next: () => {
          this.router.navigate(["/admin/clients"])
        },
        error: (err) => {
          this.error = "Erreur lors de la suppression du client"
          console.error(err)
        },
      })
    }
  }

  goBack(): void {
    this.router.navigate(["/admin/clients"])
  }

  viewCredit(creditId: number): void {
    // Navigate to credit details page
    this.router.navigate(["/admin/credits", creditId])
  }

  getCreditTypeLabel(type: string): string {
    switch (type) {
      case "PERSONNEL":
        return "Personnel"
      case "PROFESSIONNEL":
        return "Professionnel"
      case "IMMOBILIER":
        return "Immobilier"
      default:
        return type
    }
  }

  formatDate(dateString: string): string {
    return new Date(dateString).toLocaleDateString("fr-FR")
  }

  formatMontant(montant: number): string {
    return new Intl.NumberFormat("fr-FR", { style: "currency", currency: "EUR" }).format(montant)
  }
}
