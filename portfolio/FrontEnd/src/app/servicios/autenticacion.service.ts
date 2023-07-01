import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs'; 
import { map } from 'rxjs/operators';
import { Credenciales } from '../interfaces/credenciales_login';
import { api } from '../api/api';
@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  url:string =api.apiURL;

  constructor( private http:HttpClient) { }

  iniciarSesion(credenciales:Credenciales):Observable<any>{
    
    return this.http.post(this.url+"login", credenciales, {
      observe: 'response'
    }).pipe(map((response: HttpResponse <any>)=>{

      const body = response.body;
      const headers = response.headers;

      const bearerToken = headers.get('Authorization')!;
      const token = bearerToken.replace('Bearer ', '');

      sessionStorage.setItem('token', token);  
      return body;
    }))
  }

  getToken () {
  return sessionStorage.getItem('token');
  }

}