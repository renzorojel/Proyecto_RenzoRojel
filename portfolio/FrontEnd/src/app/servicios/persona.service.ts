import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Persona } from '../interfaces/persona';
import { Observable } from 'rxjs';
import { api } from '../api/api';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  url:string = api.apiURL

  constructor( private http: HttpClient) { } 

  obtenerPersonas (): Observable<Persona[]> {
    return this.http.get<Persona[]>(this.url+"obtener/personas")
  }

  editarPersona (persona: Persona): Observable<Persona> {
    const url= this.url + "editar/persona/"+persona.id
    return this.http.put<Persona>(url,persona);
  }
}