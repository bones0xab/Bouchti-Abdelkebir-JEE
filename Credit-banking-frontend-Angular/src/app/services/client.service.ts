import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {catchError, Observable, retry} from 'rxjs';
import { Client } from '../model/client.model';
import {environment} from "../../envirenements/environment";
import {Credit} from "../model/credit.model";

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  private apiUrl = 'http://localhost:8085/api/clients';

  constructor(private http: HttpClient) { }

  getClients(): Observable<Client[]> {
    return this.http.get<Client[]>(this.apiUrl);
  }

  getClient(id: number): Observable<Client> {
    return this.http.get<Client>(`${this.apiUrl}/${id}`);
  }

  createClient(client: Client): Observable<Client> {
    return this.http.post<Client>(this.apiUrl, client);
  }

  updateClient(client: Client): Observable<Client> {
    return this.http.put<Client>(`${this.apiUrl}/${client.id}`, client);
  }

  deleteClient(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }

  getClientCredits(clientId: number): Observable<Credit[]> {

    return this.http.get<Credit[]>(`${environment.apiUrl}/credits/client/${clientId}`).pipe(
      retry(1),
    )
  }


}
