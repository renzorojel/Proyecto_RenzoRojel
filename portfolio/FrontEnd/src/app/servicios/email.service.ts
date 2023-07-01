import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Email } from '../interfaces/email';
import { Observable } from 'rxjs';
import { api } from '../api/api';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  url:string = api.apiURL

  constructor( private http: HttpClient) { }

  enviarEmail (datos: Email): Observable<Email> {
    return this.http.post<Email>(this.url+"enviarmail",datos)
  }
}
