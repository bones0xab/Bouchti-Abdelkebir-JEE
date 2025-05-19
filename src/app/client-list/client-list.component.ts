import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Client } from '../model/client.model';
import { ClientService } from '../services/client.service';

@Component({
  selector: 'app-client-list',
  templateUrl: './client-list.component.html',
  styleUrls: ['./client-list.component.css']
})
export class ClientListComponent implements OnInit {
  clients: Client[] = [];
  loading = true;
  error = '';

  constructor(
    private clientService: ClientService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadClients();
  }

  loadClients(): void {
    this.loading = true;
    this.clientService.getClients().subscribe({
      next: (data: Client[]) => {
        this.clients = data;
        this.loading = false;
      },
      error: (err: any) => {
        this.error = 'Erreur lors du chargement des clients';
        this.loading = false;
        console.error(err);
      }
    });
  }

  viewClient(id: number): void {
    this.router.navigate(['/clients', id]);
  }

  editClient(id: number): void {
    this.router.navigate(['/clients', id, 'edit']);
  }

  deleteClient(id: number): void {
    if (confirm('Êtes-vous sûr de vouloir supprimer ce client?')) {
      this.clientService.deleteClient(id).subscribe({
        next: () => {
          this.loadClients();
        },
        error: (err: any) => {
          this.error = 'Erreur lors de la suppression du client';
          console.error(err);
        }
      });
    }
  }

  addClient(): void {
    this.router.navigate(['/clients/new']);
  }
}
